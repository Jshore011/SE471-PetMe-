import java.util.ArrayList;
import java.util.List;

public class CEO extends Administrator{
	private String name;
	private ArrayList<Manager> managerList;
	private ArrayList<Decision> decisionList;
	
	public CEO(String name, ArrayList<Manager> managerList) {
		this.name = name;
		this.managerList = managerList;
		decisionList = new ArrayList<Decision>();
	}

	@Override
	public void seeDanger(HReporter_IF r, Hazard h)
	{
		for(int i =0;i<managerList.size();i++)
		{
			decisionList.add(managerList.get(i).suggestDecision(Hazard.GasLeak));
		}
		int evacualtionCount = 0;
		int fileReportCount = 0;
		for(int i =0;i<decisionList.size();i++) 
		{
			if(decisionList.get(i) == Decision.Evacuation) 
			{
				evacualtionCount++;
			}
			else if(decisionList.get(i) == Decision.FileReport) 
			{
		        fileReportCount++;
			}
		}
		
		if(evacualtionCount > fileReportCount)
		{
			evacuate();
		}
		else 
		{
			fileReport();
		}
	}

	@Override
	public void evacuate()
	{
		for(int i =0;i<managerList.size();i++) 
		{
			managerList.get(i).evacuate();
		}
		System.out.println("The employee "+name+" is evacuating.");
	}
	
	public void implementDecision(List<Decision> ds){

	}

	private List<Decision> sortByPriority(List<Decision> ds){
		return ds; //need to do...
	}

	public void report(){

	}
}
