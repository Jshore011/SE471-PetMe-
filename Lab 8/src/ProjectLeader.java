

public class ProjectLeader extends DirectAdministrator{
	public boolean getFeedback()
	{
		System.out.println("Feedback by Project Leader");
		return true;
	}

	@Override
	public void seeDanger(HReporter_IF r, Hazard h) {

	}
}
