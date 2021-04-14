import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class CEO extends Administrator {


	public CEO(ArrayList<Decision> ds) {
	}

	public void implementDecision(ArrayList<Decision> ds) {
		ds =sortByPriority(ds);
		Decision d =ds.get(0);
		d.execute(this);

		d = ds.get(1);
		d.execute(this);

	}

	private ArrayList<Decision> sortByPriority(ArrayList<Decision> ds) {
		//need to add a sorting algo
		Collections.sort(ds); //not sure about this
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
