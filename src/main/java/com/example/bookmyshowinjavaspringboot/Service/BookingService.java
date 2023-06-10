package com.example.bookmyshowinjavaspringboot.Service;

import com.example.bookmyshowinjavaspringboot.models.*;
import com.example.bookmyshowinjavaspringboot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.management.RuntimeErrorException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    BookingRepository bookingRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;
    UserRepository userRepository;
    PriceCalculator priceCalculator;
    @Autowired
    public BookingService(
            BookingRepository bookingRepository,
            ShowRepository showRepository,
            ShowSeatRepository showSeatRepository,
            UserRepository userRepository,
            PriceCalculator priceCalculator
    ){
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.priceCalculator = priceCalculator;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(int showId, List<Integer> showSeatsId, int userId){
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new RuntimeException();
        }
        Show show = optionalShow.get();
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new RuntimeException();
        }
        User user = optionalUser.get();

        List<ShowSeat> savedShowSeats = new ArrayList<>();
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatsId);
        for(ShowSeat showSeat: showSeats){
            if(!(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) ||
                    (showSeat.getShowSeatStatus().equals(ShowSeatStatus.LOCKED) &&
                            (Duration.between(showSeat.getBlockedAt().toInstant(), new Date().toInstant()).toMinutes()>15

                    ))){
                throw new RuntimeException();
            }
        }

        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            savedShowSeats.add(showSeatRepository.save(showSeat));

        }

        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(savedShowSeats);
        booking.setUser(user);
        booking.setBookedAt(new Date());
        booking.setShow(show);
        booking.setBookingAmount(priceCalculator.calcutalePrice(savedShowSeats, show));
        booking.setPayments(new ArrayList<>());
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        Booking savedBooking = bookingRepository.save(booking);
        return savedBooking;






















    }
}
