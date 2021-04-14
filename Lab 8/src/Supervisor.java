

public class Supervisor extends DirectAdministrator{

	public boolean getFeedback()
	{
		System.out.println("Feedback by Supervisor");
		return true;
	}

	@Override
	public void seeDanger(HReporter_IF r, Hazard h) {

	}
}
