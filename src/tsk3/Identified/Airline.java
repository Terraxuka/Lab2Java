package tsk3.Identified;

import tsk3.IdService;
import tsk3.Rules.FlightRules;
import tsk3.Rules.LuggageRules;

public class Airline {
    private final Long id;
    private String name;
    private FlightRules flightRules;
    private LuggageRules luggageRules;

    public Airline(final String name, final FlightRules flightRules, final LuggageRules luggageRules) {
        this.id = IdService.createId();
        this.name = name;
        this.flightRules = flightRules;
        this.luggageRules = luggageRules;
    }

    public Long getId() {
        return id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public FlightRules getFlightPrices() {
        return flightRules;
    }

    public void setFlightPrices(final FlightRules flightRules) {
        this.flightRules = flightRules;
    }

    public LuggageRules getLuggageRules() {
        return luggageRules;
    }

    public void setLuggageRules(final LuggageRules luggageRules) {
        this.luggageRules = luggageRules;
    }
    public String toShortString(){
        return name;
    }
    @Override
    public String toString() {
        return "id: " + id +" "+name ;
    }
}

