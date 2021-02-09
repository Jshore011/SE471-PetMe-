

public class Airplane extends Vehicle{
    private String type;
    private int numbSeats;
    private String make;
    private String model;
    private int year;


    Airplane(String type, String make, String model, int year)
    {
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;

    }

    public String getType(String type)
    {
        return type;
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
