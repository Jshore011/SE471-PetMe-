package coffee;

import CoffeeMachine.CoffeeOS_API;
import condiments.*;

public class MochaServer implements CoffeeServer_IF {
    private CoffeeOS_API program;
    private Coffee_IF coffee;

    /*
     * Constructor
     */
    public MochaServer() {
        program = null;
        coffee = new Coffee("Mocha");
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
        program.setTypeLED(2);                      // 2 represents a Mocha coffee
        program.setGrindingTime(5);                 // time in seconds
        program.setTemperature(200);                // degrees F
        program.holdTemperature(5);         // time in seconds
        System.out.println("Adding Cream...");  // add condiment
        System.out.println("Adding Vanilla...");// add condiment
        program.wait(15);                   // time in seconds
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
