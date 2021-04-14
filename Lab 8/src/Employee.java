
public abstract class Employee implements HReporter_IF{
	String name;

	//private HReporter_IF overseer;
	Administrator overseer;


	public Employee(String name)
	{
		this.name=name;
	}

	public Employee() {

	}

	public abstract void seeDanger(HReporter_IF r, Hazard h);

	abstract void evacuate();



	public HReporter_IF getDirectOverseer() {
		return overseer;
	}

	public void setDirectOverseer(HReporter_IF  overseer) {
		this.overseer= (Administrator) overseer;

	}
}
