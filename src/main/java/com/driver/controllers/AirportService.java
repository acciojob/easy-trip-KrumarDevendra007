package com.driver.controllers;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;

@Service
public class AirportService {

    AirportRepository airportRepository = new AirportRepository();

    public void addAirport(Airport airport){
        airportRepository.addAirport(airport);
    }

    public String largestAirPortName(){

        String airportName = airportRepository.largestAirPortName();
        return airportName;
    }

    public String addFlight(Flight flight){
        String flightAdded = airportRepository.addFlight(flight);
        return flightAdded;
    }
    public double shortestDistanceofTwoCities(City firstCity, City secondCity){

        double shortestDistance = airportRepository.shortestDistanceofTwoCities(firstCity,secondCity);
        return shortestDistance;
    }

    public int noOfpeople(Date date, String airportName){

        int peopleNo = airportRepository.noOfpeople(date, airportName);
        return peopleNo;
    }

    public int flightFair(int flightId){
        int fair = airportRepository.flightFair((flightId));
        return fair;
    }

    public String bookTicket(int flightId, int passengerId){
        String ticketBooked = airportRepository.bookTicket(flightId,passengerId);
        return ticketBooked;
    }

    public String cancelTicket(int flightId, int passegerId){
        String ticketCancel = airportRepository.cancelTicket(flightId, passegerId);
        return ticketCancel;
    }

    public int allBooking(int passengerId){
        int booking = airportRepository.allBooking(passengerId);
        return booking;
    }
    public String airportNameByFlightId(int flightId){

        String airportName = airportRepository.airportNameByFlightId(flightId);
        return airportName;
    }

    public int revenueOfFlight(int flightId){
        int revenue = airportRepository.revenueOfFlight(flightId);
        return revenue;
    }

    public String addPassenger(Passenger passenger){
        String passengerAdded = addPassenger(passenger);
        return passengerAdded;
    }
}
