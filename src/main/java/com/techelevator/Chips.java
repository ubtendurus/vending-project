package com.techelevator;

import java.math.BigDecimal;

public class Chips extends VendingMachineItems{
    public Chips(String slotLocation, String name, BigDecimal price, String productType){
        super(slotLocation, name, price, productType);
    }

    @Override
    public void dispensingMessage(){
        System.out.println("Crunch Crunch, Yum!");
    }


}
