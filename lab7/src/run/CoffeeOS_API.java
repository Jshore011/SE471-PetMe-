package run;

import coffee.CoffeeServer_IF;
import coffee.Coffee_IF;
import condiments.Condiment_IF;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface CoffeeOS_API {

    public void setCoffeeType(String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException;
    public void setGrindingTime(int secs);
    public void addCondiment(Condiment_IF type);
    public void setTemperature(int degree);
    public void holdTemperature(int seconds);
    public void wait(int seconds);
    public void setPowerLED(int num);
    public void setTypeLED(int num);
    public CoffeeServer_IF computePrice(CoffeeServer_IF cif);
    public Coffee_IF done();
}
