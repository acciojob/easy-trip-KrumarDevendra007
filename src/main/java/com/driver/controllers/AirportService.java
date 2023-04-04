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
        return airportRepository.largestAirPortName();
    }

    public String addFlight(Flight flight){
        return airportRepository.addFlight(flight);
    }
    public double shortestDistanceofTwoCities(City firstCity, City secondCity){

        return airportRepository.shortestDistanceofTwoCities(firstCity,secondCity);
    }

    public int noOfpeople(Date date, String airportName){

        return airportRepository.noOfpeople(date, airportName);
    }

    public int flightFair(int flightId){
        return airportRepository.flightFair((flightId));
    }

    public String bookTicket(int flightId, int passengerId){
        return airportRepository.bookTicket(flightId,passengerId);
    }

    public String cancelTicket(int flightId, int passegerId){
        return airportRepository.cancelTicket(flightId, passegerId);
    }

    public int allBooking(int passengerId){
        return airportRepository.allBooking(passengerId);
    }
    public String airportNameByFlightId(int flightId){


        return airportRepository.airportNameByFlightId(flightId);
    }

    public int revenueOfFlight(int flightId){
        return airportRepository.revenueOfFlight(flightId);
    }

    public String addPassenger(Passenger passenger){
        return addPassenger(passenger);
    }
}
