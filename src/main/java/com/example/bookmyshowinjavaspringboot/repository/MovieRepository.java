package com.example.bookmyshowinjavaspringboot.repository;

import com.example.bookmyshowinjavaspringboot.models.Booking;
import com.example.bookmyshowinjavaspringboot.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Override
    Optional<Movie> findById(Integer integer);
    @Override
    Movie save(Movie entity);
}
