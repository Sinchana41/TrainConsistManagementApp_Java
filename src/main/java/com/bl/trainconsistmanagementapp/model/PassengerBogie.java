package com.bl.trainconsistmanagementapp.model;

import com.bl.trainconsistmanagementapp.exception.InvalidCapacityException;

public class PassengerBogie extends Bogie {

    private int seatCapacity;
    public PassengerBogie(String bogieId, String bogieType, int seatCapacity) throws InvalidCapacityException {
        super(bogieId, bogieType);

        // Business Rule: Fail-fast validation for seat capacity
        if (seatCapacity <= 0) {
            throw new InvalidCapacityException("Invalid passenger capacity: [" + seatCapacity
                    + "]. Seat capacity must be greater than zero.");
        }
        this.seatCapacity = seatCapacity;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) throws InvalidCapacityException {
        if (seatCapacity <= 0) {
            throw new InvalidCapacityException("Invalid passenger capacity: [" + seatCapacity
                    + "]. Seat capacity must be greater than zero.");
        }
        this.seatCapacity = seatCapacity;
    }

    @Override
    public String toString() {
        return String.format("PassengerBogie[ID: %s, Type: %s, Seats: %d]",
                getBogieId(), getBogieType(), seatCapacity);
    }
}