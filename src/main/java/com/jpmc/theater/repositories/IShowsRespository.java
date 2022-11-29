package com.jpmc.theater.repositories;

import com.jpmc.theater.entities.Shows;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IShowsRespository extends JpaRepository<Shows, Integer>{
    
}
