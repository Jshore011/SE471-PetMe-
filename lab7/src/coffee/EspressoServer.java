package coffee;

import CoffeeMachine.*;
import condiments.*;

public class EspressoServer implements CoffeeServer_IF {
    private CoffeeOS_API program;
    private Coffee_IF coffee;

    /*
     * Constructor
     */
    public EspressoServer() {
        program = null;
        coffee = new Coffee("Espresso");
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
        program.setTypeLED(4);                      // 3 represents a Espresso coffee
        program.setGrindingTime(10);                // time in seconds
        program.setTemperature(190);                // degrees F
        program.holdTemperature(2);         // time in seconds
        System.out.println("Adding Cream...");  // add condiment
        System.out.println("Adding Vanilla...");// add condiment
        program.wait(30);                   // time in seconds
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
