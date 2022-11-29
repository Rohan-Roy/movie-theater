package com.jpmc.theater.repositories;

import com.jpmc.theater.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Integer>{
    
}
