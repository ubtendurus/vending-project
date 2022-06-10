package com.techelevator;

import java.math.BigDecimal;

public interface Purchasable {
    String getSlotLocation();
    BigDecimal getPrice();
    String getName();
    String getProductType();
    void dispenseMessage();

}
