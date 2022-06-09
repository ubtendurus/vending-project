package com.techelevator;

import java.math.BigDecimal;

public class ShoppingCart implements Purchasable{
    private String slotLocation;
    private String name;
    private BigDecimal price;
    private String productType;

    static int itemAmount = 5;

    public ShoppingCart(String slotLocation, String name, BigDecimal price, String productType){
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    @Override
    public String getSlotLocation() {
        return slotLocation;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }


    public BigDecimal getMoney(){
        return price;
    }

    @Override
    public String getProductType() {
        return productType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    // TODO purchase ITEM
    public void purchaseItem(String slotLocation){

    }

}
