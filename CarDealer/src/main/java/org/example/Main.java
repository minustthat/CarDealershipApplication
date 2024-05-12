package org.example;

import java.util.Locale;
import java.util.Scanner;

import static org.example.Dealership.*;
import static org.example.DealershipFileManager.writeFile;
import static org.example.UserInterface.homeScreen;
import static org.example.UserInterface.inventorySearch;

public class Main {


    public static void main(String[] args) {
        writeFile();
        Scanner scanner = new Scanner(System.in);
        homeScreen();
        int userChoice = scanner.nextInt();
        switch(userChoice){
            case 1:
                inventorySearch(scanner);
                break;
            case 2:
                addVehicle();
                break;
            case 3:
            removeVehicle();
            break;
            case 4:
            break;
        }

    }




}