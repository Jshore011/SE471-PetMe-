package coffee;

import condiments.CoffeeOS_API;

public class LatteServer {
    private CoffeeOS_API program;
    //returns the name of the program
    public String getName()
    {
        return "Latte";
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
}
