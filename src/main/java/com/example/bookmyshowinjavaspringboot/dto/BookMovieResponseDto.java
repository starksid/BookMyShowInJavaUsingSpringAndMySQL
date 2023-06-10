package com.example.bookmyshowinjavaspringboot.dto;

import com.example.bookmyshowinjavaspringboot.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {
    private Booking booking;
    private ResponseStatus responseStatus;


}
