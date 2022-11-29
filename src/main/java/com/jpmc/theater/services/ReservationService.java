package com.jpmc.theater.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.jpmc.theater.entities.Customer;
import com.jpmc.theater.entities.Reservation;
import com.jpmc.theater.entities.Shows;
import com.jpmc.theater.repositories.IReservationRepository;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    
    @Autowired
    IReservationRepository reservationRepository;

    @Autowired
    MovieService movieService;

    @Autowired
    ShowsService showsService;

    @Autowired
    private KieSession kieSession;

    public Reservation reserve(Customer customer, int sequence, int howManyTickets) {
        Shows showing;
        try {
            showing = showsService.getShows() .get(sequence - 1);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            throw new IllegalStateException("not able to find any showing for given sequence " + sequence);
        }
        kieSession.insert(showing);
        kieSession.fireAllRules();
        var ticketPrice = calculateFee(showing, howManyTickets);
        return reservationRepository.save(new Reservation(customer, showing, howManyTickets, ticketPrice));
    }


    public Optional<Reservation> getReservationById(int reservationId){
        Reservation reservation;
        try{
            reservation = reservationRepository.getById(reservationId).get();
        }catch(Exception e){
            System.out.println("Reservation Doesn't Exist");
            return Optional.empty();
        }
        return Optional.of(reservation);
    }

    public List<Reservation> getReservationsByCustomerId(int customerId){
        return reservationRepository.getReservationsByCustomerId(customerId);
    }

    private double calculateFee(Shows show, int audienceCount) {
        return movieService.calculateTicketPrice(show, 0) * audienceCount;
    }

    public double totalFee(Shows show, int audienceCount) {
        return this.calculateFee(show, audienceCount);
    //    return shows.stream().mapToDouble(show -> calculateFee(show, audienceCount)).sum();
    }
}
