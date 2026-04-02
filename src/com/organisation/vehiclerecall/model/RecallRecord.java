package com.organisation.vehiclerecall.model;

import java.time.LocalDate;

public record RecallRecord(
    String id, 
    String vehicleId, 
    String componentId, 
    String description, 
    LocalDate recallDate
) {}

