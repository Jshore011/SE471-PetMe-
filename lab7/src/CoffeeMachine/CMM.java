package CoffeeMachine;

import java.util.Scanner;


public class CMM{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        // create a new instance of a CoffeeMachine
        Brewing coffeeMachine = new Brewing();

        // do this until the user decides to quit the program
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Make new coffee? [Y/N]: ");
            String selection = sc.nextLine();

            // if user enters "Y", take them to the coffee machine's menu
            // otherwise, end the program
            if (selection.equalsIgnoreCase("Y")) {
                coffeeMachine.run();
            } else {
                coffeeMachine.displaySalesrecord();
                System.exit(0);
            }
        }
    }
}

