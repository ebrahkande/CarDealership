package com.pluralsight;

// import
import java.util.ArrayList;
import java.util.List;

public class Dealership {

    // Create properties for the class
    private String name;
    private String address;
    private String phone;

    // Holds the dealership inventory
    private ArrayList<Vehicle> inventory;

    // Constructor
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;

        // Initialize the empty for the inventory
        this.inventory = new ArrayList<Vehicle>();
    }

    // Method to filter vehicles by price
    public List<Vehicle> getVehicleByPrice(double min, double max){
        return null;
    }

    // Method to filter vehicles by model
    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        return null;
    }

    // Method to filter vehicles by year
    public List<Vehicle> getVehicleByYear(int min, int max){
        return null;
    }

    // Method to filter vehicles by color
    public List<Vehicle> getVehicleByColor(String color){
        return null;
    }

    // Method to filter vehicles by mileage
    public List<Vehicle> getVehicleByMileage(int min, int max){
        return null;
    }

    // Method to filter vehicles by type
    public List<Vehicle> getVehicleByType(String vehicleType){
        return null;
    }

    // Method to filter vehicles by all
    public List<Vehicle> getAllVehicles(){
        return this.inventory;
    }

    // Add vehicle to inventory
    public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
    }

    // Remove vehicle to inventory
    public void removeVehicle(){

    }

    // Getters and Setters for the string properties


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
