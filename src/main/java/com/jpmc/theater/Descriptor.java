package com.jpmc.theater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.jpmc.theater.entities.Customer;
import com.jpmc.theater.entities.Reservation;
import com.jpmc.theater.services.CustomerCreationService;
import com.jpmc.theater.services.ReservationService;
import com.jpmc.theater.services.ShowsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class Descriptor implements CommandLineRunner{
    private static final int MAX_ATTEMP = 5;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Autowired
    ShowsService showsService;

    @Autowired
    CustomerCreationService customerCreationService;

    @Autowired
    ReservationService reservationService;

    @Override
    public void run(String... args) throws Exception {
        showsService.printSchedule();
        
        while(true){
            System.out.println("Pick Any Service:");
            System.out.println("1. Add Customer");
            System.out.println("2. Make Reservation");
            System.out.println("3. Reservation Details");
            System.out.println("4. Show Schedules");
            System.out.println("5. Exit");
            String input = br.readLine();
            switch(input){
                case "1":
                customerCreationPrompter(null);
                break;

                case "2":
                reservationDetailPrompter(Optional.of(reservationPrompter()));
                break;

                case "3":
                reservationDetailPrompter(Optional.empty());
                break;

                case "4":
                showsService.getShows().forEach(System.out::println);
                System.out.println("=".repeat(30) + " Printing in Json " + "=".repeat(30));
                ObjectMapper mapper = new ObjectMapper().registerModule(new JSR310Module());
                String jsonString = mapper.writeValueAsString(showsService.getShows());
                System.out.println(jsonString);
                System.out.println("=".repeat(35) + " XX " + "=".repeat(35));
                break;

                case "5":
                System.exit(0);

                default :
                System.out.println("Invalid Input, Please Try Again");
            }          
        }
    }

    public Customer customerCreationPrompter(String name) throws IOException{
        Customer customer;
        if(name == null){
            System.out.println("Enter Name:");
            customer =  customerCreationService.createCustomer(br.readLine());            
        }else
            customer =  customerCreationService.createCustomer(name);            

        System.out.println("Customer Created\n" + customer.toString()); 
        return customer;
    }
    
    public Reservation reservationPrompter() throws IOException{
        System.out.println("Enter Sequence:");
        var sequence = Integer.parseInt(br.readLine());
        while(showsService.getShow(sequence).isEmpty()){
            System.out.println("Enter a Valid Sequence:");
            sequence = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter Number of Tickets:");
        var howManyTickets = Integer.parseInt(br.readLine());

        System.out.println("Enter Name of Customer:");
        var name = br.readLine();
        var customer = customerCreationService.getCustomerByName(name);
        if(customer.size() != 0)
            return reservationService.reserve(customer.get(0), sequence, howManyTickets);
        System.out.println("Customer Doesn't exist with the name");
        var customerObj = this.customerCreationPrompter(name);
        var reservation =  reservationService.reserve(customerObj, sequence, howManyTickets);
        System.out.println("Ticket Fee: " + reservation.getTicketPrice());
        return reservation;
    }

    public void reservationDetailPrompter(Optional<Reservation> reservation) throws IOException{
        if(!reservation.isEmpty())
            System.out.println(reservation.get().toString());
        else{
            System.out.println("Enter Reservation Id:");
            var reservationId = Integer.parseInt(br.readLine());
            int attempts = MAX_ATTEMP;
            while( attempts-- > 0 && reservationService.getReservationById(reservationId).isEmpty()){
                System.out.println("Enter Valid Reservation Id:");
                reservationId = Integer.parseInt(br.readLine());
            }
            if(attempts <= 0)
                System.out.println("Max attempts exceeded");
            else{
                var reservationObj = reservationService.getReservationById(reservationId);
                System.out.println(reservationObj.get().toString());            
            }

        }

    }
}
