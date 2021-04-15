import java.util.ArrayList;
import java.util.List;

public class Manager extends Administrator {
	private static boolean suggestedFileReport = false;

	//ctr
	public Manager(String name, List<Employee> members) {
		super(name, members);
	}
	//method to determine whether or not to report to CEO
	@Override
	public void seeDanger(HReporter_IF r, Hazard h) {
		boolean reportToCEO = true;

		// Manager asks for feedback from all supervisors/leader under their management
		// and contacts the CEO if all feedbacks are positive (true)
		System.out.println("Asking for feedback from all supervisors/leaders...");
		for (HReporter_IF member : getMembers()) {
			DirectAdministrator directAdministrator = (DirectAdministrator) member;
			if (!directAdministrator.getFeedback(h))
				reportToCEO = false;
		}

		// contact the CEO if all feedbacks are positive (true)
		if (reportToCEO && getDirectOverseer() != null) {
			System.out.println("Notifying CEO...\n");
			getDirectOverseer().seeDanger(this, h);
		}

	}
	//returns the suggested decisions
	public List<Decision> suggestDecisions(Hazard h) {
		List<Decision> ds = new ArrayList<>();
		int hazard_level = h.getHazard_level();

		if (!suggestedFileReport) {
			ds.add(new FileReport(this, 5, h));
			suggestedFileReport = true;
		}
		else {
			if (hazard_level >= 10) {
				ds.add(new Evacuation(this, 10, h));
			} else if (hazard_level >= 1) {
				ds.add(new FileReport(this, 5, h));
			}
		}

		return ds;
	}

}
