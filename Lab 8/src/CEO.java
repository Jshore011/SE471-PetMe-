import java.util.ArrayList;

public class CEO extends Administrator{

	
	public CEO(ArrayList<Decision>ds) {
	}

	public void implementDecision(ArrayList<Decision> ds)
	{
		//implement the first two decisions after sorting the list be priority

	}

	private ArrayList<Decision> sortByPriority(ArrayList<Decision> ds)
	{
		//need to add a sorting algo
		return ds;
	}

	public void report(){}

	@Override
	public void seeDanger(HReporter_IF r, Hazard h) {

	}
}
