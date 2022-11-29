package com.jpmc.theater.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name="shows", indexes = @Index(columnList = "sequenceOfTheDay"))
public class Shows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @OneToOne(targetEntity=Movie.class, fetch=FetchType.EAGER)
    private Movie movie;
    @Getter
    private int sequenceOfTheDay;
    @Getter
    private LocalDateTime showStartTime;

    public Shows(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    // private double calculateFee(int audienceCount) {
    //     return movie.calculateTicketPrice(this) * audienceCount;
    // }

    @Override
    public String toString() {
        return "Show Id: " + id + " Sequence: " + sequenceOfTheDay + " Start Time: " + showStartTime + " Movie Name: " + movie.getTitle();
    }
}
