package com.techelevator;

import java.math.BigDecimal;

public class Candy extends VendingMachineItems{
    public Candy(String slotLocation, String name, BigDecimal price, String productType){
        super(slotLocation, name, price, productType);
    }

    @Override
    public void dispensingMessage(){
        System.out.println("Munch Munch, Yum!");
    }
}
