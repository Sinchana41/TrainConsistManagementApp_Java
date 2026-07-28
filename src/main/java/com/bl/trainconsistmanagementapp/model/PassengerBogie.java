package com.bl.trainconsistmanagementapp.model;

public class PassengerBogie extends Bogie{

    private int seatCapacity;

    public PassengerBogie(String bogieId, String bogieType, int seatCapacity) {
        super(bogieId, bogieType);
        this.seatCapacity = seatCapacity;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    @Override
    public String toString() {
        return String.format("PassengerBogie[ID: %s, Class: %s, Seats: %d]",
                getBogieId(), getBogieType(), seatCapacity);
    }
}
