package com.bl.trainconsistmanagementapp.model;

public class GoodsBogie extends Bogie{

    private String cargoType;
    private double maxCapacityTons;

    public GoodsBogie(String bogieId, String bogieType, String cargoType, double maxCapacityTons) {
        super(bogieId, bogieType);
        this.cargoType = cargoType;
        this.maxCapacityTons = maxCapacityTons;
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
