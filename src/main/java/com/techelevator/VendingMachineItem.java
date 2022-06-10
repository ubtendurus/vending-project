package com.techelevator;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VendingMachineItem implements Purchasable {
    //properties
    private String name;
    private String slotLocation;
    private String productType;
    private BigDecimal price;
    private int count = INITIAL_PRODUCT_QUANTITY;
    private static final int INITIAL_PRODUCT_QUANTITY = 5;

    private Map<String, VendingMachineItem> vendingItem = new HashMap<>();

    //constructor
    public VendingMachineItem(String slotLocation, String name,
                               BigDecimal price, String productType) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.productType = productType;
        count = INITIAL_PRODUCT_QUANTITY;
    }
    public VendingMachineItem(String name, BigDecimal price, String productType){
        this.name = name;
        this.price = price;
        this.productType = productType;
        count = INITIAL_PRODUCT_QUANTITY;
    }
    public VendingMachineItem(){

    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }
    public String getSlotLocation() {
        return slotLocation;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    //abstract dispensing message NOT NEEDED BECAUSE WOULD BE CALLED IN MFS
   // public abstract void dispensingMessage();

//    @Override
//    public String toString() {
//        return String.format("%s - %s - %.2f - %s", getSlotLocation(), getName(), getPrice(), getProductType());
//    }




}
