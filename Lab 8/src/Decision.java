
public abstract class Decision {
	private Manager suggestedBy;
	private int priority;
	private Hazard hazard;
	//ctr
	public Decision(Manager suggestedBy, int priority, Hazard hazard)
	{
		this.suggestedBy=suggestedBy;
		this.priority=priority;
		this.hazard=hazard;
	}
	//getter for suggestions by manager
	public Manager getSuggestedBy() {
		return suggestedBy;
	}
	//get's the priority of the hazard
	public int getPriority() {
		return priority;
	}
	//getter for the hazard
	public Hazard getHazard() {
		return hazard;
	}
//abstract method
	public abstract void execute(CEO commander);
}
