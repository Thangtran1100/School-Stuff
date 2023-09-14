package model;


public class VaccineEntry {

    static int idSeed = 1;

    private int id;

    private String vaccine;
    
    private String doseRequired;
    
    private String daysBetweenDose;
    
    private String totalDoseReceived;
    
    private String totalDoseLeft;

    public VaccineEntry( String vaccine, String doseRequired, String daysBetweenDose, String totalDoseReceived, String totalDoseLeft)
    {
        this.id = idSeed++;
        this.vaccine = vaccine;
        this.doseRequired = doseRequired;
        this.daysBetweenDose = daysBetweenDose;
        this.totalDoseReceived = totalDoseReceived;
        this.totalDoseLeft = totalDoseLeft;
    }


	public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }
    
    public String getVaccine() {
		return vaccine;
	}

	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}

	public String getDoseRequired() {
		return doseRequired;
	}

	public void setDoseRequired(String doseRequired) {
		this.doseRequired = doseRequired;
	}

	public String getDaysBetweenDose() {
		return daysBetweenDose;
	}

	public void setDaysBetweenDose(String daysBetweenDose) {
		this.daysBetweenDose = daysBetweenDose;
	}

	public String getTotalDoseReceived() {
		return totalDoseReceived;
	}

	public void setTotalDoseReceived(String totalDoseReceived) {
		this.totalDoseReceived = totalDoseReceived;
	}

	public String getTotalDoseLeft() {
		return totalDoseLeft;
	}

	public void setTotalDoseLeft(String totalDoseLeft) {
		this.totalDoseLeft = totalDoseLeft;
	}
}

