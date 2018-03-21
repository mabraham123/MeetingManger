
/**
 * @author Melvin Abraham
 *
 */

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Diary {
	private Employee employee;
	private Appointment appointment;
	private Appointment[] sortedAppointments;
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
	 * @return the sortedAppointments
	 */
	public Appointment[] getSortedAppointments() {
		return sortedAppointments;
	}

	/**
	 * @param sortedAppointments the sortedAppointments to set
	 */
	public void setSortedAppointments(Appointment[] sortedAppointments) {
		this.sortedAppointments = sortedAppointments;
	}

	/**
     * Method to find a possible meeting time for all the members of the meeting
     * @param allMeetingMembers Array of every person in the meeting
     * @param rangeStart start of the range of working time
     * @param rangeEnd end of the range of working time
     * @param startTime the earliest time the user has suggested
     * @param endTime the last time the user has suggested
     */
    public Set<Float> findAMeeting(Employee[] allMeetingMembers,Calendar date ,int rangeStart, int rangeEnd){
    	//Create a set to hold the full working day
    	Set<Float> rangeOfTimesSet= new HashSet<Float>();
    	
    	//Setting the earliest time to the first time in the array
            //Find minimum
    	float earliestTime= allMeetingMembers[0].getDayStart();
    	//Find the earliest time all the members are working
    	for(int index=1; index<allMeetingMembers.length; index++) {
    		//If the meeting time
    		if(allMeetingMembers[index].getDayStart()<earliestTime){
    			earliestTime= allMeetingMembers[index].getDayStart();
    		}
    	}
    	
    	//Find the latest time all the members are working
            //Find minimum
            float latestTime= allMeetingMembers[0].getDayEnd();
            
    	for(int counter=1; counter<allMeetingMembers.length; counter++){
    		if(allMeetingMembers[counter].getDayEnd()<latestTime){
    			latestTime= allMeetingMembers[counter].getDayEnd();
    		}
    	}
    	
            float timeAdded=0.0f;
    	//Fill the set with the full working day
            do{
                //Make timeAdded the first time to add
                timeAdded= earliestTime;
                
                boolean rangeOfTimeAdded= rangeOfTimesSet.add(timeAdded);

                timeAdded+= 0.5;
            }while(timeAdded!=latestTime);
            
            //Set for all the busy times the members have
            Set<Float> busyTimesAll= new HashSet<Float>();
            
            
            for(int i=0; i<allMeetingMembers.length; i++){
            	busyTimesAll.addAll(allMeetingMembers[i].getBusyTimes());
            }
            
            
            Set<Float> possibleTimes= rangeOfTimesSet;
            
            //Remove the busy times from the set
            boolean possibleTimesAdded= possibleTimes.removeAll(busyTimesAll);
           
            
            return possibleTimes;
            
            
            
    }
	
	
	
}
	
