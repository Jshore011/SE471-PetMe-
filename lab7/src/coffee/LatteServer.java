package coffee;

import condiments.*;
import run.CoffeeOS_API;

public abstract class LatteServer implements CoffeeServer_IF{
    private CoffeeOS_API program;
    private Coffee_IF coffee;
    //returns the name of the program
    public LatteServer() {
        program = null;
        coffee = new Coffee("Latte");
    }
    public void setEnvironment(CoffeeOS_API program) {
        this.program = program;
    }
    //starts the Latte program
    public void start()
    {
        //1. Indicate the machine as running and display the purchased type of coffee to LED.
       program.setPowerLED(1);
        program.setTypeLED(3);
        // 2. Grind coffee beans for 9 seconds.
        program.setGrindingTime(9);
        // 3. Heat up the water to 175 degree F and hold the temperature for 3 seconds.
        program.setTemperature(175);
        program.holdTemperature(3);
        // 4. After 10 seconds, set the LED to indicate the machine is not running.
        program.wait(10);
        program.setPowerLED(0);
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
    public Coffee_IF getCoffee() {
        return coffee;
    }
}
