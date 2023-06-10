package com.example.bookmyshowinjavaspringboot.controller;

import com.example.bookmyshowinjavaspringboot.Service.UserService;
import com.example.bookmyshowinjavaspringboot.dto.ResponseStatus;
import com.example.bookmyshowinjavaspringboot.dto.UserSignUpRequestDto;
import com.example.bookmyshowinjavaspringboot.dto.UserSignUpResponseDto;
import com.example.bookmyshowinjavaspringboot.models.User;
import com.example.bookmyshowinjavaspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    public UserSignUpResponseDto signUp(UserSignUpRequestDto request){
        UserSignUpResponseDto response = new UserSignUpResponseDto();
        User user;
        try {
            user = userService.signUp(request.getName(), request.getEmail(), request.getPassword());


        }catch (Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
            throw new RuntimeException();
        }
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setUserId(user.getId());
        return response;
    }
}
