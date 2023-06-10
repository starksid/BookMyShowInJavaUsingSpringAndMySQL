package com.example.bookmyshowinjavaspringboot.repository;

import com.example.bookmyshowinjavaspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    Optional<User> findById(Integer userID);
    Optional<User> findByEmail(String email);
    @Override
    User save(User entity);
}
