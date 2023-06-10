package com.example.bookmyshowinjavaspringboot.repository;

import com.example.bookmyshowinjavaspringboot.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    @Override
    Optional<Theatre> findById(Integer integer);

    @Override
    Theatre save(Theatre entity);
}
