package coffee;

import condiments.CoffeeOS_API;

public class RegularServer {
    private CoffeeOS_API program;
    //returns the name of the program
    public String getName()
    {
        return "Regular Coffee";
    }

    //starts the Regular Coffee program
    public void start()
    {
        //1. Indicate the machine as running and display the purchased type of coffee to LED.
        program.setTypeLED(1);
        // 2. Grind coffee beans for 8 seconds.
        program.setGrindingTime(8);
        // 3. Heat up the water to 150 degree F and hold the temperature for 2 seconds.
        program.setTemperature(150);
        program.holdTemperature(2);
        // 4. After 15 seconds, set the LED to indicate the machine is not running.
        program.wait(15);
        program.setPowerLED(0);
    }
}
