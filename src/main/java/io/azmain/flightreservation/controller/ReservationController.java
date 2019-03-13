package io.azmain.flightreservation.controller;


import io.azmain.flightreservation.dto.ReservationRequest;
import io.azmain.flightreservation.dto.ReservationUpdateRequest;
import io.azmain.flightreservation.entities.Flight;
import io.azmain.flightreservation.entities.Reservation;
import io.azmain.flightreservation.repos.FlightRepository;
import io.azmain.flightreservation.repos.ReservationRepository;
import io.azmain.flightreservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationService reservationService;

    @RequestMapping("/reserve")
    public Flight makeReservation(@RequestParam("flightId") Long flightId){
        Flight flight = flightRepository.findById(flightId).orElse(null);
        return flight;
    }


    @RequestMapping("/makeReservation")
    public Reservation completeReservation(ReservationRequest request){
        Reservation reservation = reservationService.bookFlight(request);

        return reservation;
    }


    @RequestMapping("/find/{id}")
    public Reservation findReservation(@PathVariable("id") Long id){
        Reservation reservation = reservationRepository.findById(id).orElse(null);

        return  reservation;
    }


    @RequestMapping("/update")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        Reservation reservation = reservationRepository.findById(request.getId()).orElse(null);

        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckedIn());

        Reservation updatedReservation = reservationRepository.save(reservation);
        return updatedReservation;

    }
}
