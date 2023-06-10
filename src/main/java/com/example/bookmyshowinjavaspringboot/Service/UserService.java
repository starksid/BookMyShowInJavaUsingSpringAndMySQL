package com.example.bookmyshowinjavaspringboot.Service;

import com.example.bookmyshowinjavaspringboot.models.User;
import com.example.bookmyshowinjavaspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User signUp(String name, String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isPresent()){
            throw new RuntimeException();
        }
        User user = new User();
        user.setBookings(new ArrayList<>());
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder bCryptPasswordEncoder1 = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder1.encode(password));
        user.setCreatedAt(new Date());
        user.setLastModified(new Date());
        User savedUser = userRepository.save(user);
        return savedUser;
    }
    public User signIn(String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            throw new RuntimeException();
        }
        User user = optionalUser.get();
        BCryptPasswordEncoder bCryptPasswordEncoder1 = new BCryptPasswordEncoder();
        if(bCryptPasswordEncoder1.matches(password, user.getPassword())){
            return user;
        }
        throw new RuntimeException();
    }
}
