
public class Employee {
	private String name;
	
	public void seeDanger(HReporter_IF r, Hazard h)
	{

	}

	public void evacuate() 
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
