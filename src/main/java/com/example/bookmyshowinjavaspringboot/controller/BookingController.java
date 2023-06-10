package com.example.bookmyshowinjavaspringboot.controller;

import com.example.bookmyshowinjavaspringboot.Service.BookingService;
import com.example.bookmyshowinjavaspringboot.dto.BookMovieRequestDto;
import com.example.bookmyshowinjavaspringboot.dto.BookMovieResponseDto;
import com.example.bookmyshowinjavaspringboot.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    public BookMovieResponseDto bookMovie(BookMovieRequestDto request){
        BookMovieResponseDto response = new BookMovieResponseDto();
        Booking booking;
        return response;
    }
}
