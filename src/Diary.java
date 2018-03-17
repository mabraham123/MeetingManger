import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

/**
 * @author Melvin Abraham
 *
 */
public class Diary {
	private Employee employee;
	private Appointment appointment;
	private Diary left;
	private Diary right;
	
	public Diary(Employee employeeInfo, Appointment appointmentInfo)
	{
		employee = employeeInfo;
		appointment = appointmentInfo;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the appointment
	 */
	public Appointment getAppointment() {
		return appointment;
	}

	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	/**
	 * @return the left
	 */
	public Diary getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 * @return 
	 */
	public Diary setLeft(Diary left) {
		return this.left = left;
	}
	/**
	 * @return the right
	 */
	public Diary getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 * @return 
	 */
	public Diary setRight(Diary right) {
		return this.right = right;
	}
        
        
        /**
         * Method to find a possible meeting time for all the members of the meeting
         * @param allMeetingMembers Array of every person in the meeting
         * @param rangeStart start of the range of working time
         * @param rangeEnd end of the range of working time
         * @param startTime the earliest time the user has suggested
         * @param endTime the last time the user has suggested
         */
        public void findAMeeting(Employee[] allMeetingMembers, String rangeStart, String rangeEnd){
        	//Create a set to hold the full working day
        	Set<String> rangeOfTimesSet= new HashSet<String>();
        	
        	//Setting the earliest time to the first time in the array
        	int earliestTime= allMeetingMembers[0].getDayStart();
        	//Find the earliest time all the members are working
        	for(int index=1; index<allMeetingMembers.length; index++) {
        		//If the meeting time
        		if(allMeetingMembers[index].getDayStart()<earliestTime){
        			earliestTime= allMeetingMembers[index].getDayStart();
        		}
        	}
        	
        	//Find the latest time all the members are working
        	for(int counter=1; counter<allMeetingMembers.length; counter++){
        		if(allMeetingMembers[index].getDayStart()<earliestTime){
        			earliestTime= allMeetingMembers[index].getDayStart();
        		}
        	}
        	
        	
        	
        	
        	
        }
        
        
        
        
}