package homework3.model;

  
import java.util.Date;   

public class PatientViewModel {
	
	int id;
	
	String name;
	
	int vaccineId;
	
	String vaccineName;
	
	int vaccineDosesRequired;
	
	int vaccineDosesLeft;
	
	Date firstDoseDate;
	
	Date secondDoseDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public int getVaccineDosesRequired() {
		return vaccineDosesRequired;
	}

	public void setVaccineDosesRequired(int vaccineDosesRequired) {
		this.vaccineDosesRequired = vaccineDosesRequired;
	}

	public int getVaccineDosesLeft() {
		return vaccineDosesLeft;
	}

	public void setVaccineDosesLeft(int vaccineDosesLeft) {
		this.vaccineDosesLeft = vaccineDosesLeft;
	}

	public Date getFirstDoseDate() {
		return firstDoseDate;
	}

	public void setFirstDoseDate(Date firstDoseDate) {
		this.firstDoseDate = firstDoseDate;
	}

	public Date getSecondDoseDate() {
		return secondDoseDate;
	}

	public void setSecondDoseDate(Date secondDoseDate) {
		this.secondDoseDate = secondDoseDate;
	}
	
	public boolean checkSecondDose() {
		if (secondDoseDate == null) {
			return false;
		}

		return true;
	}
	
	
}