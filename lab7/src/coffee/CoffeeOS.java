package coffee;

import condiments.Condiment_IF;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeOS implements CoffeeOS_API {
    private CoffeeServer_IF orderedCoffee;
    //Condiment_IF cream = new Cream();
    //Condiment_IF vanilla = new Vanilla();
    //Condiment_IF chocolate = new Chocolate();
    private List<CoffeeServer_IF> transactions;
    public CoffeeOS(){

        transactions = new ArrayList<>();
    }
    //run's the program
    public void run() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException, NoSuchMethodException, InvocationTargetException {

       String input = "";
       Scanner sc = new Scanner(System.in);
       System.out.println("What Kind of coffee Would you Like?\n");
       input = sc.nextLine();
       setCoffeeType(input);

   }

    @Override
    public void setCoffeeType(String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException {

        String compiledClassLocation = new File(".").getCanonicalPath();

        System.out.println(compiledClassLocation);
        URL[] classPath = {new File(compiledClassLocation).toURI().toURL()};
        ClassLoader cLoader = new URLClassLoader(classPath);



        Class c = null;
        switch (str) {
            case "Regular":
                c = cLoader.loadClass("coffee.RegularServer");
                break;
            case "Mocha":
                c = cLoader.loadClass("coffee.MochaServer");
                break;
            case "Latte":
                c = cLoader.loadClass("coffee.LatteServer");
                break;
            case "Espresso":
                c = cLoader.loadClass("coffee.EspressoServer");
                break;
            case "Cappuccino":
                c = cLoader.loadClass("coffee.CappuccinoServer");
                break;
        }

        assert c != null;

        orderedCoffee = (CoffeeServer_IF)c.getDeclaredConstructor().newInstance();
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
