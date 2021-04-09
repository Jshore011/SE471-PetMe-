package coffee;

import CoffeeMachine.CoffeeOS_API;
import condiments.*;

public class RegularServer implements CoffeeServer_IF {
    private CoffeeOS_API program;
    private Coffee_IF coffee;

    /*
     * Constructor
     */
    public RegularServer() {
        program = null;
        coffee = new Coffee("Regular");
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
        program.setTypeLED(1);                      // 1 represents a Regular coffee
        program.setGrindingTime(8);                 // time in seconds
        program.setTemperature(150);                // degrees F
        program.holdTemperature(2);         // time in seconds
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
