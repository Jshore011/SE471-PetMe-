
public class FileReport extends Decision
{

    public FileReport(Manager suggestedBy, int priority, Hazard hazard) {
        super(suggestedBy, priority, hazard);
    }

    public void execute(CEO commander)
    {
        System.out.println("The city's environmental department is notified.");
    }
}
