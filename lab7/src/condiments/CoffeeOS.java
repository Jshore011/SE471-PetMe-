package condiments;

import coffee.CoffeeServer_IF;

import java.net.URLClassLoader;

public class CoffeeOS implements CoffeeOS_API{
    private CoffeeServer_IF orderedCoffee;

    //run's the program
    public void run(String programName)
    {
        URLClassLoader classLoader;
    }

    @Override
    public void setCoffeeType(String str)
    {
        System.out.println("Thank you for ordering %s"+str);
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
        System.out.println("Power LED set to %d" + num);

    }
    @Override
    public void setTypeLED(int num)
    {
        System.out.println("Type LED is %d"+num);
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
