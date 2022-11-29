package com.jpmc.theater.services;

import java.util.List;
import java.util.Optional;

import com.jpmc.theater.entities.Shows;
import com.jpmc.theater.repositories.IShowsRespository;
import com.jpmc.theater.utilities.LocalDateProvider;
import com.jpmc.theater.utilities.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowsService {
    
    @Autowired
    IShowsRespository showsRespository;

    @Autowired
    LocalDateProvider localDateProvider;

    @Autowired
    Util utility;


    public List<Shows> newShows(List<Shows> shows){
        return this.showsRespository.saveAll(shows);
    }

    public List<Shows> getShows(){
        return this.showsRespository.findAll();
    }

    public Optional<Shows> getShow(int id){
        return this.showsRespository.findById(id);
    }

    public void printSchedule() {
        System.out.println(localDateProvider.currentDate());
        System.out.println("=".repeat(50));
        showsRespository.findAll().forEach(s ->
                System.out.println(s.getSequenceOfTheDay() + ": " + s.getShowStartTime() + " " + s.getMovie().getTitle() + " " + utility.humanReadableFormat(s.getMovie().getRunningTime()) + " $" + s.getMovie().getTicketPrice())
        );
        System.out.println("=".repeat(50));
    }

}
