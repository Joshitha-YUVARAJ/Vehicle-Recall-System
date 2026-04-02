package com.organisation.vehiclerecall.util;

import com.organisation.vehiclerecall.model.*;
import java.time.LocalDate;
import java.util.List;

public class MockDataGenerator {
    public static List<Manufacturer> getMockManufacturers() {
        return List.of(
            new Manufacturer("M1", "Tesla", "USA"),
            new Manufacturer("M2", "Toyota", "Japan")
        );
    }

    public static List<Vehicle> getMockVehicles() {
        return List.of(
            new Vehicle("V1", "M1", "Model S", 2022),
            new Vehicle("V2", "M2", "Corolla", 2021)
        );
    }

    public static List<RecallComponent> getMockComponents() {
        return List.of(
            new RecallComponent("C1", "Airbag"),
            new RecallComponent("C2", "Brakes")
        );
    }
}
