package org.example;

import java.io.*;
import java.util.Scanner;

import static org.example.Dealership.*;

public class DealershipFileManager {
    public static void writeAllToFile(){
        File dealerFile = new File("inventory.csv");

        try {
            FileWriter fileWriter = new FileWriter(dealerFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(" Vin | Year | Make | Model | Type | Color | Odometer Reading | Price ");
            for(Vehicle vehicle: vehicleInventory) {
                printWriter.println(vehicle.getVinNumber() + "|" + vehicle.getYear() + "|" + vehicle.getMake() +
                        "|" + vehicle.getModel() + "|" + vehicle.getType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometerReading() +
                        "|" + vehicle.getPrice());
            }
            printWriter.close();

        }
        catch(Exception e)
        {
            System.out.println("hm... Something went wrong");
        }
    }
    public static void readFile(){
        File dealerFile = new File("inventory.csv");

        try(BufferedReader reader = new BufferedReader(new FileReader(dealerFile))){
            String line;
            reader.readLine();
            while((line = reader.readLine())  != null){
                String[] cols = line.split("[|]");
                int vin = Integer.parseInt(cols[0]);
                int year = Integer.parseInt(cols[1]);
                String make = cols[2];
                String model = cols[3];
                Type type = Type.valueOf(cols[4]);
                String color = cols[5];
                int mileage = Integer.parseInt(cols[6]);
                double price = Double.parseDouble(cols[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, mileage, price);
                vehicleInventory.add(vehicle);
                System.out.println(vehicle);

            }

        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Items could not be loaded");
        }
        catch(IOException e){
            System.out.println("File could not be loaded.");
        }
    }
}
