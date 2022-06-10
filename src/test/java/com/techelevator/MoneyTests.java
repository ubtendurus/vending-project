package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyTests {

    Money testMoney;

    @Before
    public void beforeEachTest(){
        //Arrange
        BigDecimal testBalance = new BigDecimal("30");
        int userId = 1234;
        testMoney = new Money(testBalance,userId);
        //System.out.println("Test Started!");
    }

    @Test
    public void test_get_balance(){
        // Act
        BigDecimal expectedResult = new BigDecimal("30");
        BigDecimal result = testMoney.getBalance();
        // Assert
        Assert.assertEquals("Balance is not updated",expectedResult,result);
    }

    @Test
    public void test_set_balance(){
        BigDecimal expectedResult = new BigDecimal("40");
        BigDecimal result = testMoney.setBalance(new BigDecimal("40"));

        //Assert
        Assert.assertEquals("Set balance doesn't add up the value",expectedResult,result);
    }


}
