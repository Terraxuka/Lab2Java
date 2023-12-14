package tsk3;

import tsk3.Data.Location;
import tsk3.Data.TicketType;
import tsk3.Identified.Flight;
import java.time.ZonedDateTime;
import java.util.List;

public interface FlightStrategy {
    Long addAircraft(String manufacturer, String model, int economySeat, int firstSeat, int businessSeat);
    boolean changeAircraft(Long aircraftId, String manufacturer, String model, Integer economySeat, Integer firstSeat, Integer businessSeat);
    boolean deleteAircraft(Long aircraftId);

    Long addFlight(ZonedDateTime departureTime, ZonedDateTime arrivalTime, Long departureAirportId, Long arrivalAirportId, Long aircraftId, Long AirlinesId);
    boolean changeFlight(Long flightId, ZonedDateTime departureTime, ZonedDateTime arrivalTime, Long departureAirportId, Long arrivalAirportId, Long aircraftId, Long AirlinesId);
    boolean deleteFlight(Long flightId);

    Long addPassenger(String firstName, String lastName, boolean isBonusEnable);
    boolean changePassenger(Long passengerId, String firstName, String lastName, Boolean isBonusEnable);
    boolean deletePassenger(Long passengerId);

    Long addAirport(String strCode, Location location);
    boolean changeAirport(Long airportId, String country, String city, Double latitude, Double longitude, String utsOffset);
    boolean deleteAirport(Long airportId);

    String getSchedules();

    FlightSchedule createSchedule(List<Flight> flights);

    Long sellTicket(Long flightId, Long passengerId, TicketType ticketType);
    boolean cancelTicket(Long ticketId);
    boolean cancelTicket(Long passengerId, Long flightId);

    double getProfitByTime(ZonedDateTime startTime, ZonedDateTime finalTime);
}
