package CoffeeMachine;

import coffee.CoffeeServer_IF;
import coffee.Coffee_IF;
import condiments.Condiment_IF;

public interface CoffeeOS_API {
    public void setChosenCoffeeType(CoffeeServer_IF.CoffeeType type) throws ClassNotFoundException, IllegalAccessException, InstantiationException;

    public void setGrindingTime(int secs);

    public void addCondiment(Condiment_IF type);

    public void setTemperature(int degree);

    public void holdTemperature(int seconds);

    public void wait(int seconds);

    public void setPowerLED(int num);

    public void setTypeLED(int num);

    public double computePrice(Coffee_IF cif);

    public Coffee_IF done();
}

