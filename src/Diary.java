/**
 * 
 */

/**
 * @author DAN
 *
 */
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

}
	
