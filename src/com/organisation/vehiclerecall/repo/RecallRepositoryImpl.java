package com.organisation.vehiclerecall.repo;

import com.organisation.vehiclerecall.model.RecallRecord;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecallRepositoryImpl implements IRecallRepository {
    private final List<RecallRecord> database = new ArrayList<>();

    @Override
    public void save(RecallRecord recall) {
        if (findById(recall.id()).isPresent()) {
            return;
        }
        database.add(recall);
    }

    @Override
    public List<RecallRecord> findAll() {
        return new ArrayList<>(database);
    }

    @Override
    public Optional<RecallRecord> findById(String id) {
        return database.stream()
                .filter(r -> r.id().equals(id))
                .findFirst();
    }
}
