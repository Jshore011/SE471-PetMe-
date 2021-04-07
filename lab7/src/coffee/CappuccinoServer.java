package coffee;

import condiments.CoffeeOS_API;
import condiments.Condiment_IF;

public class CappuccinoServer  {
    private CoffeeOS_API program;
    private Condiment_IF chocolate;

    //returns the name of the program
    public String getName()
    {
        return "Cappuccino";
    }

    //starts the cappuccino program
    public void start()
    {
        //1. Indicate the machine as running and display the purchased type of coffee to LED.
        program.setTypeLED(1);
        // 2. Grind coffee beans for 9 seconds.
        program.setGrindingTime(9);
        //  3. Heat up the water to 190 degree F and hold the temperature for 5 seconds.
        program.setTemperature(190);
        program.holdTemperature(5);
        //  4. Add chocolate twice.
        program.addCondiment(chocolate);
        program.addCondiment(chocolate);
        //  5. After 20 seconds, set the LED to indicate the machine is not running.
        program.wait(20);
        program.setPowerLED(0);

    }
}
