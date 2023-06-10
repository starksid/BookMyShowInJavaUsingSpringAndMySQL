package com.example.bookmyshowinjavaspringboot.controller;

import com.example.bookmyshowinjavaspringboot.Service.RegionService;
import com.example.bookmyshowinjavaspringboot.dto.AddRegionRequestDto;
import com.example.bookmyshowinjavaspringboot.dto.AddRegionResponseDto;
import com.example.bookmyshowinjavaspringboot.dto.ResponseStatus;
import com.example.bookmyshowinjavaspringboot.models.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegionController {
    RegionService regionService;
    @Autowired
    public RegionController(RegionService regionService){
        this.regionService = regionService;
    }
    public AddRegionResponseDto addRegion(AddRegionRequestDto request){
        AddRegionResponseDto response = new AddRegionResponseDto();
        Region region;
        try {
            region= regionService.createRegion(request.getName());
        }catch (Exception e){
            response.setResponseStatus(ResponseStatus.FAILURE);
            throw new RuntimeException();
        }
        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setRegionId(region.getId());
        return response;
    }
}
