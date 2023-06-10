package com.example.bookmyshowinjavaspringboot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Setter
@Getter
@Entity
public class Booking extends BaseModel {
    private int bookingNumber;
    private int bookingAmount;
    private Date bookedAt;
    @ManyToMany
    List<ShowSeat> showSeats;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<Payment> payments;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

}
