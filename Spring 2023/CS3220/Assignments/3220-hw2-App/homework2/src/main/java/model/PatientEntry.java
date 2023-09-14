package model;

import java.util.UUID;

public class PatientEntry {

	static int idSeed = 1;

	private int patientId;

	private String uuid;

	private String patientName;
	
	private String vaccineName;

	private String firstDoseDate;

	private String secondDoseDate;


	public PatientEntry(String patientName, String vaccineName, String firstDoseDate, String secondDoseDate) {
		this.patientId = idSeed++;
		this.patientName = patientName;
		this.vaccineName = vaccineName;
		this.firstDoseDate = firstDoseDate;
		this.secondDoseDate = secondDoseDate;

		setUuid(UUID.randomUUID().toString());
	}
	

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public String getFirstDoseDate() {
		return firstDoseDate;
	}

	public void setFirstDoseDate(String firstDoseDate) {
		this.firstDoseDate = firstDoseDate;
	}

	public String getSecondDoseDate() {
		return secondDoseDate;
	}

	public void setSecondDoseDate(String secondDoseDate) {
		this.secondDoseDate = secondDoseDate;
	}


	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public boolean checkSecondDose() {
		if (secondDoseDate.equals("")) {
			return false;
		}

		return true;
	}
}
