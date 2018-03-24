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
	private float dayStart;
    private float dayEnd;
    private Set<Float> busyTimes;
	
    
    public EmployeeManagement() {
    	key= "";
    	userName="";
    	employeeForename="";
    	employeeSurname="";
    	jobPosition="";
    	password="";
    	dayStart= 0.0f;
        dayEnd=0.0f;
        busyTimes= new HashSet<Float>();
    }
    
	public EmployeeManagement (String Key,String username, String firstname, String surname, String jobposition, String password,float daystart, float dayend, Set<Float> busytimes) {
	/**
	 *  The following methods initialise the Linked lists that stores employees
	 */
		setKey(Key);
		userName = username;
		employeeForename = firstname;
		setEmployeeSurname(surname);
		jobPosition = jobposition;
		dayStart= daystart;
		dayEnd= dayend;
		busyTimes= busytimes;
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
		
		Set<Float> busyTimes1= new HashSet<Float>();
		
		busyTimes1.add(9.0f);
		busyTimes1.add(10.0f);
		busyTimes1.add(11.0f);
		
		Set<Float> busyTimes2= new HashSet<Float>();
		
		busyTimes2.add(9.0f);
		busyTimes2.add(16.0f);
		
		//(String Key,String username, String firstname, String surname, String jobposition, String password,float daystart, float dayend, Set<Float> busytimes)
		details.add( new EmployeeManagement("123", "TomJ", "Tom", "Jones", "CEO", "TomJ", 9.0f, 12.0f, busyTimes1));
		
		details.add( new EmployeeManagement("123", "TomA", "Tom", "Apple", "TeD", "TomA", 9.0f, 16.0f, busyTimes2));
		
		details.add( new EmployeeManagement("123", "TomB", "Tom", "Bravo", "ToD", "TomB", 9.0f, 16.0f, busyTimes2));
	}

	public String getEmployeeSurname() {
		return employeeSurname;
	}

	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = employeeSurname;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getDayStart() {
		return dayStart;
	}

	public void setDayStart(float dayStart) {
		this.dayStart = dayStart;
	}

	public float getDayEnd() {
		return dayEnd;
	}

	public void setDayEnd(float dayEnd) {
		this.dayEnd = dayEnd;
	}

	public Set<Float> getBusyTimes() {
		return busyTimes;
	}

	public void setBusyTimes(Set<Float> busyTimes) {
		this.busyTimes = busyTimes;
	}


}
