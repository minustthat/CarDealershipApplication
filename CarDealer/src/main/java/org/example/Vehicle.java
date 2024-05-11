package org.example;

public class Vehicle {
        int vinNumber;
        int year;
        String make;
        String model;
        String type;
        String color;
        int odometerReading;
        double price;

        public Vehicle(int vinNumber, int year, String make, String model, String type,
                       String color, int odometerReading, double price) {
            this.vinNumber = vinNumber;
            this.year = year;
            this.make = make;
            this.model = model;
            this. type = type;
            this.color = color;
            this.odometerReading = odometerReading;
            this.price = price;

        }
        public Vehicle(){

        }
}
