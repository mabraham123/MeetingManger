import java.util.ArrayList;

/**
 * @author DAN
 *
 */
public class Diary 
{
	private Employee employee;
	Appointment appointment;
	private Appointment[] sortedAppointments;
	private Diary left;
	private Diary right;
	private Diary previous;
	private Menu push;

	public Diary(Employee employeeInfo, Appointment appointmentInfo)
	{
		employee = employeeInfo;
		appointment = appointmentInfo;
	}
	
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
	 * Adds an appointment to the diary of the logged in user
	 * @param appointmentType Type of appointment
	 * @param description Description of appointment
	 * @param startTime Start time of appointment
	 * @param endTime End time of appointment
	 * @param year Year of appointment
	 * @param month Month of appointment
	 * @param day Day of appointment
	 * @param loggedIn The diary to be added to
	 */
	public void addAppointment(String appointmentType, String description, float startTime, float endTime, int year, int month, int day, Diary loggedIn)
	{
		Appointment current = loggedIn.getAppointment();
		Appointment appointmentToAdd = new Appointment(appointmentType, description, startTime, endTime, null, year, month, day);
		
		if (loggedIn.getAppointment() == null)
		{
			loggedIn.setAppointment(appointmentToAdd);
		}
		else
		{
			while (current.getNextAppointment() != null)
			{
				current = current.getNextAppointment();
			}
			current.setNextAppointment(appointmentToAdd);
			//loggedIn = current;
		}
	}
	
	public void sortAppointments(Diary loggedIn)
	{
		ArrayList<Appointment> arrayList = new ArrayList<Appointment>();
		Appointment current = loggedIn.getAppointment();
		Appointment temp = null;
		
		while (current != null)
		{
			arrayList.add(current);
			current = current.getNextAppointment();
		}
		Appointment[] sortedArray = new Appointment[arrayList.size()];
		
		current = loggedIn.getAppointment();
		for (int p = 0; p < sortedArray.length; p++)
		{
			sortedArray[p] = current;
			current = current.getNextAppointment();
		}
		
		for (int i = 0; i < sortedArray.length - 1; i++)
		{
			for (int j = 0; j < (sortedArray.length - i - 1); j++)
			{
				if (sortedArray[j].getAppointmentDate().after(sortedArray[j+1].getAppointmentDate()))
				{
					temp = sortedArray[j];  
					sortedArray[j] = sortedArray[j+1];  
					sortedArray[j+1] = temp; 
				}
			}
		}
		loggedIn.setSortedAppointments(sortedArray);
	}
	
	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(Appointment appointmentToAdd) {
		this.appointment = appointmentToAdd;
	}
	
	
	public Menu getSendtoUndo() {
		return push;
	}

	public void setSendtoUndo(Menu appointmentToAdd1) {
		this.push = appointmentToAdd1;
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
	 * @return the previous
	 */
	public Diary getPrevious() {
		return previous;
	}

	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(Diary previous) {
		this.previous = previous;
	}
}
	
