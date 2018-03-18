import java.util.*;
/**
 * This class stores employee details. 
 * 
 * @version 1.0
 * 
 * @author Elliot Kinkead
 *
 */
public class EmployeeManagement {
	
	// Initialise variables
	private int ID;
	private String userName;
	private String employeeName;
	private String jobPosition;
	
	
	public EmployeeManagement (int i,String u, String e, String j) {
	/**
	 *  The following methods initialise the Linked lists that stores employees
	 */
		ID = i;
		userName = u;
		employeeName = e;
		jobPosition = j;
	}
	
	// @returns the employee username
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getJobPosition() {
		return jobPosition;
	}


	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}
	
	public void InitialiseEmployee( )
	/**
	 * 
	 * This method stores employee that can be tested for the meeting management. You can either add the method below or 
	 * or use this method.
	 * 
	 * @parm returns
	 */
	{
LinkedList<EmployeeManagement> details = new LinkedList<EmployeeManagement>();
		
		details.add( new EmployeeManagement(101,"DScheitler","Daniel Scheitler","CEO"));
		details.add( new EmployeeManagement(102,"GWashington","George Washington","employee"));
		details.add( new EmployeeManagement(103,"ALincion","Abraham Linicon ","CEO"));
	}


}
