package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;

import com.jpmc.theater.utilities.LocalDateProvider;

import org.junit.jupiter.api.Test;

public class LocalDateProviderTests {
    @Test
    void makeSureCurrentTime() {
        assertEquals(LocalDate.now(ZoneId.of("UTC")), LocalDateProvider.getSingleton().currentDate());
    }
}
