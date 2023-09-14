package cs3220.model;

public class Attraction {
	// Data fields
	private String name;
	private String number;
	
	// Default constructor
	public Attraction() {
		
	}
	
	// Constructor with data fields
	public Attraction(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
