package com.jpmc.theater;

import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.jpmc.theater.entities.Movie;
import com.jpmc.theater.entities.Shows;
import com.jpmc.theater.services.MovieService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieTests {

    @Mock
    MovieService movieService;

    @Test
    void specialMovieWith50PercentDiscount() {
        // Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Shows showing = Mockito.mock(Shows.class);
        // new Shows(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        when(movieService.calculateTicketPrice(showing, 1)).thenReturn(10d);
        assertEquals(10, movieService.calculateTicketPrice(showing, 1));

        System.out.println(Duration.ofMinutes(90));
    }

    void testHandlePlural(){
        
    }
}
