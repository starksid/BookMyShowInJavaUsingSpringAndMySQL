package com.example.bookmyshowinjavaspringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Seat extends BaseModel {
    private int num;
    private int rowVal;
    private int colVal;
    @ManyToOne
    private SeatType seatType;


}
