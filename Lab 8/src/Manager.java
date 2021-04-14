import java.util.ArrayList;

public class Manager extends Administrator {
	public ArrayList<Decision> ds= new ArrayList<>();
	
	public Manager() {
		super();
	}


	@Override
	public void seeDanger(HReporter_IF r, Hazard h) {
		Boolean reportToCEO = true;
		for (Employee e:members)
		{
			DirectAdministrator d = (DirectAdministrator)e;
			if(d.getFeedback() == false)
			{
				reportToCEO=false;
			}

		}
		if(reportToCEO && overseer!= null)
		{
			overseer.seeDanger(this, h);
		}
	}

	public Decision suggestDecisions(Hazard h) {
		return ds;
	}

}
