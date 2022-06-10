package com.techelevator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

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

//    public int getUserId(){
//        return userId;
//    }
//    public void setUserId(int userId){
//        this.userId = userId;
//    }
    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal setBalance(BigDecimal balance) {
        this.balance = balance;
        return balance;
    }

//    public BigDecimal addBalance(String dollarAmount){
//        return balance.add(new BigDecimal(dollarAmount));
//    }
//
//    public BigDecimal spendBalance(BigDecimal spendAmount){
//        return balance.subtract(spendAmount);
//    }

    //scans inputs for all methods
    Scanner scanner = new Scanner(System.in);

    public void feedMoney(Money customerMoney){
        System.out.println("How much would you like to deposit?");
       // Scanner scanner = new Scanner(System.in);
        String amountToFeed = scanner.nextLine();
        BigDecimal bdAmountToFeed = new BigDecimal(amountToFeed);
        customerMoney.setBalance(customerMoney.getBalance().add(bdAmountToFeed));
    }

    public void purchaseItem(Map<String, VendingMachineItem> masterMap, Money customerMoney){
        System.out.println("Please enter the slot number here:");
        //Scanner scanner = new Scanner(System.in);
        String slotNumber = scanner.nextLine();
        for(Map.Entry<String, VendingMachineItem> item : masterMap.entrySet()){
            if(item.getKey().equals(slotNumber)){
                if(Stock.checkStock(masterMap, slotNumber)){
                    if(item.getValue().getPrice().compareTo(customerMoney.getBalance()) == 1) {
                        System.out.println("You do not have enough funds");
                        break;
                    }
                    Stock.reduceStock(masterMap, slotNumber);
                    item.getValue().dispenseMessage();
                }else{
                    System.out.println("Out of stock, sorry!");
                }
                customerMoney.setBalance(customerMoney.getBalance().subtract(item.getValue().getPrice()));
               // System.out.println("Purchased!");
                break;
            }
        }
    }

    public void finishTransaction(Money customerMoney){
        System.out.println("Are you sure you would you like to finish your transaction? (Y/N)");
        String userInput = scanner.nextLine();
        if(userInput.substring(0, 1).equalsIgnoreCase("Y")){
            BigDecimal balanceBeforeFinishing = customerMoney.getBalance();
            System.out.println("Thank you for shopping with us! Your remaining balance to be refunded is $" +
                    balanceBeforeFinishing);
            customerMoney.setBalance(new BigDecimal("0"));
        } else if(userInput.substring(0, 1).equalsIgnoreCase("N")) {
            System.out.println("Okay, taking you back to Main Menu");
        } else {
            System.out.println("Please provide a valid response");
        }
    }
}


