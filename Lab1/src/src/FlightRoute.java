public class FlightRoute extends Route{
    private String startPt;
    private String endPt;

    FlightRoute(String start_point, String end_point)
    {
        startPt = start_point;
        endPt = end_point;
    }
    public void setStartPoint(String point)
    {
        startPt = point;
    }
    public String getStartPoint()
    {
        return startPt;
    }
    public void setEndPoint(String point)
    {
        endPt = point;
    }
    public String getEndPoint()
    {
        return endPt;
    }
}
