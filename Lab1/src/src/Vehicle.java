import java.util.ArrayList;

public class Vehicle {
    private String make;
    private String model;
    private int year;
    public boolean seatsAvailible = true;
    public ArrayList<Schedule>vehicleSched;

    Vehicle()
    {

        make = " ";
        model = " ";
        year = 0;
    }

    public ArrayList<Schedule> getSchedule()
    {
        return vehicleSched;
    }

    public void setVehicleSched(ArrayList<Schedule> vehicleSched) {
        this.vehicleSched = vehicleSched;
    }
}
