package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.jpmc.theater.entities.Movie;
import com.jpmc.theater.entities.Shows;
import com.jpmc.theater.services.MovieService;
import com.jpmc.theater.services.ShowsService;
import com.jpmc.theater.utilities.Constants;
import com.jpmc.theater.utilities.LocalDateProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class Initializer implements CommandLineRunner{

    @Autowired
    LocalDateProvider localDateProvider;

    @Autowired
    MovieService movieService;

    @Autowired
    ShowsService showsService;

    @Override
    public void run(String... args) throws Exception {
        var spiderMan = movieService.newMovie(new Movie(Constants.SPIDER_MAN, Duration.ofMinutes(90), 12.5, 1));
        var turningRed = movieService.newMovie(new Movie(Constants.TURNING_RED, Duration.ofMinutes(85), 11, 0));
        var theBatMan = movieService.newMovie(new Movie(Constants.THE_BATMAN, Duration.ofMinutes(95), 9, 0));


        showsService.newShows(List.of(
            new Shows(turningRed, 1, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(9, 0))),
            new Shows(spiderMan, 2, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(11, 0))),
            new Shows(theBatMan, 3, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(12, 50))),
            new Shows(turningRed, 4, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(14, 30))),
            new Shows(spiderMan, 5, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(16, 10))),
            new Shows(theBatMan, 6, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(17, 50))),
            new Shows(turningRed, 7, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(19, 30))),
            new Shows(spiderMan, 8, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(21, 10))),
            new Shows(theBatMan, 9, LocalDateTime.of(localDateProvider.currentDate(), LocalTime.of(23, 0)))
        ));
        
    }
    
}
