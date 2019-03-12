package io.azmain.flightreservation.entities;

import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Flight {

    private String flightNumber;
    private String opratingAirlines;
    private String departureCity;
    private String arrivalCity;
    private Date dateofDeparture;
    private Timestamp estimatedDepartureTime;


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOpratingAirlines() {
        return opratingAirlines;
    }

    public void setOpratingAirlines(String opratingAirlines) {
        this.opratingAirlines = opratingAirlines;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Date getDateofDeparture() {
        return dateofDeparture;
    }

    public void setDateofDeparture(Date dateofDeparture) {
        this.dateofDeparture = dateofDeparture;
    }

    public Timestamp getEstimatedDepartureTime() {
        return estimatedDepartureTime;
    }

    public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
        this.estimatedDepartureTime = estimatedDepartureTime;
    }
}
