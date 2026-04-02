package com.organisation.vehiclerecall.service;

import com.organisation.vehiclerecall.model.*;
import com.organisation.vehiclerecall.repo.IRecallRepository;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleRecallServiceImpl implements IVehicleRecallService {
    private final IRecallRepository repository;
    private final List<Manufacturer> manufacturers;
    private final List<Vehicle> vehicles;

    public VehicleRecallServiceImpl(IRecallRepository repository, List<Manufacturer> manufacturers, List<Vehicle> vehicles) {
        this.repository = repository;
        this.manufacturers = manufacturers;
        this.vehicles = vehicles;
    }

    @Override
    public void registerRecall(RecallRecord recall) {
        repository.save(recall);
    }

    @Override
    public List<RecallRecord> searchByManufacturer(String manufacturerName) {
        List<String> mIds = manufacturers.stream()
            .filter(m -> m.name().equalsIgnoreCase(manufacturerName))
            .map(Manufacturer::id)
            .toList();

        List<String> vIds = vehicles.stream()
            .filter(v -> mIds.contains(v.manufacturerId()))
            .map(Vehicle::id)
            .toList();

        return repository.findAll().stream()
            .filter(r -> vIds.contains(r.vehicleId()))
            .collect(Collectors.toList());
    }

    @Override
    public List<RecallRecord> searchByModel(String modelName) {
        List<String> vIds = vehicles.stream()
            .filter(v -> v.modelName().equalsIgnoreCase(modelName))
            .map(Vehicle::id)
            .toList();

        return repository.findAll().stream()
            .filter(r -> vIds.contains(r.vehicleId()))
            .collect(Collectors.toList());
    }

    @Override
    public List<RecallRecord> searchByYear(int year) {
        List<String> vIds = vehicles.stream()
            .filter(v -> v.year() == year)
            .map(Vehicle::id)
            .toList();

        return repository.findAll().stream()
            .filter(r -> vIds.contains(r.vehicleId()))
            .collect(Collectors.toList());
    }
}
