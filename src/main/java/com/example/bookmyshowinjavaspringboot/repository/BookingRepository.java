package com.example.bookmyshowinjavaspringboot.repository;

import com.example.bookmyshowinjavaspringboot.Service.BookingService;
import com.example.bookmyshowinjavaspringboot.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Override
    Optional<Booking> findById(Integer integer);

    @Override
    Booking save(Booking entity);
}
