package com.techelevator;

import java.math.BigDecimal;

public class Money {
    private BigDecimal balance;
    private int userId;
    public Money(BigDecimal balance,int userId){
        this.userId = userId;
        this.balance = balance;
    }

    public Money(int userId){
        this.userId = userId;
        this.balance = new BigDecimal("0");
    }

    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal setBalance(BigDecimal balance) {
        this.balance = balance;
        return balance;
    }

    public BigDecimal addBalance(String dollarAmount){
        return balance.add(new BigDecimal(dollarAmount));
    }

    public BigDecimal spendBalance(String spendAmount){
        return balance.subtract(new BigDecimal(spendAmount));
    }

}
