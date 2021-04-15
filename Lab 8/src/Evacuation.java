public class Evacuation extends Decision {

    //ctr
    public Evacuation(Manager suggestedBy, int priority, Hazard hazard) {
        super(suggestedBy, priority, hazard);
    }
    //ceo commands evacuation
    @Override
    public void execute(CEO commander) {
        commander.evacuate();
    }

}
