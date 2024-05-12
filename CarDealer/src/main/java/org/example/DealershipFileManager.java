package org.example;

import java.io.*;

public class DealershipFileManager {
    public static void writeFile()
    {
        File dealerFile = new File("inventory.csv");
        try {
            FileWriter fileWriter = new FileWriter(dealerFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("hi");
        }
        catch(Exception e)
        {
            System.out.println("hm... Something went wrong");
        }

    }



}
