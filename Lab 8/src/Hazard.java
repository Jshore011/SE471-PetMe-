public class Hazard {
	private String type;
	private String desp;
	private int hazard_level;

	//ctr
	public Hazard(String type, String desp, int hazard_level) {
		this.type = type;
		this.desp = desp;
		this.hazard_level = hazard_level;
	}

	//getter for hazard type
	public String getType() {
		return type;
	}

	//getter for description of hazard
	public String getDesp() {
		return desp;
	}

	//getter for hazard level
	public int getHazard_level() {
		return hazard_level;
	}

}
