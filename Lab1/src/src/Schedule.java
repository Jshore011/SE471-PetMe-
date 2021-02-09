public class Schedule {
    private String start_time;
    private String end_time;
    public Route route;
    public Trip trip;
    public Vehicle vehicle;

    Schedule()
    {
        start_time = "";
        end_time = "";
    }

    public void setRoute(Route newRoute)
    {
        route = newRoute;
    }

    public Route getRoute()
    {
        return route;
    }

    public void setTrip(Trip newTrip)
    {
        trip = newTrip;
    }

    public Trip getTrip()
    {
        return trip;
    }

    public void setVehicle(Vehicle newVehicle)
    {
        vehicle = newVehicle;
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }
}
