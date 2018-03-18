import java.util.Calendar;
import java.util.GregorianCalendar;

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
	private Calendar appointmentDate;
	private Appointment nextAppointment;
	
	public Appointment(String type, String desc, String start, String end, Object next, int i, int j, int k)
	{
		appointmentType = type;
		description = desc;
		startTime = start;
		endTime = end;
		appointmentDate = new GregorianCalendar(i, j, k);
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
	/**
	 * @return the appointmentDate
	 */
	public Calendar getAppointmentDate() {
		return appointmentDate;
	}
	/**
	 * Sets the appointment date 
	 * @param year The year of appointment
	 * @param month The month of appointment
	 * @param day The day of appointment
	 */
	public void setAppointmentDate(int year, int month, int day) {
		this.appointmentDate = new GregorianCalendar(year, month, day);
	}
}
