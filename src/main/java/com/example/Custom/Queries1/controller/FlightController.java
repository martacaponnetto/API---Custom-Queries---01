package com.example.Custom.Queries1.controller;//package com.example.Custom.Queries1.controller;
//
//import com.example.Custom.Queries1.entity.Flight;
//import com.example.Custom.Queries1.entity.FlightStatus;
//import com.example.Custom.Queries1.repository.FlightRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
//@RestController
//@RequestMapping("/flights")
//public class FlightController {
//    @Autowired
//    private FlightRepository flightRepository;
//    @GetMapping("/provision")
//    public List<Flight> provisionFlights() {
//        List<Flight> flights = new ArrayList<>();
//        List<String> descriptions = Arrays.asList("Business", "Vacation", "Family Visit", "Work", "Holiday");
//        List<String> airports = Arrays.asList("ABC", "CTA", "RDJ", "EFG", "HIL", "FMC", "FRA", "DVB", "HND", "PAR");
//        Random random = new Random();
//        for(int i = 0; i < 50; i++) {
//            Flight flight = new Flight(descriptions.get(random.nextInt(descriptions.size())),
//                    airports.get(random.nextInt(airports.size())),
//                    airports.get(random.nextInt(airports.size())));
//
//            flights.add(flight);
//        }
//
//        return flightRepository.saveAllAndFlush(flights);
//    }
//
//    @GetMapping("/retrieve")
//    public List<Flight> retrieveFlights() {
//        return flightRepository.findAll();
//    }
//
//    @GetMapping("/byStatus")
//    public List<Flight> retrieveByStatus(String status){
//        return flightRepository.findByStatus(FlightStatus.toString(status));
//    }
//}

import com.example.Custom.Queries1.entity.Flight;
import com.example.Custom.Queries1.entity.FlightStatus;
import com.example.Custom.Queries1.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/seed")
    public String seedFlights() {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + i);
            flight.setFromAirport("Airport " + random.nextInt(10));
            flight.setToAirport("Airport " + random.nextInt(10));
            flight.setStatus(FlightStatus.ONTIME);
            flightRepository.save(flight);
        }
        return "Flights seeded successfully!";
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }
}
