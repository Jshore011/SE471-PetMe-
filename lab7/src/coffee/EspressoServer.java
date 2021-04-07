package coffee;

import condiments.CoffeeOS_API;

public class EspressoServer {
    private CoffeeOS_API program;
    //returns the name of the program
    public String getName()
    {
        return "Espresso";
    }

    //starts the Espresso program
    public void start()
    {
        //1. Indicate the machine as running and display the purchased type of coffee to LED.
        program.setTypeLED(1);
        // 2. Grind coffee beans for 7 seconds.
        program.setGrindingTime(7);
        // 3. Heat up the water to 200 degree F and hold the temperature for 2 seconds.
        program.setTemperature(200);
        program.holdTemperature(2);
        // 4. After 10 seconds, set the LED to indicate the machine is not running.
        program.wait(10);
        program.setPowerLED(0);
    }
}
