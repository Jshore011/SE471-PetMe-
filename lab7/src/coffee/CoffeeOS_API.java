package coffee;

import coffee.CoffeeServer_IF;
import condiments.Condiment_IF;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

public interface CoffeeOS_API {

    public void setCoffeeType(CoffeeServer_IF.CoffeeType type) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException;
    public void setGrindingTime(int secs);
    public Condiment_IF addCondiment(Condiment_IF type);
    public void setTemperature(int degree);
    public int holdTemperature(int seconds);
    public int wait(int seconds);
    public void setPowerLED(int num);
    public void setTypeLED(int num);
    public CoffeeServer_IF computePrice(CoffeeServer_IF cif);
    public void done();
}
