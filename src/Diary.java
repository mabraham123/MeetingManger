import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Melvin Abraham
 * @author Daniel Scheitler
 * @author Aditya Kumar Menon
 *
 * The diary stores the employee's details and appointments.
 */
public class Diary 
{
	//These are the fields stored within the Diary class
	private Employee employee;
	private Appointment appointment;
	private Appointment[] sortedAppointments;
	//These fields store the location to other diaries in the binary tree.
	private Diary left;
	private Diary right;
	private Diary previous;

	/**
	* Default Diary constructor
	*/
	public Diary() 
	{
		// TODO Auto-generated constructor stub
		employee= new Employee();
		left= null;
		right= null;
		previous= null;
	}
	
	/**
	 * Alternative diary constructor.
	 * @param employeeInfo This is an employee object that will be assigned to the diary.
	 * @param appointmentInfo This is an appointment object that will be assigned to the diary.
	 */
	public Diary(Employee employeeInfo, Appointment appointmentInfo)
	{
		employee = employeeInfo;
		appointment = appointmentInfo;
	}

	/**
	 * Will convert a username into a key which is a string of numbers.
	 * @param username This is the employee's username.
	 * @return The converted key string.
	 */
	public String convertToKey(String username)
	{
		return employee.textToKey(username);
	}
	
	/**
	 * Will test if the node to the left is empty.
	 * @param node This is the current node being tested for.
	 * @return empty It is the value that determines if the reference to the left is empty or not.
	 */
	public boolean isLeftEmpty(Diary node) 
	{
		boolean empty;
		if (node.getLeft() == null) 
		{
			//Will set empty to true if the node to the left is a null value.
			empty = true;
		}
		else 
		{
			//Will set empty to false if the node to the left is not null.
			empty = false;
		}
		return empty;
	}
	
	/**
	 * Will test if the node to the right is empty.
	 * @param node This is the current node being tested for.
	 * @return empty It is the value that determines if the reference to the right is empty or not.
	 */
	public boolean isRightEmpty(Diary node) 
	{
		boolean empty;
		if (node.getRight() == null) 
		{
			//Will set empty to true if the node to the right is a null value.
			empty = true;
		}
		else 
		{
			//Will set empty to false if the node to the right is not null.
			empty = false;
		}
		return empty;
	}
	
	/**
	 * @return the employee
	 */
	public Employee getEmployee() 
	{
		return employee;
	}

	
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) 
	{
		this.employee = employee;
	}

	/**
	 * @return the appointment
	 */
	public Appointment getAppointment() 
	{
		return appointment;
	}

	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(Appointment appointment) 
	{
		this.appointment = appointment;
	}
	
	/**
	 * @return the left
	 */
	public Diary getLeft() 
	{
		return left;
	}
	
	/**
	 * @param left the left to set
	 * @return 
	 */
	public Diary setLeft(Diary left) 
	{
		return this.left = left;
	}
	
	/**
	 * @return the right
	 */
	public Diary getRight() 
	{
		return right;
	}
	
	/**
	 * @param right the right to set
	 * @return 
	 */
	public Diary setRight(Diary right) 
	{
		return this.right = right;
	}

	/**
	 * @return the sortedAppointments
	 */
	public Appointment[] getSortedAppointments() 
	{
		return sortedAppointments;
	}

	/**
	 * @param sortedAppointments the sortedAppointments to set
	 */
	public void setSortedAppointments(Appointment[] sortedAppointments) 
	{
		this.sortedAppointments = sortedAppointments;
	}

	/**
	 * @return the previous
	 */
	public Diary getPrevious() 
	{
		return previous;
	}

	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(Diary previous) 
	{
		this.previous = previous;
	}
	
	
	
	
	
	/**
     * Method to find a possible meeting time for all the members of the meeting
     * @param allMeetingMembers Array of every person in the meeting
     * @param date The date of the potential meeting
     */
    public Set<Float> findAMeetingTime(Employee[] allMeetingMembers,int date)
    {
    	//Create a set to hold the full working day
    	Set<Float> rangeOfTimesSet= new HashSet<Float>();
    	
    	//Setting the earliest time to the first time in the array
    	float earliestTime= allMeetingMembers[0].getDayStart();
    	//Find the earliest time all the members are working
    	for(int index=1; index<allMeetingMembers.length; index++) 
    	{
    		//TODO: Add comment
    		if(allMeetingMembers[index].getDayStart()<earliestTime)
    		{
    			earliestTime= allMeetingMembers[index].getDayStart();
    		}
    	}
    	
    	//Find the latest time all the members are working
        float latestTime= allMeetingMembers[0].getDayEnd();
        
        //TODO: Add comment
    	for(int counter=1; counter<allMeetingMembers.length; counter++)
    	{
    		//TODO: Add comment
    		if(allMeetingMembers[counter].getDayEnd()<latestTime)
    		{
    			latestTime= allMeetingMembers[counter].getDayEnd();
    		}
    	}
    	
    	//Make timeAdded the first time to add
    	float timeAdded= earliestTime;
    	//Fill the set with the full working day
    	do
    	{
    		//TODO: Add comment
    		boolean rangeOfTimeAdded= rangeOfTimesSet.add(timeAdded);

            timeAdded+= 0.5;	//Add a half hour
        }
    	while(timeAdded!=latestTime);
            
        //Set for all the busy times the members have
        Set<Float> busyTimesAll= new HashSet<Float>();
            
        //Add all the busy times for each member into one big set
        for(int i=0; i<allMeetingMembers.length; i++)
        {
        	busyTimesAll.addAll(allMeetingMembers[i].getBusyTimes());
        }
            
        //TODO: Add comment
        Set<Float> possibleTimes= rangeOfTimesSet;
            
        //Remove the busy times from the set of possible times
        boolean possibleTimesAdded= possibleTimes.removeAll(busyTimesAll);

        return possibleTimes;
    }
}


	
