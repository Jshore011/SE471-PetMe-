
public class FileReport extends Decision
{
    //ctr
    public FileReport(Manager suggestedBy, int priority, Hazard hazard) {
        super(suggestedBy, priority, hazard);
    }
    //ceo executes report
    public void execute(CEO commander)
    {
        commander.report();
    }
}
