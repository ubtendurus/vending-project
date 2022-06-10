package com.techelevator;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Map;

public class VendingMachineCLI {
    //TODO - add an exit option (and sales report option *OPTIONAL*)
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String MAIN_MENU_CREATE_SALES_REPORT = "Create Sales Report";
    // Sub menu
    private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String SUB_MENU_OPTION_SELECT_PRODUCT= "Select Product";
    private static final String SUB_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_OPTION_EXIT, MAIN_MENU_CREATE_SALES_REPORT};
    private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_OPTION_FEED_MONEY,SUB_MENU_OPTION_SELECT_PRODUCT,SUB_MENU_OPTION_FINISH_TRANSACTION};

    private Menu menu;
    private Menu subMenu;
    static int rndmSession = (int)(Math.random() * 100);

    Money customerMoney = new Money(new BigDecimal("0"), rndmSession);

    //call within main method
    public VendingMachineCLI(Menu menu, Menu subMenu) {
        this.menu = menu;
        this.subMenu = subMenu;
    }

    public void run() {
        MachineFileSystem mfs = new MachineFileSystem();
        Map<String, VendingMachineItem> masterMap = mfs.startUp();
        SalesReport sr = new SalesReport();
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
		        Stock.displayItems(masterMap);

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                System.out.println("You currently have $" + customerMoney.getBalance());
                // list sub menu
                subMenu(masterMap, customerMoney);
            }
            else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.exit(0);
            } else if (choice.equals(MAIN_MENU_CREATE_SALES_REPORT)) {
                sr.createSalesReport(masterMap);
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        Menu subMenu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu,subMenu);
        cli.run();
    }

    //Sub Menu Create
    public void subMenu(Map<String, VendingMachineItem> masterMap, Money customerMoney) {
        while (true) {
            String subChoice = (String) subMenu.getChoiceFromOptions(SUB_MENU_OPTIONS);
            if (subChoice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
                System.out.println("Your current balance is $" + customerMoney.getBalance());
                // add money
                customerMoney.feedMoney(customerMoney);
                //debug
                System.out.println("Your updated balance is $" + customerMoney.getBalance());

            } else if (subChoice.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {
                // Purchase product
                customerMoney.purchaseItem(masterMap, customerMoney);
                System.out.println("Your updated balance after purchase is $" + customerMoney.getBalance());

            } else if (subChoice.equals(SUB_MENU_OPTION_FINISH_TRANSACTION)) {
                // Complete Transaction
                customerMoney.finishTransaction(customerMoney);
                break;
            }
        }
    }

}
