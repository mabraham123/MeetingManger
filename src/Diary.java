/**
 * @author Daniel Scheitler
 * @author Aditya Kumar Menon
 *
 */
public class Diary 
{
	private Employee employee;
	private Appointment appointment;
	private Appointment[] sortedAppointments;
	private Diary left;
	private Diary right;
	private Diary previous;

	/**
	 * Default diary constructor.
	 */
	public Diary() 
	{
		employee = null;
		appointment = null;
	}
	
	public Diary(Employee employeeInfo, Appointment appointmentInfo)
	{
		employee = employeeInfo;
		appointment = appointmentInfo;
	}
	
	/**
	 * Will convert the username to a key.
	 * @param username this is the username to be converted.
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
	 * Will get the employee stored in the diary.
	 * @return the employee
	 */
	public Employee getEmployee() 
	{
		return employee;
	}

	
	/**
	 * Will set the employee to the input employee.
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) 
	{
		this.employee = employee;
	}

	/**
	 * Will get the appointment stored in the diary.
	 * @return the appointment
	 */
	public Appointment getAppointment() 
	{
		return appointment;
	}

	/**
	 * Will set the appointment.
	 * @param appointment the appointment to set
	 */
	public void setAppointment(Appointment appointment) 
	{
		this.appointment = appointment;
	}
	
	/**
	 * Will get the diary node to the left of the current diary node.
	 * @return the left
	 */
	public Diary getLeft() 
	{
		return left;
	}
	
	/**
	 * Will set the diary on the left of the current diary to the input diary.
	 * @param left the left to set
	 * @return The diary node to the left of the current node.
	 */
	public Diary setLeft(Diary left) 
	{
		return this.left = left;
	}
	
	/**
	 * Will get the diary on the right of the current diary.
	 * @return the right node.
	 */
	public Diary getRight() 
	{
		return right;
	}
	
	/**
	 * Will set the diary node on the right to be the input diary node.
	 * @param right the right to set
	 * @return 
	 */
	public Diary setRight(Diary right)
	{
		return this.right = right;
	}

	/**
	 * Will get the appointment in a sorted order.
	 * @return the sortedAppointments
	 */
	public Appointment[] getSortedAppointments() {
		return sortedAppointments;
	}

	/**
	 * Will set the sorted appointment to be the input array.
	 * @param sortedAppointments the sortedAppointments to set
	 */
	public void setSortedAppointments(Appointment[] sortedAppointments) 
	{
		this.sortedAppointments = sortedAppointments;
	}

	/**
	 * Will get the previous diary.
	 * @return the previous
	 */
	public Diary getPrevious()
	{
		return previous;
	}

	/**
	 * Will set the previous Diary.
	 * @param previous the previous to set
	 */
	public void setPrevious(Diary previous) 
	{
		this.previous = previous;
	}
}
	
