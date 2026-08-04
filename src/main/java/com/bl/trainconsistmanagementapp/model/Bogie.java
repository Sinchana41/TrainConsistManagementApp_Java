package com.bl.trainconsistmanagementapp.model;

public class Bogie {

    private String bogieId;
    private String bogieType;

    public Bogie(String bogieId, String bogieType) {
        this.bogieId = bogieId;
        this.bogieType = bogieType;
    }

    public String getBogieId() {
        return bogieId;
    }

    public String getBogieType() {
        return bogieType;
    }

    @Override
    public String toString() {
        return "Bogie{" +
                "bogieId='" + bogieId + '\'' +
                ", bogieType='" + bogieType + '\'' +
                '}';
    }
}
