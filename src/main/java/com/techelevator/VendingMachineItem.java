package com.techelevator;


import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Map;


public class VendingMachineItem implements Purchasable {
    //properties
    private String name;
    private String slotLocation;
    private String productType;
    private BigDecimal price;
    private int count = INITIAL_PRODUCT_QUANTITY;
    private static final int INITIAL_PRODUCT_QUANTITY = 5;

 //   private Map<String, VendingMachineItem> vendingItem = new HashMap<>();

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
    public void dispenseMessage(){
        if(productType.equals("Chip")){
            System.out.println("Crunch Crunch, Yum!");
        } else if(productType.equals("Candy")){
            System.out.println("Munch Munch, Yum!");
        }else if(productType.equals("Gum")){
            System.out.println("Chew Chew, Yum!");
        }else if(productType.equals("Drink")){
            System.out.println("Glug Glug, Yum!");
        }
    }
}
