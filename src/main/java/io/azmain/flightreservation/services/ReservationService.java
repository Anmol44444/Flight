package io.azmain.flightreservation.services;


import io.azmain.flightreservation.dto.ReservationRequest;
import io.azmain.flightreservation.entities.Reservation;

public interface ReservationService {


    public Reservation bookFlight(ReservationRequest request);
}
