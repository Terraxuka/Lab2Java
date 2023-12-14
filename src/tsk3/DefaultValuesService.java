package tsk3;

import tsk3.Data.Location;
import tsk3.Identified.Aircraft;
import tsk3.Identified.Airport;
import tsk3.Identified.Passenger;

public class DefaultValuesService {
    final private Passenger defaultPassenger;
    final private Aircraft defaultAircraft;
    final private Airport defaultAirport;

    public DefaultValuesService() {
        this.defaultPassenger = new Passenger("REMOVED", "PASSENGER", false, 0);
        this.defaultAircraft = new Aircraft("REMOVED", "AIRCRAFT", 1, 0, 0);
        this.defaultAirport = new Airport("REMOVED", new Location("LOCATION", "REMOVED", 0., 0., "+0"));
    }

    public Passenger getDefaultPassenger() {
        return defaultPassenger;
    }

    public Aircraft getDefaultAircraft() {
        return defaultAircraft;
    }

    public Airport getDefaultAirport() {
        return defaultAirport;
    }
}
