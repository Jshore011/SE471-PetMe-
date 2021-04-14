
public class FileReport extends Decision
{

    public FileReport(Manager suggestedBy, int priority, Hazard hazard) {
        super(suggestedBy, priority, hazard);
    }

    public void execute(CEO commander)
    {
        commander.report();
    }
}
