
public abstract class Employee {
	private String name;
	private HReporter_IF overseer;

	public Employee(String name)
	{
		this.name=name;

	}
	public abstract seeDanger(HReporter_IF r, Hazard h)
	{
		r.getDirectOverseer();

	}

	public abstract evacuate()
	{
		System.out.println("The employee "+ name + "is evacuating.");
	}


	public HReporter_IF getDirectOverseer() {
		return overseer;
	}


	public HReporter_IF setDirectOverseer(HReporter_IF overseer) {
		return this.overseer;
	}
}
