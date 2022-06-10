package com.techelevator;

import java.math.BigDecimal;

public class Beverage extends VendingMachineItem {

    public Beverage(String slotLocation, String name, BigDecimal price, String productType){
        super(slotLocation, name, price, productType);
    }


    public void dispensingMessage(){
        System.out.println("Glug Glug, Yum!");
    }
}
