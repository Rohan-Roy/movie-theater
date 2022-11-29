package com.jpmc.theater.repositories;

import java.util.List;
import java.util.Optional;

import com.jpmc.theater.entities.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Integer>{
    
    @Query(value="SELECT * FROM reservation WHERE customer = :customerId", nativeQuery = true)
    public List<Reservation> getReservationsByCustomerId(int customerId);

    @Query(value="SELECT * FROM reservation WHERE id = :id", nativeQuery = true)
    public Optional<Reservation> getById(int id);

}
