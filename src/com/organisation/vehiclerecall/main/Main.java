package com.organisation.vehiclerecall.main;

import com.organisation.vehiclerecall.model.*;
import com.organisation.vehiclerecall.repo.*;
import com.organisation.vehiclerecall.service.*;
import com.organisation.vehiclerecall.util.MockDataGenerator;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IRecallRepository repo = new RecallRepositoryImpl();
        IVehicleRecallService service = new VehicleRecallServiceImpl(
            repo, 
            MockDataGenerator.getMockManufacturers(), 
            MockDataGenerator.getMockVehicles()
        );

        // Seed some data
        service.registerRecall(new RecallRecord("R1", "V1", "C1", "Airbag deployment failure", LocalDate.now()));
        service.registerRecall(new RecallRecord("R2", "V2", "C2", "Brake pad wear issue", LocalDate.now().minusMonths(2)));

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Vehicle Recall Management System ===");

        while (true) {
            System.out.println("\n1. Search by Manufacturer\n2. Search by Model\n3. Search by Year\n4. Exit");
            System.out.print("Select choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("4")) break;

            System.out.print("Enter search term: ");
            String query = scanner.nextLine();
            List<RecallRecord> results;

            try {
                switch (choice) {
                    case "1" -> results = service.searchByManufacturer(query);
                    case "2" -> results = service.searchByModel(query);
                    case "3" -> results = service.searchByYear(Integer.parseInt(query));
                    default -> {
                        System.out.println("Invalid option.");
                        continue;
                    }
                }

                if (results.isEmpty()) {
                    System.out.println("No recalls found.");
                } else {
                    results.forEach(System.out::println);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
