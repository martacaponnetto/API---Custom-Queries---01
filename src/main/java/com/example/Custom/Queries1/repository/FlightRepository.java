package com.example.Custom.Queries1.repository;


import com.example.Custom.Queries1.entity.Flight;
import com.example.Custom.Queries1.entity.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByStatus (FlightStatus flightStatus);
}