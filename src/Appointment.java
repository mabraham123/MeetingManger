/**
 * 
 */

/**
 * @author DAN
 *
 */
public class Appointment {
	private String appointmentType;
	private String description;
	private String startTime;
	private String endTime;
	private Appointment nextAppointment;
	
	public Appointment(String type, String desc, String start, String end, Object next)
	{
		appointmentType = type;
		description = desc;
		startTime = start;
		endTime = end;
		nextAppointment = (Appointment) next;
	}
	/**
	 * @return the appointmentType
	 */
	public String getAppointmentType() {
		return appointmentType;
	}
	/**
	 * @param appointmentType the appointmentType to set
	 */
	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the nextAppointment
	 */
	public Appointment getNextAppointment() {
		return nextAppointment;
	}
	/**
	 * @param nextAppointment the nextAppointment to set
	 */
	public void setNextAppointment(Appointment nextAppointment) {
		this.nextAppointment = nextAppointment;
	}
}
