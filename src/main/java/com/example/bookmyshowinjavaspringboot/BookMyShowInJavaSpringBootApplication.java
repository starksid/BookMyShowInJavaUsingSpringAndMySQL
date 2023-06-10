package com.example.bookmyshowinjavaspringboot;

import com.example.bookmyshowinjavaspringboot.controller.UserController;
import com.example.bookmyshowinjavaspringboot.dto.UserSignUpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowInJavaSpringBootApplication implements CommandLineRunner {
    @Autowired
    private UserController userController;

    @Override
    public void run(String... args) throws Exception {
        UserSignUpRequestDto requestDto = new UserSignUpRequestDto();
        requestDto.setName("Siddharth Agarwal");
        requestDto.setEmail("rkp.siddharth@gmail.com");
        requestDto.setPassword("password");
        userController.signUp(requestDto);
    }

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowInJavaSpringBootApplication.class, args);
    }

}
