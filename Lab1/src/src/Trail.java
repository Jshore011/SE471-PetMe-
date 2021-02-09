public class Trail extends Route{
    private String startPt;
    private String endPt;

    Trail(String start_point, String end_point)
    {
        startPt = start_point;
        endPt = end_point;
    }
    public String getStartPoint()
    {
        return startPt;
    }
    public String getEndPoint()
    {
        return endPt;
    }
}
