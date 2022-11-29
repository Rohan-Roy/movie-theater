package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import javax.swing.text.Utilities;

import com.jpmc.theater.entities.Customer;
import com.jpmc.theater.entities.Reservation;
import com.jpmc.theater.utilities.LocalDateProvider;
import com.jpmc.theater.utilities.Util;

import org.junit.jupiter.api.Test;

public class TheaterTests {

    private final String FORMATTED_STRING = "(2 hours 0 minutes)";
    Theater theater = new Theater();
    Initializer initializer = new Initializer();
    Util util = new Util();

    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater();
        Customer john = new Customer("John Doe");
        // Reservation reservation = theater.reserve(john, 2, 4);
//        System.out.println("You have to pay " + reservation.getTotalFee());
        // assertEquals(reservation.totalFee(), 50);
    }

    @Test
    void printMovieSchedule() {
        // Theater theater = new Theater(LocalDateProvider.getSingleton());
        // initializer. .printSchedule();
    }

    @Test
    void testHumanReadableFormat(){
        assertEquals(FORMATTED_STRING, util.humanReadableFormat(Duration.ofHours(2)));
    }
}
