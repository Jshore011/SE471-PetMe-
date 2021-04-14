
public abstract class Employee implements HReporter_IF{
	private String name;
	//private HReporter_IF overseer;
	private Administrator overseer;

	public Employee(String name)
	{
		this.name=name;
	}

	public Employee() {
	}

	public abstract void seeDanger(HReporter_IF r, Hazard h);

	public abstract void evacuate();

	public HReporter_IF getDirectOverseer() {
		return overseer;
	}


	public void setDirectOverseer(HReporter_IF overseer) {
		setDirectOverseer(overseer);
	}
}
