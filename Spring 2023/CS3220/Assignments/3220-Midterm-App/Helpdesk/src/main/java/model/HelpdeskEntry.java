package model;

public class HelpdeskEntry {
	static int idSeed = 1;
	
	private int requestId;
	
	private String requestTime;
	
	private String customerName;
	
	private String departmentName;
	
	private String requestStatus;
	
	private String assignedEmployeeName;
	
	private String reason;

	public HelpdeskEntry(String requestTime, String customerName, String departmentName,
			String requestStatus, String assignedEmployeeName) {
		
		this.requestId = idSeed++;
		this.requestTime = requestTime;
		this.customerName = customerName;
		this.departmentName = departmentName;
		this.requestStatus = requestStatus;
		this.assignedEmployeeName = assignedEmployeeName;
		
		this.reason = "";
	}
	
	public HelpdeskEntry(String requestTime, String customerName, String departmentName, String requestStatus,
			String assignedEmployeeName, String reason) {
		super();
		this.requestTime = requestTime;
		this.customerName = customerName;
		this.departmentName = departmentName;
		this.requestStatus = requestStatus;
		this.assignedEmployeeName = assignedEmployeeName;
		this.reason = reason;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getAssignedEmployeeName() {
		return assignedEmployeeName;
	}

	public void setAssignedEmployeeName(String assignedEmployeeName) {
		this.assignedEmployeeName = assignedEmployeeName;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}