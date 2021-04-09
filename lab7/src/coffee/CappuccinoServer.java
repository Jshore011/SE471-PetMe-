package coffee;

import coffee.*;
import CoffeeMachine.CoffeeOS_API;
import condiments.*;

public class CappuccinoServer implements CoffeeServer_IF {
    private CoffeeOS_API program;
    private Coffee_IF coffee;

    public CappuccinoServer() {
        program = null;
        coffee = new Coffee("Cappuccino");
    }

    @Override
    public void setEnvironment(CoffeeOS_API program) {
        this.program = program;
    }

    @Override
    public void start() {
        // Indicate the machine is running and display the purchased type of coffee to LED
        program.setPowerLED(0);                     // indicate machine is on
        program.setTypeLED(5);                      // 5 represents a Cappuccino coffee
        program.setGrindingTime(15);                // time in seconds
        program.setTemperature(199);                // degrees F
        program.holdTemperature(5);         // time in seconds
        System.out.println("Adding Chocolate...");  // add condiment
        program.wait(20);                   // time in seconds
        program.setPowerLED(1);                     // indicate machine is no longer running
    }

    public void addCondiment(Condiment_IF condiment) {
        System.out.println("Adding " + condiment.getType() + "...");

        if (condiment instanceof Cream) {
            coffee = new CoffeeWithCream(coffee, condiment);
        } else if (condiment instanceof Vanilla) {
            coffee = new CoffeeWithVanilla(coffee, condiment);
        } else if (condiment instanceof Chocolate) {
            coffee = new CoffeeWithChocolate(coffee, condiment);
        }
    }

    @Override
    public Coffee_IF getCoffee() {
        return coffee;
    }
}
