import java.util.ArrayList;

public class Trip {
    private String from;
    private String destination;
    private float trip;
    public ArrayList<Schedule> schedule;

    Trip()
    {
        from = "";
        destination = "";
    }
    public ArrayList<Schedule> getSchedule()
    {
        return schedule;
    }
    public String getFrom()
    {
        return from;
    }

    public String getDestination()
    {
        return destination;
    }

    public void calculateTrip()
    {
        float trip;
    }

    public float displayTrip()
    {
        return trip;
    }
}
