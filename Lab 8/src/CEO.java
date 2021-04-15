import java.util.ArrayList;
import java.util.*;

public class CEO extends Administrator {

	//ctr
	public CEO(String name, List<Employee> members) {
		super(name, members);
	}

	@Override
	public void seeDanger(HReporter_IF r, Hazard h) {
		List<Decision> ds = new ArrayList<>();

		// collect suggested decisions from managers
		System.out.println("Collecting decisions from managers...");
		for (HReporter_IF member : getMembers()) {
			Manager manager = (Manager)member;
			ds.addAll(manager.suggestDecisions(h));
		}

		// make final decisions here
		System.out.println("Making final decisions...");
		implementDecision(ds);
	}

	//implements decisions
	public void implementDecision(List<Decision> ds) {
		// sort the decisions based on priority level
		ds = sortByPriority(ds);

		// implement the top 2 decisions only
		for (int i = 0; i < 2; i++) {
			System.out.println("\nDecision " + i + ":");
			ds.get(i).execute(this);
		}
	}

	//method that sorts decisions by priority level
	private List<Decision> sortByPriority(List<Decision> ds) {
		List<Decision> temp = new ArrayList<>();

		while (!ds.isEmpty()) {
			int index = 0;
			int priority = -1;
			for (int i = 0; i < ds.size(); i++) {
				if (ds.get(i).getPriority() > priority) {
					priority = ds.get(i).getPriority();
					index = i;
				}
			}
			temp.add(ds.get(index));
			ds.remove(index);
		}

		return temp;
	}

	//prints report made by CEO
	public void report() {
		System.out.println("The city’s environmental department is notified");
	}
}
