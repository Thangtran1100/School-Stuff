package cs3220_final.model;

public class UserEntry {
	static int idSeed = 1;

	private int id;
	private String name;

	// Constructor
	public UserEntry(String name) {
		this.id = idSeed++;
		this.name = name;
	}

	public UserEntry() {
		this.id = idSeed++;
	}

	// Getters and setters
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

}
