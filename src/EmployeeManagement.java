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
	private String key;
	private String userName;
	private String employeeForename;
	private String employeeSurname;
	private String jobPosition;
	private String password;
	
	
	public EmployeeManagement (String i,String u, String fn, String sn, String j) {
	/**
	 *  The following methods initialise the Linked lists that stores employees
	 */
		key = i;
		userName = u;
		employeeForename = fn;
		employeeSurname = sn;
		jobPosition = j;
	}
	
	public String getUserName() {
	/**
	 *  @returns the employee username
	 */
		return userName;
	}


	public void setUserName(String userName) {
	/**
	 * @parm sets the employee username
	 */
		this.userName = userName;
	}


	public String getEmployeeName() {
	/**
	 * @parm returns employee name
	 */
		return employeeForename;
	}


	public void setEmployeeName(String employeeForename) {
		this.employeeForename = employeeForename;
	}


	public String getJobPosition() {
		/**
		 * @parm returns employee name
		 */
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
	 * @parm returns Hard coded data
	 */
	{
LinkedList<EmployeeManagement> details = new LinkedList<EmployeeManagement>();
		
		details.add( new EmployeeManagement("","DScheitler","Daniel", "Scheitler","CEO"));
		details.add( new EmployeeManagement("","GWashington","George", "Washington","employee"));
		details.add( new EmployeeManagement("","ALincion","Abraham", "Linicon ","CEO"));
	}


}
