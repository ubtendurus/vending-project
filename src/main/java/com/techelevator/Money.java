package com.techelevator;

import java.math.BigDecimal;

public class Money {
    private BigDecimal balance;
    private int userId;
    public Money(BigDecimal balance){
        this.balance = balance;
    }

    public Money(int userId){
        this.balance = new BigDecimal("0");
        this.userId = userId;
    }

    public int getUserId(){
        return userId;
    }
    public void setUserId(){
        this.userId = userId;
    }
    public BigDecimal getBalance(int userId) {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal addBalance(String dollarAmount, int userId){
        return balance.add(new BigDecimal(dollarAmount));
    }

    public BigDecimal spendBalance(String spendAmount){
        return balance.subtract(new BigDecimal(spendAmount));
    }

}
