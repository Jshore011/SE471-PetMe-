package coffee;
import condiments.Chocolate;
import condiments.Cream;
import condiments.Condiment_IF;
import condiments.Vanilla;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeOS implements CoffeeOS_API {
    private CoffeeServer_IF current;
    private CoffeeOS coffeeOS;

    public CoffeeOS(){
        current = null;

        List<CoffeeServer_IF> transactions = new ArrayList<>();
    }
    //run's the program
    public void run() throws IllegalAccessException, InstantiationException, ClassNotFoundException{

       String input = "";
       Scanner sc = new Scanner(System.in);
       System.out.println("What Kind of coffee Would you Like?\n");
        System.out.println("Coffee Menu");
        System.out.println("-----------");
        System.out.println("[1] Regular");
        System.out.println("[2] Mocha");
        System.out.println("[3] Latte");
        System.out.println("[4] Espresso");
        System.out.println("[5] Cappuccino");
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Enter selection: ");
        int selection = sc2.nextInt();
        System.out.println();

        switch (selection) {
            case 1 -> coffeeOS.setCoffeeType(CoffeeServer_IF.CoffeeType.Regular);
            case 2 -> coffeeOS.setCoffeeType(CoffeeServer_IF.CoffeeType.Mocha);
            case 3 -> coffeeOS.setCoffeeType(CoffeeServer_IF.CoffeeType.Latte);
            case 4 -> coffeeOS.setCoffeeType(CoffeeServer_IF.CoffeeType.Espresso);
            case 5 -> coffeeOS.setCoffeeType(CoffeeServer_IF.CoffeeType.Cappuccino);
        }
       System.out.println("What Kind of coffee Would you Like?\n");
       input = sc.nextLine();


   }

    public void setCoffeeType(CoffeeServer_IF.CoffeeType type) throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        ClassLoader cLoader = this.getClass().getClassLoader();

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
        current = (CoffeeServer_IF) c.newInstance();
        current.setProgram(this);
        current.start();
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
    private void addCondiments() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nAdd more condiments? [Y/N]: ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            System.out.println("Condiments");
            System.out.println("----------");
            System.out.println("[1] Cream");
            System.out.println("[2] Vanilla");
            System.out.println("[3] Chocolate");

            System.out.print("Enter selection: ");
            int selection = sc.nextInt();

            switch (selection) {
                case 1 -> coffeeOS.addCondiment(new Cream());
                case 2 -> coffeeOS.addCondiment(new Vanilla());
                case 3 -> coffeeOS.addCondiment(new Chocolate());
            }

            // let user add more condiments if desired
            addCondiments();
        }
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
