package com.example.bookmyshowinjavaspringboot.repository;

import com.example.bookmyshowinjavaspringboot.models.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    @Override
    Optional<Region> findById(Integer integer);
    Optional<Region> findByName(String name);
    @Override
    Region save(Region entity);
}
