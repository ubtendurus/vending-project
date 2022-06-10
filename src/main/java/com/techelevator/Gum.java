package com.techelevator;

import java.math.BigDecimal;

public class Gum extends VendingMachineItem {
    public Gum(String slotLocation, String name, BigDecimal price, String productType){
        super(slotLocation, name, price, productType);
    }


    public void dispensingMessage(){
        System.out.println("Chew Chew, Yum!");
    }
}
