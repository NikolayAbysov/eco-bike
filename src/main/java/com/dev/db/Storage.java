package com.dev.db;

import com.dev.model.Bike;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Bike> bikes = new ArrayList<>();
    private static Long bikeId = 0L;

    public static void addBike(Bike bike) {
        bike.setId(++bikeId);
        bikes.add(bike);
    }
}
