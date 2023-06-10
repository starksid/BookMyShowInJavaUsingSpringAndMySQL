package com.example.bookmyshowinjavaspringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ShowSeatTypePrice extends BaseModel {
    @ManyToOne
    Show show;
    @ManyToOne
    SeatType seatType;
    int price;
}
