package com.techelevator;

import java.math.BigDecimal;

public abstract class VendingMachineItems {
    //properties
    private String name;
    private int count;
    private String slotLocation;
    private String productType;
    private BigDecimal price;
    //constructor
    public VendingMachineItems(String slotLocation, String name,
                               BigDecimal price, String productType){
    }
    //getters and setters
    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
    public int getCount(){
        return count;
    }
    public void setCount(){
        this.count = count;
    }
    public String getSlotLocation(){
        return slotLocation;
    }
    public void setSlotLocation(){
        this.slotLocation = slotLocation;
    }
    public String getProductType(){
        return productType;
    }
    public void setProductType(){
        this.productType = productType;
    }
    public BigDecimal getPrice(){
        return price;
    }
    public void setPrice(){
        this.price = price;
    }
    //abstract dispensing message
    public abstract void dispensingMessage();

}
