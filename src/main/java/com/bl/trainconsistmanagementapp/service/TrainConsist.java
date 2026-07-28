package com.bl.trainconsistmanagementapp.service;

import com.bl.trainconsistmanagementapp.model.Bogie;

import java.util.ArrayList;
import java.util.List;

public class TrainConsist {

    private List<Bogie> bogies;

    public TrainConsist() {
        this.bogies = new ArrayList<>();
    }

    public int getBogieCount(){
       return bogies.size();
    }
}
