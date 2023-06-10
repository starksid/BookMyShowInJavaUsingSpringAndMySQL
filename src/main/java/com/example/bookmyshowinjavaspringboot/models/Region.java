package com.example.bookmyshowinjavaspringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
public class Region extends BaseModel {

    private String name;
    @ManyToMany
    private List<Movie> movies;



}
