package tsk3;

import tsk3.Identified.Flight;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSchedule {
    private final List<Flight> flights;

    public FlightSchedule() {
        this.flights = new LinkedList<>();
    }

    public FlightSchedule(final List<Flight> flights) {
        this.flights = flights;
    }

    public boolean removeOldFlights(final int howManyDaysSaveFlights) {
        final ZonedDateTime currentTime = ZonedDateTime.now();
        return flights.removeIf(flight ->
                (ChronoUnit.DAYS.between(currentTime, flight.getDepartureTime()) > howManyDaysSaveFlights));
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlight(final Flight flight) {
        this.flights.add(flight);
    }

    public void removeFlight(final Flight flight) {
        this.flights.remove(flight);
    }

    public List<Flight> getFreshFlights() {
        final LocalDate today = LocalDate.now();
        return flights.stream()
                .filter(flight -> flight.getDepartureTime().toLocalDate().isEqual(today)
                        || flight.getDepartureTime().toLocalDate().isAfter(today))
                .sorted(Comparator.comparing(Flight::getDepartureTime))
                .toList();
    }

    public List<Flight> getFreshDeparturesFlights() {
        return getFreshFlights().stream()
                .filter(flight -> flight.getDepartureAirport().getFlightSchedule() == this && flight.isNotCanceled())
                .toList();
    }

    public List<Flight> getFreshArrivalFlights() {
        return getFreshFlights().stream()
                .filter(flight -> flight.getArrivalAirport().getFlightSchedule() == this && flight.isNotCanceled())
                .toList();
    }
    public String getAllFlightsToString(){
        return flights.stream().map(Flight::toShortString).collect(Collectors.joining("\n"));
    }
    @Override
    public String toString() {
        final List<Flight> departuresFlights = getFreshDeparturesFlights();
        final List<Flight> arrivalFlights = getFreshArrivalFlights();
        final String departuresString = departuresFlights.stream().map(Flight::toShortString).collect(Collectors.joining("\n"));
        final String arrivalString = arrivalFlights.stream().map(Flight::toShortString).collect(Collectors.joining("\n"));
        return "Departures \n" +
                departuresString +
                "\nArrivals\n" +
                arrivalString;
    }
}