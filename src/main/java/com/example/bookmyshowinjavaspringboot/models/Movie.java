package com.example.bookmyshowinjavaspringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
public class Movie extends BaseModel {

    private String MovieName;
    @ManyToMany
    private List<Theatre> theatre;

}
