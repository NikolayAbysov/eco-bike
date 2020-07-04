package com.dev.dao;

import com.dev.model.Bike;
import java.util.List;
import java.util.Optional;

public interface BikeDao {
    Bike add(Bike bike);

    Optional<Bike> get(Long id);

    List<Bike> getAll();

    boolean delete(Long id);
}
