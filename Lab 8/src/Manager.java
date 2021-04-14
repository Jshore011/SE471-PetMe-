import java.util.ArrayList;

public class Manager extends Administrator {
	public ArrayList<Decision> ds= new ArrayList<>();
	
	public Manager() {
		super();
	}

	@Override
	public void seeDanger(HReporter_IF r, Hazard h) {

	}

	public ArrayList<Decision> suggestDecisions(Hazard h) {
	return ds;
	}
}
