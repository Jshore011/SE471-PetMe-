
public class Bus extends Vehicle {
    private String VIN;
    private String plateNO;
    private String make;
    private String model;
    private int year;
    private int numbSeats = 100;

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

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getPlateNO()
    {
        return plateNO;
    }

    public void setPlateNO(String plateNO) {
        this.plateNO = plateNO;
    }

    public boolean getSeatsAvailible()
    {
        return seatsAvailible;
    }


    public void setNumbSeats(int numbSeats) {
        this.numbSeats = numbSeats;
    }

    public int displayNumSeatsAvailible()
    {
        return numbSeats;
    }

    public String getMake()
    {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }
    public void setModel(String model)
    {
        this.model=model;
    }

    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year = year;
    }
}
