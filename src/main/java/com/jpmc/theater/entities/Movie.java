package com.jpmc.theater.entities;

import java.time.Duration;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="movie")
@Getter
@Setter
@NoArgsConstructor
public class Movie {
    @Id
    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;
    private double discount;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}