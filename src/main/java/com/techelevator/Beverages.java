package com.techelevator;

import java.math.BigDecimal;

public class Beverages extends VendingMachineItems{

    public Beverages(String slotLocation, String name, BigDecimal price, String productType){
        super(slotLocation, name, price, productType);
    }

    @Override
    public void dispensingMessage(){
        System.out.println("Glug Glug, Yum!");
    }
}
