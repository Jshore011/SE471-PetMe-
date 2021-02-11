

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

    public void setType(String type) {
        this.type = type;
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

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
