package com.jpmc.theater.services;

import com.jpmc.theater.entities.Movie;
import com.jpmc.theater.entities.Shows;
import com.jpmc.theater.repositories.IMovieRepository;
import com.jpmc.theater.utilities.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    
    @Autowired
    IMovieRepository movieRepository;


    public Movie newMovie(Movie movie){
        return this.movieRepository.save(movie);
    }
    public double calculateTicketPrice(Shows showing, int specialCode) {
        return showing.getMovie().getTicketPrice() - getDiscount(showing.getMovie(), showing.getSequenceOfTheDay(), specialCode);
    }


    //TO DO - This method has to be replaced by the Drools engine
    public double getDiscount(Movie movie, int showSequence, int specialCode) {
        return movie.getDiscount();
        // double specialDiscount = 0;
        // if (Constants.MOVIE_CODE_SPECIAL == specialCode) {
        //     specialDiscount = movie.getTicketPrice() * 0.2;  // 20% discount for special movie
        // }

        // double sequenceDiscount = 0;
        // if (showSequence == 1) {
        //     sequenceDiscount = 3; // $3 discount for 1st show
        // } else if (showSequence == 2) {

        //     sequenceDiscount = 2; // $2 discount for 2nd show
        // }
//        else {
//            throw new IllegalArgumentException("failed exception");
//        }

        // biggest discount wins
        // return specialDiscount > sequenceDiscount ? specialDiscount : sequenceDiscount;
    }
}
