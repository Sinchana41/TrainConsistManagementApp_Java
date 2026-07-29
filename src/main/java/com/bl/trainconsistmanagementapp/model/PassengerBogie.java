package com.bl.trainconsistmanagementapp.model;

public class PassengerBogie extends Bogie implements Comparable<PassengerBogie> {

    private int seatCapacity;

    public PassengerBogie(String bogieId, String bogieType, int seatCapacity) {
        super(bogieId, bogieType);
        this.seatCapacity = seatCapacity;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    @Override
    public int compareTo(PassengerBogie other) {
        return Integer.compare(this.seatCapacity, other.seatCapacity);
    }

    @Override
    public String toString() {
        return String.format("PassengerBogie[ID: %s, Class: %s, Seats: %d]",
                getBogieId(), getBogieType(), seatCapacity);
    }
}