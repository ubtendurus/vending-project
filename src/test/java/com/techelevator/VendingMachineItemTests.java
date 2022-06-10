package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class VendingMachineItemTests {
    VendingMachineItem vendingMachineItem;

    //String slotLocation, String name,BigDecimal price, String productType
    @Before
    public void beforeEachTest(){
        String slotLocationTest = "E1";
        String nameTest = "Snickers";
        BigDecimal priceTest = new BigDecimal("2.5");
        String productTypeTest = "Candy";
        vendingMachineItem = new VendingMachineItem(slotLocationTest,nameTest,priceTest,productTypeTest);
    }

    @Test
    public void test_get_item_name(){
        String expectedResult = "Snickers";
        String result = vendingMachineItem.getName();
        // Assert
        Assert.assertEquals("Name doesn't match!",expectedResult,result);
    }

    @Test
    public void test_get_item_price(){
        BigDecimal expectedResult = new BigDecimal("2.5");
        BigDecimal result = vendingMachineItem.getPrice();

        Assert.assertEquals("Price doesn't match!",expectedResult,result);
    }

    @Test
    public void test_get_product_type(){
        String expectedResult = "Candy";
        String result = vendingMachineItem.getProductType();

        Assert.assertEquals("Product type doesn't match!",expectedResult,result);
    }
    @Test
    public void test_get_slot_location(){
        String expectedResult = "E1";
        String result = vendingMachineItem.getSlotLocation();

        Assert.assertEquals("Slot Location doesn't match!",expectedResult,result);
    }
}
