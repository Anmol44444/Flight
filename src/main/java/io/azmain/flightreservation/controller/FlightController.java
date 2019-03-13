package io.azmain.flightreservation.controller;


import io.azmain.flightreservation.entities.Flight;
import io.azmain.flightreservation.repos.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("/find")
    public List<Flight> findFlights(@RequestParam("from") String from,
                                      @RequestParam("to") String to,
                                      @RequestParam("departureDate")
                                          @DateTimeFormat(pattern = "dd-MM-yyyy") Date departureDate){
        List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
        return flights;
    }


}
