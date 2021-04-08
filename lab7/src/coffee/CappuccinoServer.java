package coffee;

import condiments.Condiment_IF;

public class CappuccinoServer  implements CoffeeServer_IF{
    private CoffeeOS_API program;
    private Coffee_IF coffee;

    public CappuccinoServer() {
        program = null;
        coffee = new Coffee("Cappuccino");
    }

    //starts the cappuccino program
    public void start()
    {
        //1. Indicate the machine as running and display the purchased type of coffee to LED.
        program.setPowerLED(1);
        program.setTypeLED(5);
        // 2. Grind coffee beans for 9 seconds.
        program.setGrindingTime(9);
        //  3. Heat up the water to 190 degree F and hold the temperature for 5 seconds.
        program.setTemperature(190);
        program.holdTemperature(5);
        //  4. Add chocolate twice.
        System.out.println("Adding Chocolate...");
        //  5. After 20 seconds, set the LED to indicate the machine is not running.
        program.wait(20);
        program.setPowerLED(0);

    }

    public void addCondiment(Condiment_IF condiment) {
        System.out.println("Adding " + condiment.getType() + "...");

        if (condiment instanceof Cream) {
            coffee = new Coffee_With_Cream(coffee, condiment);
        } else if (condiment instanceof Vanilla) {
            coffee = new Coffee_With_Vanilla(coffee, condiment);
        } else if (condiment instanceof Chocolate) {
            coffee = new Coffee_With_Chocolate(coffee, condiment);
        }
    }

    @Override
    public Coffee_IF getCoffee() {
        return coffee;
    }
}
