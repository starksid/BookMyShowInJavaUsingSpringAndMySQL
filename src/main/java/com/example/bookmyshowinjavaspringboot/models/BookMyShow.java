package com.example.bookmyshowinjavaspringboot.models;

import com.example.bookmyshowinjavaspringboot.repository.*;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class BookMyShow extends BaseModel {
    @OneToMany
    private List<Region> regionList;
    private MovieRepository movieRepository;
    private RegionRepository regionRepository;
    private ScreenRepository screenRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowSeatTypeRepository showSeatTypeRepository;
    private TheatreRepository theatreRepository;
    private UserRepository userRepository;
    private BookMyShow(){}
    public static Builder getBuilder(){
        return new Builder();
    }

    @Getter
    public static class Builder{
        MovieRepository movieRepository;
        RegionRepository regionRepository;
        ScreenRepository screenRepository;
        ShowRepository showRepository;
        ShowSeatRepository showSeatRepository;
        ShowSeatTypeRepository showSeatTypeRepository;
        TheatreRepository theatreRepository;
        UserRepository userRepository;
        public BookMyShow build(){
            BookMyShow bookMyShow = new BookMyShow();
            bookMyShow.setRegionList(new ArrayList<>());
            bookMyShow.showRepository = showRepository;
            bookMyShow.movieRepository = movieRepository;
            bookMyShow.regionRepository = regionRepository;
            bookMyShow.showSeatRepository = showSeatRepository;
            bookMyShow.userRepository = userRepository;
            bookMyShow.screenRepository = screenRepository;
            bookMyShow.theatreRepository = theatreRepository;
            return bookMyShow;
        }

        public Builder setMovieRepository(MovieRepository movieRepository) {
            this.movieRepository = movieRepository;
            return this;
        }

        public Builder setRegionRepository(RegionRepository regionRepository) {
            this.regionRepository = regionRepository;
            return this;
        }

        public Builder setScreenRepository(ScreenRepository screenRepository) {
            this.screenRepository = screenRepository;
            return this;
        }

        public Builder setShowRepository(ShowRepository showRepository) {
            this.showRepository = showRepository;
            return this;
        }

        public Builder setShowSeatRepository(ShowSeatRepository showSeatRepository) {
            this.showSeatRepository = showSeatRepository;
            return this;
        }

        public Builder setShowSeatTypeRepository(ShowSeatTypeRepository showSeatTypeRepository) {
            this.showSeatTypeRepository = showSeatTypeRepository;
            return this;
        }

        public Builder setTheatreRepository(TheatreRepository theatreRepository) {
            this.theatreRepository = theatreRepository;
            return this;
        }

        public Builder setUserRepository(UserRepository userRepository) {
            this.userRepository = userRepository;
            return this;
        }
    }









}
