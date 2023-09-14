package cs3220_final.model;

public class ReadingEntry {
	static int idSeed = 1;

	private int id;
	private int systolic;
	private int diastolic;
	private int user_id;
	private String time;
	
	// Constructor
	public ReadingEntry(int systolic, int diastolic, int user_id, String time) {
		this.id = idSeed++;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.user_id = user_id;
		this.time = time;
	}
	
	
	
	public ReadingEntry() {
		
	}



	// Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSystolic() {
		return systolic;
	}
	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}
	public int getDiastolic() {
		return diastolic;
	}
	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}