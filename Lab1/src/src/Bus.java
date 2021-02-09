
public class Bus extends Vehicle {
    private String VIN;
    private String plateNO;
    private String make;
    private String model;
    private int year;
    private int numbSeats;

    Bus(String VIN, String plateNO, String make, String model, int year)
    {
        this.VIN = VIN;
        this.plateNO = plateNO;
        this.make = make;
        this.model = model;
        this.year = year;
    }
    public String getVIN()
    {
        return VIN;
    }

    public String getPlateNO()
    {
        return plateNO;
    }
    public boolean getSeatsAvailible()
    {
        return seatsAvailible;
    }
    public int displayNumSeatsAvailible()
    {
        return numbSeats;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public int getYear()
    {
        return year;
    }
}
