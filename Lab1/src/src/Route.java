import java.util.ArrayList;

public class Route
{
    private String start_point;
    private String end_point;
    private float miles;
    private String displaymiles;
    public ArrayList<Schedule> schedule;

    Route()
    {
        start_point = " ";
        end_point = " ";
    }
    public void setSchedule(ArrayList<Schedule> sched)
    {
        schedule = sched;
    }
    public ArrayList<Schedule> getSchedule()
    {
        return schedule;
    }
    public float calculateMiles() {
        return miles;
    }

    public String displayMiles() {
        return displaymiles;
    }

}
