package com.techelevator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Money {
    private BigDecimal balance;
    private int userId;
    private BigDecimal quarter = new BigDecimal("0.25");
    private BigDecimal dime= new BigDecimal("0.10");
    private BigDecimal nickel = new BigDecimal("0.05");
    private BigDecimal penny = new BigDecimal("0.01");
    private BigDecimal numberOfQuarters = new BigDecimal("0");
    private BigDecimal numberOfDimes = new BigDecimal("0");
    private BigDecimal numberOfNickels = new BigDecimal("0");
    private BigDecimal numberOfPennies = new BigDecimal("0");

    public Money(BigDecimal balance,int userId){
        this.userId = userId;
        this.balance = balance;
    }

    public Money(int userId){
        this.userId = userId;
        this.balance = new BigDecimal("0");
    }

    public void dispenseChange(Money customerMoney){
        System.out.println("Your dispensed change is: ");

        while(customerMoney.getBalance().compareTo(quarter) > 0){
            numberOfQuarters = numberOfQuarters.add(new BigDecimal("1"));
            customerMoney.setBalance(customerMoney.getBalance().subtract(quarter));
        }
        while(customerMoney.getBalance().compareTo(dime) > 0){
            numberOfDimes = numberOfDimes.add(new BigDecimal("1"));
            customerMoney.setBalance(customerMoney.getBalance().subtract(dime));
        }
        while(customerMoney.getBalance().compareTo(nickel) > 0){
            numberOfNickels = numberOfNickels.add(new BigDecimal("1"));
            customerMoney.setBalance(customerMoney.getBalance().subtract(nickel));
        }
        while(customerMoney.getBalance().compareTo(penny) >= 0){
            numberOfPennies = numberOfPennies.add(new BigDecimal("1"));
            customerMoney.setBalance(customerMoney.getBalance().subtract(penny));
        }

        if(numberOfQuarters.compareTo(new BigDecimal("1")) != 0) {
            System.out.println(numberOfQuarters + " quarters");
        } else {
            System.out.println(numberOfQuarters + " quarter");
        }

        if(numberOfDimes.compareTo(new BigDecimal("1")) != 0) {
            System.out.println(numberOfDimes + " dimes");
        } else {
            System.out.println(numberOfDimes + " dime");
        }

        if(numberOfNickels.compareTo(new BigDecimal("1")) != 0) {
            System.out.println(numberOfNickels + " nickels");
        } else {
            System.out.println(numberOfNickels + " nickel");
        }

        if(numberOfPennies.compareTo(new BigDecimal("1")) != 0) {
            System.out.println(numberOfPennies + " pennies");
        } else {
            System.out.println(numberOfPennies + " penny");
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal setBalance(BigDecimal balance) {
        this.balance = balance;
        return balance;
    }

    //scans inputs for all methods
    Scanner scanner = new Scanner(System.in);
    MachineFileSystem logFile = new MachineFileSystem();

    public void feedMoney(Money customerMoney){
        System.out.println("How much would you like to deposit?");
        String amountToFeed = scanner.nextLine();
        BigDecimal bdAmountToFeed = new BigDecimal(amountToFeed);
        if(amountToFeed.contains("-")){
            logFile.transactionLog("Feed Money Failed",bdAmountToFeed,customerMoney.getBalance());
        }else{
            customerMoney.setBalance(customerMoney.getBalance().add(bdAmountToFeed));
            logFile.transactionLog("Feed Money",bdAmountToFeed,customerMoney.getBalance());
        }
    }

    public void purchaseItem(Map<String, VendingMachineItem> masterMap, Money customerMoney){
        System.out.println("Please enter the slot number here:");
        String slotNumber = scanner.nextLine();
        for(Map.Entry<String, VendingMachineItem> item : masterMap.entrySet()){
            if(item.getKey().equals(slotNumber.toUpperCase())){
                if(Stock.hasEnoughStock(masterMap, slotNumber.toUpperCase())){
                    if(item.getValue().getPrice().compareTo(customerMoney.getBalance()) == 1) {
                        System.out.println("You do not have enough funds");
                        break;
                    }
                    Stock.reduceStock(masterMap, slotNumber.toUpperCase());
                    logFile.updateSalesReport(item.getValue().getName());
                    item.getValue().dispenseMessage();
                    customerMoney.setBalance(customerMoney.getBalance().subtract(item.getValue().getPrice()));
                }else{
                    System.out.println("Out of stock, sorry!");
                }
                logFile.transactionLog(item.getValue().getName(),item.getValue().getPrice(),customerMoney.getBalance());
                break;
            }
        }
    }

    public void finishTransaction(Money customerMoney){
        System.out.println("Are you sure you would you like to finish your transaction? (Y/N)");
        String userInput = scanner.nextLine();
        if(userInput.substring(0, 1).equalsIgnoreCase("Y")){
            BigDecimal balanceBeforeFinishing = customerMoney.getBalance();
            System.out.println("Thank you for shopping with us!");
            dispenseChange(customerMoney);
            logFile.transactionLog("Withdrawal",balanceBeforeFinishing,customerMoney.getBalance());
        } else if(userInput.substring(0, 1).equalsIgnoreCase("N")) {
            System.out.println("Okay, taking you back to Main Menu");
        } else {
            System.out.println("Please provide a valid response");
        }
    }
}