package com.techelevator;

import java.math.BigDecimal;

public class Money {
    private BigDecimal balance;
    public Money(BigDecimal balance){
        this.balance = balance;
    }

    public Money(){
        this.balance = new BigDecimal("0");
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal addBalance(String dollarAmount){
        return balance.add(new BigDecimal(dollarAmount));
    }

    public BigDecimal spendBalance(String spendAmount){
        return balance.subtract(new BigDecimal(spendAmount));
    }

}
