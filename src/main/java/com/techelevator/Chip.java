package com.techelevator;

import java.math.BigDecimal;

public class Chip extends VendingMachineItem {
    public Chip(String slotLocation, String name, BigDecimal price, String productType){
        super(slotLocation, name, price, productType);
    }


    public void dispensingMessage(){
        System.out.println("Crunch Crunch, Yum!");
    }


}
