package com.organisation.vehiclerecall.service;

import com.organisation.vehiclerecall.model.RecallRecord;
import java.util.List;

public interface IVehicleRecallService {
    void registerRecall(RecallRecord recall);
    List<RecallRecord> searchByManufacturer(String manufacturerName);
    List<RecallRecord> searchByModel(String modelName);
    List<RecallRecord> searchByYear(int year);

}
