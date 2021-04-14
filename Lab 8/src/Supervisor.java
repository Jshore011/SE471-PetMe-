import java.util.ArrayList;


public class Supervisor  {

public class Supervisor extends DirectAdministrator{

	private String name;
	private ArrayList<Supervisor> employeesList;
	private Manager manager;
	
	public Supervisor(String name, ArrayList<Supervisor> employeesList, Manager manager) {
		this.manager = manager;
		this.name = name;
		this.employeesList = employeesList;
	}
	
	public void seeDanger(HReporter_IF r, Hazard h)
	{
		manager.seeDanger(r, h);
		fixIt();
	}
	
	public void fixIt() 
	{
		System.out.println("The employee "+name+" is fixing it.");
		for(int i =0;i<employeesList.size();i++) 
		{
			employeesList.get(i).fixIt();
		}
	}

	public boolean getFeedback()
	{
		System.out.println("Feedback by "+name);
		return false;
	}
	
	public void evacuate() 
	{
		System.out.println("The employee "+name+" is evacuating.");
	}
}
