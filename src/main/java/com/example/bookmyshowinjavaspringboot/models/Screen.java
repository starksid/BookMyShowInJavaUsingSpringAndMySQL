package com.example.bookmyshowinjavaspringboot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
public class Screen extends BaseModel {

    private int number;
    private String name;
    @OneToMany
    private List<Seat> seats;

    @OneToMany
    private List<Show> shows;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    List<Features> features;

}
