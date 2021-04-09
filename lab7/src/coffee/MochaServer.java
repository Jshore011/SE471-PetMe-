package coffee;

import condiments.*;

public abstract class MochaServer implements CoffeeServer_IF{
    private CoffeeOS_API program;
    private Coffee_IF coffee;
    //returns the name of the program
    public String getName()
    {
        return "Mocha";
    }

    //starts the Mocha program
    public void start()
    {
        //1. Indicate the machine as running and display the purchased type of coffee to LED.
        program.setPowerLED(1);
        program.setTypeLED(2);
       // 2. Grind coffee beans for 5 seconds.
        program.setGrindingTime(5);
      //  3. Heat up the water to 200 degree F and hold the temperature for 5 seconds.
      program.setTemperature(200);
      program.holdTemperature(5);
        //  4. Add cream and vanilla once.
        System.out.println("adding Cream...");
        System.out.println("adding Vanilla...");
      //  5. After 15 seconds, set the LED to indicate the machine is not running.
        program.wait(15);
        program.setPowerLED(0);
    }
    @Override
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
