package tsk3.Identified;

import tsk3.IdService;


public class Aircraft {
    private final Long id;
    private String manufacturer;
    private String model;
    private int economySeat;
    private int firstSeat;
    private int businessSeat;

    public Aircraft(final String manufacturer, final String model, final int economySeat, final int firstSeat, final int businessSeat) {
        this.id = IdService.createId();
        this.manufacturer = manufacturer;
        this.model = model;
        this.economySeat = economySeat;
        this.firstSeat = firstSeat;
        this.businessSeat = businessSeat;
    }

    public Long getId() {
        return id;
    }

    public void setManufacturer(final String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public int getEconomySeat() {
        return economySeat;
    }

    public void setEconomySeat(final int economySeat) {
        this.economySeat = economySeat;
    }

    public int getFirstSeat() {
        return firstSeat;
    }

    public void setFirstSeat(final int firstSeat) {
        this.firstSeat = firstSeat;
    }

    public int getBusinessSeat() {
        return businessSeat;
    }

    public void setBusinessSeat(final int businessSeat) {
        this.businessSeat = businessSeat;
    }

    public String toShortString() {
        return manufacturer + " " + model;
    }

    @Override
    public String toString() {
        return "id: " + id + " " + manufacturer + " " + model;
    }
}
