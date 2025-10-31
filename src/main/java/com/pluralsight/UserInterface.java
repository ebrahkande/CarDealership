package com.pluralsight;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    // Declares a variable to hold the Dealership object
    private Dealership dealership;
    private Scanner scanner;

    // Constructor
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        this.dealership = fileManager.getDealership();

        // Basic check to see if the loading was successful
        if (this.dealership == null) {
            System.out.println("Fatal Error: Could not load dealership data. Exiting.");
            System.exit(0);
        }
    }

    // Main method that starts the application loop
    public void display() {
        init();
        int command = -1;

        // Start the application loop
        while (command != 99) {
            displayMenu(); // Display the menu options
            System.out.print("Enter your command: ");

            // Safely read the user's command
            if (scanner.hasNextInt()) {
                command = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            // Use a switch statement to call the correct processing method
            switch (command) {
                case 1: processGetByPriceRequest(); break;
                case 7: processGetAllVehiclesRequest(); break;
                case 99: System.out.println("Quitting application. Goodbye!"); break;
                default: System.out.println("Invalid command. Please try again.");
            }
        }
    }

    // Helper method to display the menu options
    private void displayMenu() {
        System.out.println("\n--- Dealership Menu ---");
        System.out.println("1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make / model");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.println("-----------------------");
    }

    // Helper method to display a list of vehicles
    private void displayVehicles(List<Vehicle> vehicleList) {
        if (vehicleList.isEmpty()) {
            System.out.println("No vehicles found matching your request.");
            return;
        }

        System.out.println("\n--- Matching Vehicles ---");

        for (Vehicle vehicle : vehicleList) {
            System.out.printf("VIN: %d | Year: %d | Make: %s | Model: %s | Price: $%.2f\n",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getModel(),
                    vehicle.getModel(), vehicle.getPrice());
        }
        System.out.println("-------------------------\n");
    }

    // Method to handle the "List ALL vehicles"
    private void processGetAllVehiclesRequest() {
        System.out.println("Listing all vehicles in inventory...");
        List<Vehicle> allVehicles = this.dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    // Method to handle the "Find vehicles within a price range"
    private void processGetByPriceRequest() {
        try {
            System.out.print("Enter minimum price: ");
            double minPrice = scanner.nextDouble();
            System.out.print("Enter maximum price: ");
            double maxPrice = scanner.nextDouble();
            scanner.nextLine();

            List<Vehicle> matchingVehicles = this.dealership.getVehicleByPrice(minPrice, maxPrice);
            displayVehicles(matchingVehicles);
        } catch (InputMismatchException e) {
            System.out.println("Invalid price entered. Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }
}