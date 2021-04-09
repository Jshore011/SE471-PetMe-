package coffee;

import CoffeeMachine.CoffeeOS_API;
import condiments.*;

public class LatteServer implements CoffeeServer_IF {
    private CoffeeOS_API program;
    private Coffee_IF coffee;

    /*
     * Constructor
     */
    public LatteServer() {
        program = null;
        coffee = new Coffee("Latte");
    }

    /*
     * Sets the environment (CoffeeOS)
     */
    @Override
    public void setEnvironment(CoffeeOS_API program) {
        this.program = program;
    }

    /*
     * Starts the server's program (makes the coffee)
     */
    @Override
    public void start() {
        // Indicate the machine is running and display the purchased type of coffee to LED
        program.setPowerLED(0);                     // indicate machine is on
        program.setTypeLED(3);                      // 3 represents a Latte coffee
        program.setGrindingTime(14);                // time in seconds
        program.setTemperature(185);                // degrees F
        program.holdTemperature(3);         // time in seconds
        System.out.println("Adding Cream...");  // add condiment
        program.wait(20);                   // time in seconds
        program.setPowerLED(1);                     // indicate machine is no longer running
    }

    /*
     * Adds the desired condiment to the current coffee (make a new decorated object)
     */

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

    /*
     * Returns the coffee being produced by the server
     */
    @Override
    public Coffee_IF getCoffee() {
        return coffee;
    }
}
