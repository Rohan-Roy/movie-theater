package com.jpmc.theater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
public class Theater {

    public static void main(String[] args) {
        SpringApplication.run(Theater.class, args);
    }

    // @Bean
    // @Order(20)
    // public Descriptor schedulerRunner() {
    //   return new Descriptor();
    // }

    // @Bean
    // @Order(0)
    // public Initializer initiaize() {
    //   return new Initializer();
    // }
}
