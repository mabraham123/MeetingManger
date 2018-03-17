import java.util.Set;
import java.util.HashSet;


/**
 * @author Melvin Abraham
 *
 */



public class Employee {
	private String employeeName;
	private String jobPosition;
	private int ID;
    private int dayStart;
    private int dayEnd;
    private Set<String> busyTimes;
	
	public Employee(String name, String position, int i)
	{
		employeeName = name;
		jobPosition = position;
		ID = i;
                busyTimes= new HashSet<String>();
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
         * Method to get the employee's work start time
	 * @return The start time to the employee
	 */
	public int getDayStart() {
		return dayStart;
	}
        
	/**
         * Method to set the employee's work start time
	 * @param The start time of the employee
	 */
	public void setDayStart(int time) {
		dayStart = time;
	}
        
        /**
         * Method to get the employee's work end time
	 * @return The end time of the employee
	 */
	public int getDayEnd() {
		return dayEnd;
	}
        
	/**
         * Method to set the employee's work end time
	 * @param The end time of the employee
	 */
	public void setDayEnd(int time) {
		dayEnd = time;
	}
        
        /**
         * Method to add the busy times for the employee 
         * @param A time that the employee is busy
         */
        public void addToBusyTimesSet(String time){
            if(busyTimes.add(time)){
                System.out.println(time+ " is added to the set");
            }
        }
        
}
