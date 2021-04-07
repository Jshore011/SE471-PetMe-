package condiments;

import coffee.CoffeeServer_IF;

public interface CoffeeOS_API {

    public void setCoffeeType(String str);
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
