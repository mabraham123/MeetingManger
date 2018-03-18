/**
 * 
 */

/**
 * @author DAN
 *
 */
public class Employee {
	private String employeeForename;
	private String employeeSurname;
	private String jobPosition;
	private String password;
	private int ID;
	
	public Employee(String forename, String surname, String pass, String position, int i)
	{
		employeeForename = forename;
		employeeSurname = surname;
		jobPosition = position;
		setPassword(pass);
		ID = i;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeForename() {
		return employeeForename;
	}
	/**
	 * @param employeeForename the employeeForename to set
	 */
	public void setEmployeeForename(String employeeForename) {
		this.employeeForename = employeeForename;
	}
	/**
	 * @return the jobPosition
	 */
	public String getJobPosition() {
		return jobPosition;
	}
	/**
	 * @param jobPosition the jobPosition to set
	 */
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the employeeSurname
	 */
	public String getEmployeeSurname() {
		return employeeSurname;
	}
	/**
	 * @param employeeSurname the employeeSurname to set
	 */
	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = employeeSurname;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
