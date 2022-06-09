package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VendingMachineCLI {
    //TODO - add an exit option (and sales report option *OPTIONAL*)
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};

    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
		displayItems();

            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }


    public static void displayItems() {
        String pathFile = "vendingmachine.csv";
        File itemFile = new File(pathFile);

        try (Scanner lineFile = new Scanner(itemFile)) {
            while (lineFile.hasNextLine()) {
                String currentLine = lineFile.nextLine();
                if (!currentLine.isEmpty()) {
                    String[] data = currentLine.split(Pattern.quote("|"));
                    String slotLocation = data[0];
                    String itemName = data[1];
                    String itemPrice = data[2];
                    String itemType = data[3];
                    BigDecimal dbItemPrice = new BigDecimal(itemPrice);
                    VendingMachineItems vendingMachineItems = null;

                    if (itemType.equals("Chip")) {
						vendingMachineItems = new Chips(slotLocation, itemName, dbItemPrice, itemType);
						System.out.println(vendingMachineItems.toString());
					}
					if (itemType.equals("Candy")) {
						vendingMachineItems = new Candy(slotLocation, itemName, dbItemPrice, itemType);
						System.out.println(vendingMachineItems.toString());
					}
					if (itemType.equals("Gum")) {
						vendingMachineItems = new Gum(slotLocation, itemName, dbItemPrice, itemType);
						System.out.println(vendingMachineItems.toString());
					}
					if (itemType.equals("Drink")) {
						vendingMachineItems = new Beverages(slotLocation, itemName, dbItemPrice, itemType);
						System.out.println(vendingMachineItems.toString());
					}
                    //System.out.println(vendingMachineItems.toString());
                }
            }


        } catch (Exception ex) {
            System.out.println(ex);
        }

	}
}
