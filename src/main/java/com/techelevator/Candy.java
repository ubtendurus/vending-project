package com.techelevator;

import java.math.BigDecimal;

public class Candy extends VendingMachineItem {
    public Candy(String slotLocation, String name, BigDecimal price, String productType){
        super(slotLocation, name, price, productType);
    }


    public void dispensingMessage(){
        System.out.println("Munch Munch, Yum!");
    }
}
