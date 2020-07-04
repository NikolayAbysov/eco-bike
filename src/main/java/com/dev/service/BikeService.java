package com.dev.service;

import com.dev.model.Bike;
import java.util.List;
import java.util.Optional;

public interface BikeService {
    Bike add(Bike bike);

    void addBikeList(List<Bike> bikes);

    Optional<Bike> get(Long id);

    List<Bike> getAll();

    boolean delete(Long id);
}
