package com.example.bookmyshowinjavaspringboot.repository;

import com.example.bookmyshowinjavaspringboot.models.Show;
import com.example.bookmyshowinjavaspringboot.models.ShowSeatTypePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatTypePrice, Integer> {

    List<ShowSeatTypePrice> findAllByShow(Show show);

    @Override
    ShowSeatTypePrice save(ShowSeatTypePrice entity);
}
