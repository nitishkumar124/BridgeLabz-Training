package week6_java8.employee_leave_management_system;
class Employee {
    private String id;
    private String name;
    private int leaveBalance;

    public Employee(String id, String name, int leaveBalance) {
        this.id = id;
        this.name = name;
        this.leaveBalance = leaveBalance;
    }

    public String getId() { return id; }
    public int getLeaveBalance() { return leaveBalance; }
    public void deductLeave(int days) { this.leaveBalance -= days; }
    
    @Override
    public String toString() { return name + " (Balance: " + leaveBalance + ")"; }
}

class LeaveRequest {
    private String employeeId;
    private int requestedDays;
    private String status = "PENDING";

    public LeaveRequest(String employeeId, int requestedDays) {
        this.employeeId = employeeId;
        this.requestedDays = requestedDays;
    }

    public String getEmployeeId() { return employeeId; }
    public int getRequestedDays() { return requestedDays; }
    public void setStatus(String status) { this.status = status; }
    
    @Override
    public String toString() { 
        return "Request: ID " + employeeId + " for " + requestedDays + " days [" + status + "]"; 
    }
}