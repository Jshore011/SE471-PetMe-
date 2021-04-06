package coffee;

import condiments.CoffeeOS_API;

public class Mocha {
    private CoffeeOS_API program;
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
       // 2. Grind coffee beans for 5 seconds.
      //  3. Heat up the water to 200 degree F and hold the temperature for 5 seconds.
      //  4. Add cream and vanilla once.
      //  5. After 15 seconds, set the LED to indicate the machine is not running.
    }
}
