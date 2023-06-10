package com.example.bookmyshowinjavaspringboot.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
public class Theatre extends BaseModel {

    private String TheatreName;
    @OneToMany
    List<Screen> screens;


    @Enumerated(EnumType.ORDINAL)
    TheatreStatus theatreStatus;

}
