package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class VendingMachineItems implements PurchaseItem {
    //properties
    private String name;
    //private int count;
    private String slotLocation;
    private String productType;
    private BigDecimal price;

    //constructor
    public VendingMachineItems(String slotLocation, String name,
                               BigDecimal price, String productType) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    /*public int getCount(){
        return count;
    }*/
//    public void setCount(){
//        this.count = count;
//    }
    public String getSlotLocation() {
        return slotLocation;
    }

    public void setSlotLocation() {
        this.slotLocation = slotLocation;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType() {
        this.productType = productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    /*public void setPrice(){
        this.price = price;
    }*/
    //abstract dispensing message
    public abstract void dispensingMessage();

    @Override
    public String toString() {
        return String.format("%s - %s - %.2f - %s", getSlotLocation(), getName(), getPrice(), getProductType());
    }


    // LIST THE ITEMs from CSV
    public static void displayItems() {
        String pathFile = "vendingmachine.csv";
        File itemFile = new File(pathFile);

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
                    VendingMachineItems vendingMachineItems = null;

                    if (itemType.equals("Chip")) {
                        vendingMachineItems = new Chips(slotLocation, itemName, dbItemPrice, itemType);
                        System.out.println(vendingMachineItems.toString());
                    }
                    if (itemType.equals("Candy")) {
                        vendingMachineItems = new Candy(slotLocation, itemName, dbItemPrice, itemType);
                        System.out.println(vendingMachineItems.toString());
                    }
                    if (itemType.equals("Gum")) {
                        vendingMachineItems = new Gum(slotLocation, itemName, dbItemPrice, itemType);
                        System.out.println(vendingMachineItems.toString());
                    }
                    if (itemType.equals("Drink")) {
                        vendingMachineItems = new Beverages(slotLocation, itemName, dbItemPrice, itemType);
                        System.out.println(vendingMachineItems.toString());
                    }
                    //System.out.println(vendingMachineItems.toString());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    // GET THE SlotLocation and Price from CSV

    public static Map<String, BigDecimal> retrieveItems() {
        Map<String, BigDecimal> vendingItem = new HashMap<>();

        String pathFile = "vendingmachine.csv";
        File itemFile = new File(pathFile);

        try (Scanner lineFile = new Scanner(itemFile)) {

            while (lineFile.hasNextLine()) {
                String currentLine = lineFile.nextLine();
                if (!currentLine.isEmpty()) {
                    String[] data = currentLine.split(Pattern.quote("|"));
                    String itemPrice = data[2];
                    BigDecimal dbItemPrice = new BigDecimal(itemPrice);
                    vendingItem.put(data[0], dbItemPrice);
                }

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        // DEBUG item in MAP
        /*for(Map.Entry<String, BigDecimal> item : vendingItem.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());
        }*/
        return vendingItem;
    }

}
