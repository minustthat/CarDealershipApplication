package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Dealership {
    static final String TITLE = "O'NEALERSHIP";
    static final String ADDRESS = "52 GRANDEUR AVE";
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
    static final String PHONE_NUMBER = "(818)-273-4950";

    public static void listAllVehicles() {
        vehicleInventory.forEach(Dealership::carToString);
    }


    public static void carToString(Vehicle vehicle) {
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
        Type newType = Type.valueOf(scanner.nextLine().toUpperCase());

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

        List<Vehicle> matchingPrice = vehicleInventory.stream()
                .filter(vehicle -> min <= vehicle.getPrice() && vehicle.getPrice() < max)
                .collect(Collectors.toList());
        matchingPrice.forEach(Dealership::carToString);

    }

    public static void getVehicleByMakeAndModel(){
        String make;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter make : ");
        make = scanner.nextLine();

        List<Vehicle> matchingMakes = vehicleInventory.stream()
                .filter(vehicle -> vehicle.getMake().equals(make))
                .collect(Collectors.toList());
        matchingMakes.forEach(Dealership::carToString);


    }

    public static void getVehicleByColor(){
        Scanner scanner = new Scanner(System.in);
        String color;
        System.out.println("Please enter color: ");
        color = scanner.nextLine();

        List<Vehicle> matchingColors = vehicleInventory.stream()
                .filter(vehicle -> vehicle.getColor().equals(color))
                .collect(Collectors.toList());
        matchingColors.forEach(Dealership::carToString);
    }

    public static void getVehicleByMileage(){
        Scanner scanner = new Scanner(System.in);
        int mileage;
        System.out.println("Please enter maximum mileage you would like to search for: ");
        int mileageSelection = scanner.nextInt();

        List <Vehicle> matchingMileage = vehicleInventory.stream()
                .filter(vehicle -> vehicle.getOdometerReading() <= mileageSelection)
                .collect(Collectors.toList());
        matchingMileage.forEach(Dealership::carToString);

    }

    public static void getVehicleByType(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the type of vehicle you are looking for: ");
        String type = scanner.nextLine();

       List <Vehicle> matchingTypes =  vehicleInventory.stream()
                .filter(vehicle -> type.equalsIgnoreCase(String.valueOf(vehicle.getType())))
               .collect(Collectors.toList());
       matchingTypes.forEach(Dealership::carToString);



    }



}
