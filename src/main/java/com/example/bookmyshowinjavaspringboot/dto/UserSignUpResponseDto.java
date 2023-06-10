package com.example.bookmyshowinjavaspringboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpResponseDto {
    private int userId;
    private ResponseStatus responseStatus;
}
