package com.driver.controllers;

import com.driver.model.Airport;
import com.driver.model.City;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AirportRepository {

    HashMap<String, Airport> airportDb = new HashMap<>();
    HashMap<Integer, Flight> flightDb = new HashMap<>();
    HashMap<Integer, List<Integer>> flightPassengerDb = new HashMap<>();
    HashMap<Integer, Passenger> passengerDb = new HashMap<>();
    public void addAirport(Airport airport){

        String key = airport.getAirportName();
         airportDb.put(key, airport);
    }

    public String largestAirPortName(){

        String res = "";
        int terminalNo = 0;

        for(Airport airport : airportDb.values()){

            if(airport.getNoOfTerminals() > terminalNo){
                res = airport.getAirportName();
                terminalNo = airport.getNoOfTerminals();
            }
            else if(airport.getNoOfTerminals() == terminalNo){
                if(airport.getAirportName().compareTo(res) < 0){
                    res = airport.getAirportName();
                }
            }
        }
        return res;
    }

    public double shortestDistanceofTwoCities(City fromCity, City toCity){

        double distance = 1000000000;

        for(Flight flight : flightDb.values()){
            if(flight.getFromCity().equals(fromCity) && flight.getToCity().equals(toCity)){
                distance = Math.min(distance, flight.getDuration());
            }
        }

        if(distance == 1000000000){
            return -1;
        }
        return distance;
    }

    public int noOfpeople(Date date, String airportName){
        Airport airport = airportDb.get(airportName);
        if(airport == null)
            return 0;

        City city = airport.getCity();
        int count = 0;
        for(Flight flight:flightDb.values()){
            if(date.equals(flight.getFlightDate()))
                if(flight.getToCity().equals(city)||flight.getFromCity().equals(city)){

                    int flightId = flight.getFlightId();
                    count = count + flightPassengerDb.get(flightId).size();
                }
        }
        return count;
    }

    public int flightFair(int flightId){
        int noOfPeopleBooked = flightPassengerDb.get(flightId).size();
        return noOfPeopleBooked*50 + 3000;
    }

    public String bookTicket(Integer flightId,Integer passengerId)
    {
        if(flightPassengerDb.get(flightId)!=null &&(flightPassengerDb.get(flightId).size()<flightDb.get(flightId).getMaxCapacity())){


            List<Integer> passengers =  flightPassengerDb.get(flightId);

            if(passengers.contains(passengerId)){
                return "FAILURE";
            }

            passengers.add(passengerId);
            flightPassengerDb.put(flightId,passengers);
            return "SUCCESS";
        }
        else if(flightPassengerDb.get(flightId)==null)
        {
            flightPassengerDb.put(flightId,new ArrayList<>());
            List<Integer> passengers =  flightPassengerDb.get(flightId);

            if(passengers.contains(passengerId)){
                return "FAILURE";
            }

            passengers.add(passengerId);
            flightPassengerDb.put(flightId,passengers);
            return "SUCCESS";

        }
        return "FAILURE";
    }

    public String cancelTicket(Integer flightId,Integer passengerId)
    {
        List<Integer> passengers = flightPassengerDb.get(flightId);
        if(passengers == null){
            return "FAILURE";
        }

        if(passengers.contains(passengerId)){
            passengers.remove(passengerId);
            return "SUCCESS";
        }
        return "FAILURE";
    }

    public int allBooking(Integer passengerId)
    {
        int count = 0;
        for(Map.Entry<Integer,List<Integer>> entry: flightPassengerDb.entrySet()){

            List<Integer> passengers  = entry.getValue();
            for(Integer passenger : passengers){
                if(Objects.equals(passenger, passengerId)){
                    count++;
                }
            }
        }
        return count;
    }

    public String addFlight(Flight flight)
    {
        flightDb.put(flight.getFlightId(),flight);
        return "SUCCESS";
    }

    public String airportNameByFlightId(Integer flightId){


        if(flightDb.containsKey(flightId)){
            City city = flightDb.get(flightId).getFromCity();
            for(Airport airport:airportDb.values()){
                if(airport.getCity().equals(city)){
                    return airport.getAirportName();
                }
            }
        }
        return null;
    }

    public int revenueOfFlight(Integer flightId){

        int noOfPeopleBooked = flightPassengerDb.get(flightId).size();
        int totalFare = (25 * noOfPeopleBooked * noOfPeopleBooked) + (2975 * noOfPeopleBooked);

        return totalFare;
    }
    public String addPassenger(Passenger passenger){

        passengerDb.put(passenger.getPassengerId(),passenger);
        return "SUCCESS";
    }
}
