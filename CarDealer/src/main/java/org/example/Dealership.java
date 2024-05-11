package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Dealership {
    private final String TITLE = "O'NEALERSHIP";
    private final String ADDRESS = "52 GRANDEUR AVE";
    // <editor-fold desc="List of Vehicles">
    static List<Vehicle> vehicleInventory = new ArrayList<>(Arrays.asList(new Vehicle(11121, 2021, "Honda", "Civic", Type.SEDAN, "Blue", 109000, 12000),
            new Vehicle(11122, 2021, "Jeep", "Compass", Type.SUV, "Red", 1000, 34000),
            new Vehicle(11123, 2022, "Acura", "TL", Type.COUPE, "Black", 20000, 26000),
            new Vehicle(11124, 2020, "Jeep", "Wrangler", Type.SUV, "Orange", 500, 37000),
            new Vehicle(11125, 2017, "Ford", "Taurus", Type.SEDAN, "White", 113000, 11000),
            new Vehicle(11126, 2019, "BMW", "M2", Type.COUPE, "Blue", 16000, 29000),
            new Vehicle(11127, 2017, "Volkswagon", "Jetta", Type.SEDAN, "Teal", 103000, 15500),
            new Vehicle(11128, 2022, "Nissan", "Sentra", Type.SEDAN, "Gray", 36000, 22450),
            new Vehicle(11129, 2024, "Hyundai", "Sonata", Type.SEDAN, "Yellow", 96, 27860),
            new Vehicle(11130, 2020, "Scion", "TC", Type.COUPE, "Red", 54000, 19873),
            new Vehicle(11131, 2019, "Subaru", "Outback", Type.HATCHBACK, "Yellow", 34500, 23476))
    );
// </editor-fold>


    public static void listAllVehicles() {
//        for(Vehicle vehicle: vehicleInventory){
//            System.out.println(carToString(vehicle));
//        }
        // for each item, go into the dealership class and do the toString function.
        vehicleInventory.forEach(Dealership::carToString);
    }


    public static void carToString(Vehicle vehicle) {
// any vehicle can be passed in -> can be used for the sorting algos
        String vehicles =
                "Vin: " + vehicle.vinNumber + "\n" + "Year: " + vehicle.year + "\n" + "Make: " + vehicle.make +
                        "\n" +
                        "Model: " + vehicle.model + " " + vehicle.type + "\n" + "Color: " + vehicle.color + "\n" +
                        "Mileage: " + vehicle.odometerReading + "\n" + "Price: " + vehicle.price +
                        "\n -------------------------";

        System.out.println(vehicles);

    }

    public static void removeVehicle() {

    }

    public static void addVehicle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter vin of vehicle you like to add: ");
        int newVin = scanner.nextInt();

        System.out.println("Please enter Year");
        int newYear = scanner.nextInt();

        System.out.println("Please enter Make");
        String newMake = scanner.nextLine();

        scanner.nextLine();
        System.out.println("Please enter Model:");
        String newModel = scanner.nextLine();

        System.out.println("Please enter Type: ");
        Type newType = Type.valueOf(scanner.nextLine());

        System.out.println("Please enter Color: ");
        String newColor = scanner.nextLine();

        System.out.println("Please enter Mileage: ");
        int newMileage = scanner.nextInt();

        System.out.println("Please enter Price: ");
        double price = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(newVin, newYear, newMake, newModel, newType, newColor, newMileage, price);
        vehicleInventory.add(newVehicle);

    }

    public static void getVehicleByPrice(){
        int min;
        int max;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter minimum price of search ");
        min = scanner.nextInt();
        System.out.println("Please enter maximum price of search ");
        max = scanner.nextInt();
        for(Vehicle vehicle: vehicleInventory){
            if(min<= vehicle.price && vehicle.price < max){
                carToString(vehicle);
            }
        }

    }

    public static void getVehicleByMakeAndModel(){
        String make = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter make : ");
        make = scanner.nextLine();
        for (Vehicle vehicle: vehicleInventory){
            if(make.equals(vehicle.getMake())){
                carToString(vehicle);
            }
        }


    }

    public static void getVehicleByColor(){
        Scanner scanner = new Scanner(System.in);
        String color;
        System.out.println("Please enter color: ");
        color = scanner.nextLine();
        for(Vehicle vehicle: vehicleInventory){
            if (color.equals(vehicle.getColor())){
                carToString(vehicle);
            }
        }
    }

    public static void getVehicleByMileage(){
        Scanner scanner = new Scanner(System.in);
        int mileage;
        System.out.println("Please enter mileage you would like to search for: ");
        int mileageSelection = scanner.nextInt();
        for(Vehicle vehicle: vehicleInventory){
            if(mileageSelection == vehicle.getOdometerReading()){
                carToString(vehicle);
            }
        }

    }

    public static void getVehicleByType(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the type of vehicle you are looking for: ");
        String type = scanner.nextLine();
        for(Vehicle vehicle: vehicleInventory) {
            if(type.equals(String.valueOf(vehicle.getType()))){
                carToString(vehicle);
            }

        }    }



}
