
public class Evacuation extends Decision{

    public Evacuation(Manager suggestedBy, int priority, Hazard hazard) {
        super(suggestedBy, priority, hazard);
    }

    public void execute(CEO commander)
    {
        //demands all employees to evacuate

        //evacuation is initiated by ceo

        //evac starts with all workers first, then supervisors, managers, CEO

        //when a person's evacuate() method is called it displays
    }
}
