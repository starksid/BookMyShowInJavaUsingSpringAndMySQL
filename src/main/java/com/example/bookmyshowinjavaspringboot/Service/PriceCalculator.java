package com.example.bookmyshowinjavaspringboot.Service;

import com.example.bookmyshowinjavaspringboot.models.Show;
import com.example.bookmyshowinjavaspringboot.models.ShowSeat;
import com.example.bookmyshowinjavaspringboot.models.ShowSeatTypePrice;
import com.example.bookmyshowinjavaspringboot.repository.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculator {
    ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired
    public PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public int calcutalePrice(List<ShowSeat> showSeats, Show show){
        List<ShowSeatTypePrice> showSeatTypePrices = showSeatTypeRepository.findAllByShow(show);
        int amount = 0;
        for(ShowSeat showSeat : showSeats){
            for(ShowSeatTypePrice showSeatTypePrice : showSeatTypePrices){
                if(showSeat.getSeat().getSeatType().equals(showSeatTypePrice)){
                    amount+=showSeatTypePrice.getPrice();
                }
            }
        }
        return amount;
    }
}
