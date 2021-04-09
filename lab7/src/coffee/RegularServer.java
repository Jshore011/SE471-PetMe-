package coffee;

import condiments.*;
import run.CoffeeOS_API;
public abstract class RegularServer implements CoffeeServer_IF {
    private CoffeeOS_API program;
    private Coffee_IF coffee;

    public RegularServer(){
        program=null;
        coffee=new Coffee("Regular");
    }
public void setProgram(CoffeeOS_API program)
    {
        this.program=program;
    }

    //starts the Regular Coffee program
    public void start()
    {
        //1. Indicate the machine as running and display the purchased type of coffee to LED.
        program.setPowerLED(1);
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
            coffee = new CoffeeWithChocolate(coffee, condiment) {

            };
        }
    }
    public Coffee_IF getCoffee() {
        return coffee;
    }
}

