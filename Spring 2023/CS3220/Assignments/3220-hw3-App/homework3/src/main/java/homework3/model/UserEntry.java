package homework3.model;

public class UserEntry {
	static int idSeed = 1;

	private int id;
	private String name;
	private String username;
	private String password;
	private String role;

// Constructor
	public UserEntry(String name, String username, String password, String role) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

// toString() method for debugging
	@Override
	public String toString() {
		return "UserEntry{" + "id=" + id + ", name='" + name + '\'' + ", username='" + username + '\'' + ", password='"
				+ password + '\'' + ", role='" + role + '\'' + '}';
	}
}
