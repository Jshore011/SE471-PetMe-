package condiments;

import coffee.CoffeeServer_IF;

import java.net.URLClassLoader;

public class CoffeeOS implements CoffeeOS_API{
    private CoffeeServer_IF orderedCoffee;
    Condiment_IF cream = new Cream();
    Condiment_IF vanilla = new Vanilla();
    Condiment_IF chocolate = new Chocolate();

    //run's the program
    //public void run(String programName)
   // {
    //    URLClassLoader classLoader;
   // }

    @Override
    public void setCoffeeType(String str)throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader cLoader = this.getClass().getClassLoader();

        Class c = null;
        switch (str) {
            case "Regular":
                c = cLoader.loadClass("CoffeeMaker.Coffee.RegularServer");
                break;
            case "Mocha":
                c = cLoader.loadClass("CoffeeMaker.Coffee.MochaServer");
                break;
            case "Latte":
                c = cLoader.loadClass("CoffeeMaker.Coffee.LatteServer");
                break;
            case "Espresso":
                c = cLoader.loadClass("CoffeeMaker.Coffee.EspressoServer");
                break;
            case "Cappuccino":
                c = cLoader.loadClass("CoffeeMaker.Coffee.CappuccinoServer");
                break;
        }

        assert c != null;
        orderedCoffee = (CoffeeServer_IF) c.newInstance();
        orderedCoffee.setProgram(this);
        orderedCoffee.start();
    }

    @Override
    public void setGrindingTime(int secs)
    {
        System.out.println("Grinding for %d seconds"+ secs);
    }
    @Override
    public Condiment_IF addCondiment(Condiment_IF type)
    {
        return type;
        // TODO: 4/4/2021
    }
    @Override
    public void setTemperature(int degree)
    {
        System.out.println("Brewing at %d 's"+degree);
    }
    @Override
    public int holdTemperature(int seconds)
    {
        System.out.println("Holding Temperature for %d seconds" + seconds);
        return seconds;
    }
    @Override
    public int wait(int seconds)
    {
       System.out.println("Watiing for %d seconds..." + seconds);
       return seconds;
    }
    @Override
    public void setPowerLED(int num)
    {
        switch(num)
        {
            case 0: System.out.println("Power LED set to OFF");
                break;
            case 1: System.out.println("Power LED set to ON");
                break;
            default: break;
        }


    }
    @Override
    public void setTypeLED(int num)
    {
        switch(num)
        {
            case 1: System.out.println("Running Regular Program");
                break;
            case 2: System.out.println("Running Mocha Program");
                break;
            case 3: System.out.println("Running Latte Program");
                break;
            case 4: System.out.println("Running Espresso Program");
                break;
            case 5: System.out.println("Running Cappuccino Program");
                break;
            default: break;
        }
    }
    @Override
    public CoffeeServer_IF computePrice(CoffeeServer_IF cif)
    {
        return cif;
        // TODO: 4/4/2021
    }
    @Override
    public void done()
    {
        System.out.println("Enjoy your Finished Coffee!");
    }
}
