package com.example.bookmyshowinjavaspringboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRegionResponseDto {
    private ResponseStatus responseStatus;
    private int regionId;
}
