package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {

    private final String FILE_PATH = "src/main/resources/inventory.csv";

    // Method to read the file and build the Dealership object
    public Dealership getDealership(){

        Dealership theDealership = null;

        try{

            BufferedReader inventoryReader = new BufferedReader(new FileReader(FILE_PATH));

            String dealershipInfo = inventoryReader.readLine();

            if(dealershipInfo != null){

                String[] dealershipParts = dealershipInfo.split("\\|");
                String name = dealershipParts[0];
                String address = dealershipParts[1];
                String phone = dealershipParts[2];

                theDealership = new Dealership(name, address, phone);

            }

            String vehicleInfo;
            while((vehicleInfo = inventoryReader.readLine()) != null){

                String[] vehicleParts = vehicleInfo.split("\\|");

                int vin = Integer.parseInt(vehicleParts[0]);
                int year = Integer.parseInt(vehicleParts[1]);
                String make = vehicleParts[2];
                String model = vehicleParts[3];
                String type = vehicleParts[4];
                String color = vehicleParts[5];
                int odometer = Integer.parseInt(vehicleParts[6]);
                double price = Double.parseDouble(vehicleParts[7]);

                Vehicle theVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);

                theDealership.addVehicle(theVehicle);

            }

            //close the csv
            inventoryReader.close();


        }catch (Exception e){
            System.out.println("Couldn't parse inventory file " + e.getMessage());
        }



        //return the created dealership
        return theDealership;
    }



    // Stay empty for now
    public void saveDealership(){

    }
}
