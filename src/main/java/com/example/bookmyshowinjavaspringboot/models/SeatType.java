package com.example.bookmyshowinjavaspringboot.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class SeatType extends BaseModel {

    String name;


}
