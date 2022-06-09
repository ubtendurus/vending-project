package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {
    //TODO - add an exit option (and sales report option *OPTIONAL*)
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    // Sub menu
    private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String SUB_MENU_OPTION_SELECT_PRODUCT= "Select Product";
    private static final String SUB_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,MAIN_MENU_OPTION_EXIT};
    private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_OPTION_FEED_MONEY,SUB_MENU_OPTION_SELECT_PRODUCT,SUB_MENU_OPTION_FINISH_TRANSACTION};

    private Menu menu;
    private Menu subMenu;

    Money currentBalance = new Money();

    public VendingMachineCLI(Menu menu, Menu subMenu) {
        this.menu = menu;
        this.subMenu = subMenu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                //PurchaseItem.retrieveItems();
		        VendingMachineItems.displayItems();

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // TODO - display current balance

                System.out.println(currentBalance.getBalance());

                // list sub menu
                subMenu();
                // do purchase
            }
            else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.exit(1);
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
    public void subMenu() {
        while (true) {
            String subChoice = (String) subMenu.getChoiceFromOptions(SUB_MENU_OPTIONS);
            if (subChoice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
                // add money
                currentBalance.addBalance("3");

            } else if (subChoice.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {
                // Purchase product
                VendingMachineItems.retrieveItems();

            } else if (subChoice.equals(SUB_MENU_OPTION_FINISH_TRANSACTION)) {
                // Complete Transaction
                break;
            }
        }
    }


    // TODO - LOG WILL BE CREATED HERE

}
