package com.example.bookmyshowinjavaspringboot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity(name = "shows")
public class Show extends BaseModel {

    Date StartTime;
    Date EndTime;


    @Enumerated(EnumType.ORDINAL)
    ShowStatus showStatus;
    @OneToMany
    List<ShowSeat> showSeats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Features> features;

}
