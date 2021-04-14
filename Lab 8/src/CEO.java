import java.util.ArrayList;
import java.util.List;

public class CEO extends Administrator {


	public CEO(ArrayList<Decision> ds) {
	}

	public void implementDecision(ArrayList<Decision> ds) {
		//implement the first two decisions after sorting the list be priority

	}

	private ArrayList<Decision> sortByPriority(ArrayList<Decision> ds) {
		//need to add a sorting algo
		return ds;
	}

	public void report() {
	}

	@Override
	public void seeDanger(HReporter_IF r, Hazard h) {
		ArrayList<Decision> decisions = new ArrayList<>();
		for (Employee e : members) {
			Manager m = (Manager) e;
			decisions.add(m.suggestDecisions(h));
		}
		implementDecision(decisions);
	}
}
