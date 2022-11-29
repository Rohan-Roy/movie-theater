package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import com.jpmc.theater.entities.Customer;
import com.jpmc.theater.entities.Movie;
import com.jpmc.theater.entities.Reservation;
import com.jpmc.theater.entities.Shows;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {

    @Test
    void totalFee() {
        var customer = new Customer("John Doe");
        var showing = new Shows(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.now()
        );
        assertTrue(new Reservation(customer, showing, 3, 10).getAudienceCount() == 3);
    }
}
