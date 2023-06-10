package com.example.bookmyshowinjavaspringboot.Service;

import com.example.bookmyshowinjavaspringboot.models.Region;
import com.example.bookmyshowinjavaspringboot.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RegionService {
    private RegionRepository regionRepository;
    @Autowired
    public RegionService(RegionRepository regionRepository){
        this.regionRepository = regionRepository;
    }
    public Region createRegion(String name){
        Optional<Region> optionalRegion = regionRepository.findByName(name);
        if(optionalRegion.isPresent()){
            throw new RuntimeException();
        }
        Region region = new Region();
        region.setName(name);
        region.setMovies(new ArrayList<>());
        Region savedRegion = regionRepository.save(region);
        return savedRegion;
    }
}
