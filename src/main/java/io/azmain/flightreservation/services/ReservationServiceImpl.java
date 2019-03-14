package io.azmain.flightreservation.services;

import io.azmain.flightreservation.dto.ReservationRequest;
import io.azmain.flightreservation.entities.Flight;
import io.azmain.flightreservation.entities.Passenger;
import io.azmain.flightreservation.entities.Reservation;
import io.azmain.flightreservation.repos.FlightRepository;
import io.azmain.flightreservation.repos.PassengerRepository;
import io.azmain.flightreservation.repos.ReservationRepository;
import io.azmain.flightreservation.util.EmailUtil;
import io.azmain.flightreservation.util.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PdfGenerator pdfGenerator;

    @Autowired
    EmailUtil emailUtil;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        //Payment

        Long flightId = request.getFlightId();
        Flight flight = flightRepository.findById(flightId).orElse(null);

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhone());
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        reservation.setNumberOfBags(2);
        Reservation savedReservation = reservationRepository.save(reservation);

        String filePath = "H:\\Spring\\flight-reservation\\"+savedReservation.getId()+".pdf";
        pdfGenerator.generatePdf(savedReservation, filePath);
        emailUtil.sendEMail(passenger.getEmail(),filePath);

        return savedReservation;
    }
}
