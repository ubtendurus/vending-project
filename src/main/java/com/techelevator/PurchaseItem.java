package com.techelevator;

import java.math.BigDecimal;
import java.util.Map;

public interface PurchaseItem {

    String getSlotLocation();
    BigDecimal getPrice();
    String getName();
    String getProductType();

    // GET THE SlotLocation and Price from CSV
    //Map<String, BigDecimal> retrieveItems();


}
