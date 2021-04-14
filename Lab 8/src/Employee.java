
public abstract class Employee {
	private String name;
	private HReporter_IF directOverseer;
	private Administrator overseer;
	public Employee(String name)
	{
		this.name=name;

	}

	public Employee() {

	}

	abstract void seeDanger(HReporter_IF r, Hazard h);

	abstract void evacuate();


	public HReporter_IF getDirectOverseer() {
		return directOverseer;
	}


	public HReporter_IF setDirectOverseer(HReporter_IF  directOverseer) {
		return this.directOverseer;
	}
}
