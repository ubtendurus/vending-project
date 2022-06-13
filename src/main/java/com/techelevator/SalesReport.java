package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;

public class SalesReport {
    private static final int INITIAL_PRODUCT_QUANTITY = 5;

    String filePath = "src\\main\\java\\com\\techelevator\\salesReport.txt";
    File salesReport = new File(filePath);

    //generate report
    public void createSalesReport(Map<String, VendingMachineItem> map){
        BigDecimal totalSales = new BigDecimal("0");
        try(PrintWriter writeSalesReport = new PrintWriter(salesReport)){
            if(salesReport.exists()) {
                for (Map.Entry<String, VendingMachineItem> item : map.entrySet()) {
                    String productName = item.getValue().getName();
                    BigDecimal productPrice = item.getValue().getPrice();
                    int productLeft = item.getValue().getCount();
                    int productSold = INITIAL_PRODUCT_QUANTITY - productLeft;
                    if (productSold > 0) {
                        String sProductSold = Integer.toString(productSold);
                        totalSales = totalSales.add(productPrice.multiply(new BigDecimal(sProductSold)));
                    }
                    writeSalesReport.println(productName + "|" + productSold);
                }
                writeSalesReport.println("Total sales: " + totalSales);
            }
            }catch(FileNotFoundException e){
                System.out.println("File not found");
            }catch(Exception e){
                System.out.println("Oops! Something went wrong");
            }
        }
    }



