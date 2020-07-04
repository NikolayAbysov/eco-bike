package com.dev.service.impl;

import com.dev.dao.BikeDao;
import com.dev.model.Bike;
import com.dev.service.BikeService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BikeServiceImpl implements BikeService {
    private final BikeDao bikeDao;

    public BikeServiceImpl(BikeDao bikeDao) {
        this.bikeDao = bikeDao;
    }

    @Override
    public Bike add(Bike bike) {
        return bikeDao.add(bike);
    }

    @Override
    public void addBikeList(List<Bike> bikes) {
        for (Bike bike : bikes) {
            add(bike);
        }
    }

    @Override
    public Optional<Bike> get(Long id) {
        return bikeDao.get(id);
    }

    @Override
    public List<Bike> getAll() {
        return bikeDao.getAll();
    }

    @Override
    public boolean delete(Long id) {
        return bikeDao.delete(id);
    }
}
