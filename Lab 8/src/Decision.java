
public abstract class Decision {
	private Manager suggestedBy;
	private int priority;
	private Hazard hazard;

	public Decision(Manager suggestedBy, int priority, Hazard hazard)
	{
		this.suggestedBy=suggestedBy;
		this.priority=priority;
		this.hazard=hazard;
	}

	public abstract void execute(CEO commander);
}
