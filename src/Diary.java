
/**
 * @author DAN
 *
 */
public class Diary {
	private Employee employee;
	private int ID;
	private Appointment appointment;
	private Appointment[] sortedAppointments;
	private Diary left;
	private Diary right;
	private Diary previous;
	
	
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
	
}
	
