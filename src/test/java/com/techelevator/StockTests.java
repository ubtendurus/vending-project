package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class StockTests {
    private Stock testStock;
    //arrange
    @Before
    public void setup(){
        testStock = new Stock();
        Map<String, VendingMachineItem> testMap = new TreeMap<>();
        testMap.put("A1", new VendingMachineItem("Potato Crisps", new BigDecimal("3.05"), "Chip"));
    }
    //act
    @Test
    public void test_display_items(Map<String, VendingMachineItem> testMap){

    }
    //assert
}
