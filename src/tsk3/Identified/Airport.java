package tsk3.Identified;

import tsk3.FlightSchedule;
import tsk3.Data.Location;
import tsk3.IdService;

public class Airport{
    private final Long id;
    private String strCode;
    private Location location;
    private FlightSchedule flightSchedule;

    public Airport(final String strCode, final Location location) {
        this.id = IdService.createId();
        this.location = location;
        this.flightSchedule = new FlightSchedule();
        this.strCode = strCode;
    }

    public String getStrCode() {
        return strCode;
    }

    public void setStrCode(final String strCode) {
        this.strCode = strCode;
    }

    public void setFlightSchedule(final FlightSchedule flightSchedule) {
        if (flightSchedule != null)
            this.flightSchedule = flightSchedule;
    }

    public void addFlight(final Flight flight) {
        flightSchedule.addFlight(flight);
    }

    public void removeFlight(final Flight flight) {
        flightSchedule.removeFlight(flight);
    }

    public Long getId() {
        return id;
    }

    public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        if (location != null) {
            this.location = location;
        }
    }

    public String scheduleToString() {
        return flightSchedule.toString();
    }
    public String toShortString() {
        return location.getCity();
    }
    public String withScheduleToString(){
        return toString() +"\n"+ scheduleToString();
    }
    @Override
    public String toString() {
        return "id: "+ id +" " +location.toString()+
                " (" + strCode +")" + "\n";
    }
}
