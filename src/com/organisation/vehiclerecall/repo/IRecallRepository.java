package com.organisation.vehiclerecall.repo;

import java.util.List;
import java.util.Optional;

public interface IRecallRepository {
    void save(com.organisation.vehiclerecall.model.RecallRecord recall);
    List<com.organisation.vehiclerecall.model.RecallRecord> findAll();
    Optional<com.organisation.vehiclerecall.model.RecallRecord> findById(String id);
}

