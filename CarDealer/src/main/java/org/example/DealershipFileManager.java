package org.example;

import java.io.*;

public class DealershipFileManager {
    public static void writeFile()
    {
        File dealerFile = new File("inventory.csv");
        try {
            FileWriter fileWriter = new FileWriter(dealerFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("");

        }
        catch(Exception e)
        {
            System.out.println("hm... Something went wrong");
        }

    }



}
