package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class MachineFileSystem {
    String pathFile = "vendingmachine.csv";
    File itemFile = new File(pathFile);

    public Map<String, VendingMachineItem> startUp() {
        Map<String, VendingMachineItem> initialMap = new TreeMap<>();
        try (Scanner lineFile = new Scanner(itemFile)) {
            while (lineFile.hasNextLine()) {
                String currentLine = lineFile.nextLine();
                if (!currentLine.isEmpty()) {
                    String[] data = currentLine.split(Pattern.quote("|"));
                    String slotLocation = data[0];
                    String itemName = data[1];
                    String itemPrice = data[2];
                    String itemType = data[3];
                    BigDecimal dbItemPrice = new BigDecimal(itemPrice);
                //cut off here
                    VendingMachineItem item = new VendingMachineItem(itemName, dbItemPrice, itemType);
                    initialMap.put(slotLocation, item);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println("Oh no! Something went wrong");
        }
        return initialMap;
    }
}
