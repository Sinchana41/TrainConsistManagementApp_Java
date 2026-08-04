package com.bl.trainconsistmanagementapp.model;

import com.bl.trainconsistmanagementapp.exception.CargoSafetyException;

public class GoodsBogie extends Bogie {

    private String cargoType;
    private double maxCapacityTons;

    public GoodsBogie(String bogieId, String bogieType, String cargoType, double maxCapacityTons) {
        super(bogieId, bogieType);
        this.cargoType = cargoType;
        this.maxCapacityTons = maxCapacityTons;
    }

    /**
     * Safely assigns cargo based on bogie shape/type constraints.
     * Throws CargoSafetyException if petroleum is assigned to a non-cylindrical/rectangular bogie.
     */
    public void assignCargo(String newCargoType) {
        System.out.println("Attempting to assign cargo [" + newCargoType + "] to " + getBogieId() + " (" + getBogieType() + ")...");

        // Business Rule: Petroleum requires Cylindrical shape. Rectangular/Box Car bogies are unsafe.
        if ("Petroleum".equalsIgnoreCase(newCargoType) && !"Cylindrical".equalsIgnoreCase(getBogieType())) {
            throw new CargoSafetyException("SAFETY VIOLATION: Liquid cargo 'Petroleum' cannot be assigned to a rectangular "
                    + getBogieType() + " bogie (" + getBogieId() + "). Cylindrical bogie required.");
        }

        this.cargoType = newCargoType;
        System.out.println("SUCCESS: Cargo [" + newCargoType + "] assigned to Bogie " + getBogieId());
    }

    public String getCargoType() {
        return cargoType;
    }

    public double getMaxCapacityTons() {
        return maxCapacityTons;
    }

    @Override
    public String toString() {
        return String.format("GoodsBogie[ID: %s, Type: %s, Cargo: %s, MaxCap: %.1f Tons]",
                getBogieId(), getBogieType(), cargoType, maxCapacityTons);
    }
}