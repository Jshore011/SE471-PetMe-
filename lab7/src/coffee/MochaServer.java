package coffee;

import condiments.Condiment_IF;

public class MochaServer {
    private CoffeeOS_API program;
    private Condiment_IF cream;
    private Condiment_IF vanilla;
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
        program.addCondiment(cream);
        program.addCondiment(vanilla);
      //  5. After 15 seconds, set the LED to indicate the machine is not running.
        program.wait(15);
        program.setPowerLED(0);
    }
}
