package CoffeeMachine;

import coffee.*;
import condiments.*;

public class CoffeeOS implements CoffeeOS_API {
    private CoffeeServer_IF current;
    private char[] LED;

    public CoffeeOS() {
        current = null;
        LED = new char[]{'1', '0'};
    }

    @Override
    public void setChosenCoffeeType(CoffeeServer_IF.CoffeeType type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //String compiledClassLocation = new File(".").getCanonicalPath();
        //System.out.println(compiledClassLocation);
        //URL[] classPath = { new File(compiledClassLocation).toURI().toURL() };
        //ClassLoader cLoader = new URLClassLoader(classPath);

        // Another way of using classloader
        ClassLoader cLoader = this.getClass().getClassLoader();

        // determine which type of coffee server to use
        Class c = null;
        switch (type) {
            case Regular:
                c = cLoader.loadClass("coffee.RegularServer");
                break;
            case Mocha:
                c = cLoader.loadClass("coffee.MochaServer");
                break;
            case Latte:
                c = cLoader.loadClass("coffee.LatteServer");
                break;
            case Espresso:
                c = cLoader.loadClass("coffee.EspressoServer");
                break;
            case Cappuccino:
                c = cLoader.loadClass("coffee.CappuccinoServer");
                break;
        }

        // set the coffee server's environment and start its program
        assert c != null;
        current = (CoffeeServer_IF)c.newInstance();
        current.setEnvironment(this);
        current.start();
    }

    /*
     * Simulates the grinding time
     */
    @Override
    public void setGrindingTime(int secs) {
        System.out.println("Grinding coffee beans for " + secs + " seconds...");
    }

    /*
     * Requests the coffee server to add a condiment to the coffee its making
     */
    @Override
    public void addCondiment(Condiment_IF type) {
        current.addCondiment(type);
    }

    /*
     * Simulates the temperature
     */
    @Override
    public void setTemperature(int degree) {
        System.out.println("Setting temperature to " + degree + "F degrees...");
    }

    /*
     * Simulates the hold time
     */
    @Override
    public void holdTemperature(int seconds) {
        System.out.println("Holding temperature for " + seconds + " seconds...");
    }

    /*
     * Simulates the waiting time
     */
    @Override
    public void wait(int seconds) {
        System.out.println("Waiting for " + seconds + " seconds...");
    }

    /*
     * Sets the power LED to either 0-on or 1-off
     */
    @Override
    public void setPowerLED(int num) {
        if (num == 0) {
            LED[0] = '0'; // Running
        } else if (num == 1) {
            LED[0] = '1'; // Not Running
        }

        System.out.println("LED: " + new String(LED));
    }

    /*
     * Sets the coffee LED to 1-5 for the selected coffee
     */
    @Override
    public void setTypeLED(int num) {
        if (num == 1) {
            LED[1] = '1'; // Regular
        } else if (num == 2) {
            LED[1] = '2'; // Mocha
        } else if (num == 3) {
            LED[1] = '3'; // Latte
        } else if (num == 4) {
            LED[1] = '4'; // Espresso
        } else if (num == 5) {
            LED[1] = '5'; // Cappuccino
        }

        System.out.println("LED: " + new String(LED));
    }

    /*
     * Computes the final sale price for the coffee
     */
    @Override
    public double computePrice(Coffee_IF cif) {
        double coffeeBasePrice = 0.00;
        if (current instanceof RegularServer)
            coffeeBasePrice = 1.00;
        else if (current instanceof MochaServer)
            coffeeBasePrice = 2.00;
        else if (current instanceof LatteServer)
            coffeeBasePrice = 3.00;
        else if (current instanceof EspressoServer)
            coffeeBasePrice = 4.00;
        else if (current instanceof CappuccinoServer)
            coffeeBasePrice = 5.00;

        return cif.getPrice() + coffeeBasePrice;
    }

    /*
     * Returns the finished CoffeeIF object
     */
    @Override
    public Coffee_IF done() {
        return current.getCoffee();
    }

    /*
     * Returns the current CoffeeServerIF object
     */
    public CoffeeServer_IF getCurrentCoffeeServer() {
        return current;
    }

}
