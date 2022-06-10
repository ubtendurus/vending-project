package com.techelevator;

import java.util.Map;

public class Stock {
    // LIST THE ITEMs from CSV
    public static void displayItems(Map<String, VendingMachineItem> productMap) {
        for(Map.Entry<String, VendingMachineItem> entry : productMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getName() + " " +
<<<<<<< HEAD
                    entry.getValue().getPrice() + " Stock left: " + entry.getValue().getCount());
=======
                    entry.getValue().getPrice());
>>>>>>> 019349ef39995223f081188e83ceb88a1302f80c
        }
    }
    public static boolean checkStock(Map<String, VendingMachineItem> masterMap, String itemSelection){
        if(masterMap.get(itemSelection).getCount() >= 1){
            return true;
        }
        return false;
    }
    public static void reduceStock(Map<String, VendingMachineItem> masterMap, String itemSelection){
        masterMap.get(itemSelection).setCount(masterMap.get(itemSelection).getCount() - 1);
    }
}
