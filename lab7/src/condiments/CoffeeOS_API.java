package condiments;

import coffee.CoffeeServer_IF;

public interface CoffeeOS_API {


    public void setCoffeeType(String str)
    {
        System.out.println("Thank you for ordering %s"+str);
    }
    
    public void setGrindingTime(int secs)
    {
        System.out.println("Grinding for %d seconds"+ secs);
    }
    
    public CondimentIF addCondiment(CondimentIF type)
    {
        return type;
        // TODO: 4/4/2021  
    }
    
    public void setTemperature(int degree)
    {
        System.out.println("Brewing at %d 's"+degree);
    }
    
    public int holdTemperature(int seconds)
    {
        return seconds;
        // TODO: 4/4/2021  
    }
    
    public int wait(int seconds)
    {
        return seconds;
        // TODO: 4/4/2021  
    }
    
    public void setPowerLED(int num)
    {
        System.out.println("Power LED set to %d" + num);

    }
    
    public void setTypeLED(int num)
    {
        System.out.println("Type LED is %d"+num);
    }
    
    public CoffeeIF computePrice(CoffeeIF cif)
    {
        return cif;
        // TODO: 4/4/2021  
    }
    
    public void done()
    {
        // TODO: 4/4/2021  
    }
}
