package homework3.model;


public class VaccineEntry {

    static int idSeed = 1;

    private int vaccineId;

    private String vaccineName;
    private int doseRequired;
    private int daysBetweenDose;
    
    private int totalDoseReceived;
    
    private int totalDoseLeft;

    public VaccineEntry( String vaccineName, int doseRequired, int daysBetweenDose, int totalDoseReceived, int totalDoseLeft)
    {
        this.vaccineId = idSeed++;
        this.vaccineName = vaccineName;
        this.doseRequired = doseRequired;
        this.daysBetweenDose = daysBetweenDose;
        this.totalDoseReceived = totalDoseReceived;
        this.totalDoseLeft = totalDoseLeft;
    }

    public VaccineEntry()
    {
    	this.vaccineId = idSeed++;
    }

	public int getVaccineId()
    {
        return vaccineId;
    }

    public void setVaccineId( int vaccineId )
    {
        this.vaccineId = vaccineId;
    }



	public String getVaccineName() {
		return vaccineName;
	}


	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}


	public int getDoseRequired() {
		return doseRequired;
	}


	public void setDoseRequired(int doseRequired) {
		this.doseRequired = doseRequired;
	}


	public int getDaysBetweenDose() {
		return daysBetweenDose;
	}


	public void setDaysBetweenDose(int daysBetweenDose) {
		this.daysBetweenDose = daysBetweenDose;
	}


	public int getTotalDoseReceived() {
		return totalDoseReceived;
	}

	public void setTotalDoseReceived(int totalDoseReceived) {
		this.totalDoseReceived = totalDoseReceived;
	}

	public int getTotalDoseLeft() {
		return totalDoseLeft;
	}

	public void setTotalDoseLeft(int totalDoseLeft) {
		this.totalDoseLeft = totalDoseLeft;
	}
	
	public void decrementDose() {
		int doseRemain = getTotalDoseLeft();
	    if (doseRemain > 0) {
	        doseRemain--;
	    }
	    
	    setTotalDoseLeft(doseRemain);
	}


}
