
public abstract class Employee {
	private String name;
	private Administrator overseer;

	public Employee(String name, Administrator overseer)
	{
		this.name=name;
		this.overseer=overseer;
	}
	public abstract seeDanger(HReporter_IF r, Hazard h)
	{
		r.seeDanger(r.getDirectOverseer(), h);
	}

	public abstract evacuate()
	{
		System.out.println("The employee "+ name + "is evacuating.");
	}


	// Getter
	public String getDirectOverseer() {
		return name;
	}

	// Setter
	public void setDirectOverseer(String newName) {
		this.name = newName;
	}
}
