package com.example.bookmyshowinjavaspringboot.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BookMovieRequestDto {
    private int regionId;
    private int MovieId;
    private int theatreId;
    private int showId;
    private int showSeatTypeId;
    private int numberOfShowSeat;
    private String userName;
    private String email;
    private BookMovieRequestDto(){}
    public static Builder getBuilder(){
        return new Builder();

    }

    @Getter
    public static class Builder{
        private int regionId;
        private int MovieId;
        private int theatreId;
        private int showId;
        private int showSeatTypeId;
        private int numberOfShowSeat;
        private String userName;
        private String email;

        public BookMovieRequestDto build(){
            BookMovieRequestDto request = new BookMovieRequestDto();
            request.MovieId = getMovieId();
            request.numberOfShowSeat =getNumberOfShowSeat();
            request.regionId = getRegionId();
            request.showId = getShowId();
            request.showSeatTypeId = getShowSeatTypeId();
            request.email = getEmail();
            request.theatreId = getTheatreId();
            request.userName = getUserName();
            return request;
        }

        public void setRegionId(int regionId) {
            this.regionId = regionId;
        }

        public void setMovieId(int movieId) {
            MovieId = movieId;
        }

        public void setTheatreId(int theatreId) {
            this.theatreId = theatreId;
        }

        public void setShowId(int showId) {
            this.showId = showId;
        }

        public void setShowSeatTypeId(int showSeatTypeId) {
            this.showSeatTypeId = showSeatTypeId;
        }

        public Builder setNumberOfShowSeat(int numberOfShowSeat) {
            this.numberOfShowSeat = numberOfShowSeat;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
    }


}
