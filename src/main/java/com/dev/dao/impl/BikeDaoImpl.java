package com.dev.dao.impl;

import com.dev.dao.BikeDao;
import com.dev.db.Storage;
import com.dev.model.Bike;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class BikeDaoImpl implements BikeDao {
    @Override
    public Bike add(Bike bike) {
        Storage.addBike(bike);
        return bike;
    }

    @Override
    public Optional<Bike> get(Long id) {
        return Storage.bikes.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Bike> getAll() {
        return Storage.bikes;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.bikes.removeIf(b -> b.getId().equals(id));
    }
}
