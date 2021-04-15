public abstract class Employee implements HReporter_IF {
	final String name;
	private Administrator overseer;

	//ctr
	public Employee(String name) {
		this.name = name;
	}

	// abstract methods
	@Override
	public abstract void seeDanger(HReporter_IF r, Hazard h);
	public abstract void evacuate();

	//getter for employee name
	public String getName() {
		return this.name;
	}

	//setter for direct overseer
	@Override
	public void setDirectOverseer(HReporter_IF overseer) {
		this.overseer = (Administrator)overseer;
	}

	//getter for direct overseer
	@Override
	public HReporter_IF getDirectOverseer() {
		return this.overseer;
	}

}
