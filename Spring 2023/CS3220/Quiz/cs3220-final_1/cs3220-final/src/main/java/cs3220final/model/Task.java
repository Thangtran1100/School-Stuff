package cs3220final.model;

public class Task {
	
	private int id;
	private String task;
	private String detail;
	private String status;
	private int userId;
	
	public Task() {}
	
	public Task(int id, String task, String detail, String status, int userId) {
		
		this.id = id;
		this.task = task;
		this.detail = detail;
		this.status = status;
		this.userId = userId;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int user_id) {
		this.userId = user_id;
	}
}
