package CoffeeMachine;

import coffee.*;
import condiments.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Brewing {
    private CoffeeOS coffeeOS;
    private ArrayList<Coffee_IF> salesrecord;
    private ArrayList<Double> pricerecord;

    /*
     * Constructor
     */
    public Brewing() {
        coffeeOS = new CoffeeOS();
        salesrecord = new ArrayList<>();
        pricerecord = new ArrayList<>();
    }

    public void run() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        displayMenu();
        begin();
        selectCondiments();
        showTotalPrice();
    }

    /*
     * Displays the coffee machine's menu
     */
    private void displayMenu() {
        System.out.println("Coffee Menu");
        System.out.println("-----------");
        System.out.println("[1] Regular");
        System.out.println("[2] Mocha");
        System.out.println("[3] Latte");
        System.out.println("[4] Espresso");
        System.out.println("[5] Cappuccino");
    }

    /*
     * Takes in user input and sets the chosen coffee type
     */
    private void begin() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter selection: ");
        int selection = sc.nextInt();
        System.out.println();

        switch (selection) {
            case 1 -> coffeeOS.setChosenCoffeeType(CoffeeServer_IF.CoffeeType.Regular);
            case 2 -> coffeeOS.setChosenCoffeeType(CoffeeServer_IF.CoffeeType.Mocha);
            case 3 -> coffeeOS.setChosenCoffeeType(CoffeeServer_IF.CoffeeType.Latte);
            case 4 -> coffeeOS.setChosenCoffeeType(CoffeeServer_IF.CoffeeType.Espresso);
            case 5 -> coffeeOS.setChosenCoffeeType(CoffeeServer_IF.CoffeeType.Cappuccino);
        }
    }

    /*
     * Takes in user input regarding the addition of condiments to their coffee
     */
    private void selectCondiments() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nAdd more condiments? [Y/N]: ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            System.out.println("Condiments");
            System.out.println("----------");
            System.out.println("[1] Cream");
            System.out.println("[2] Vanilla");
            System.out.println("[3] Chocolate");

            System.out.print("Enter selection: ");
            int selection = sc.nextInt();

            switch (selection) {
                case 1 -> coffeeOS.addCondiment(new Cream());
                case 2 -> coffeeOS.addCondiment(new Vanilla());
                case 3 -> coffeeOS.addCondiment(new Chocolate());
            }

            // let user add more condiments if desired
            selectCondiments();
        }
    }

    /*
     * Displays the user's final coffee price
     */
    private void showTotalPrice() {
        // show the total price (coffee + condiments)
        System.out.println("\nThank you for your purchase!");
        double price = coffeeOS.computePrice(coffeeOS.getCurrentCoffeeServer().getCoffee());
        System.out.println("Total: $" + String.format("%.2f", price) + "\n");

        salesrecord.add(coffeeOS.done()); // call coffeeOS.done() to add the CoffeeIF to the salesrecord
        pricerecord.add(price); // add the price for this coffee in a separate list to access later
    }

    /*
     * Displays the coffee machine's total sales record
     */
    public void displaySalesrecord() {
        System.out.println("\nSales Record");
        System.out.println("------------");


        // display each sale made
        for (int i = 0; i < salesrecord.size(); i++) {

            System.out.println("Sale " + i + ": "
                    + salesrecord.get(i).getType()
                    + " - $"
                    + String.format("%.2f", pricerecord.get(i)));
        }
    }

}

