
public class Evacuation extends Decision{

    public Evacuation(Manager suggestedBy, int priority, Hazard hazard) {
        super(suggestedBy, priority, hazard);
    }

    public void execute(CEO commander)
    {
        commander.evacuate();
    }
}
