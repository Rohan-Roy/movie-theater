package com.jpmc.theater.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @NonNull
    @Getter
    @OneToOne(targetEntity=Customer.class, fetch = FetchType.EAGER)
    private Customer customer;
    @Getter
    @OneToOne(targetEntity=Shows.class, fetch=FetchType.EAGER)
    private Shows shows;
    @Getter
    private int audienceCount;
    @Getter
    private double ticketPrice;


    public Reservation(Customer customer, Shows shows, int audienceCount, double ticketPrice) {
        this.customer = customer;
        this.shows = shows;
        this.audienceCount = audienceCount;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString(){
        return "Reservation Id: " + id + "\nCustomer Detail: " + customer.toString() + "\n" + shows.toString() + "\nNumber of People: " + audienceCount; 
    }

}