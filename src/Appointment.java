import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Melvin Abraham
 * @author Daniel Scheitler
 * 
 * The appointment class stores details about an appointment.
 */
public class Appointment 
{
	//The fields which store information about an appointment are stored here.
	private String appointmentType;
	private String description;
	private float startTime;
	private float endTime;
	private GregorianCalendar appointmentDate;
	
	//The appointments operate as a linked list and have a reference to the next appointment.
	private Appointment nextAppointment;
	
	/**
	 * The default appointment constructor.
	 */
	public Appointment() 
	{
		appointmentType = "";
		description = "";
		startTime = 0.0f;
		endTime = 0.0f;
		appointmentDate = new GregorianCalendar(0, 0, 0);
		nextAppointment = null;
	}
	
	/**
	 * Alternative appointment constructor.
	 * @param type This is the appointment type.
	 * @param desc This is a description of the appointment
	 * @param start This is the time at which the appointment starts.
	 * @param end This is the time at which the appointment ends.
	 * @param i This is the input year to set.
	 * @param j This is the input month to set.
	 * @param k This is the input day to set.
	 */
	public Appointment(String type, String desc, float start, float end, int i, int j, int k)
	{
		appointmentType = type;
		description = desc;
		startTime = start;
		endTime = end;
		appointmentDate = new GregorianCalendar(i, j, k);
		nextAppointment = null;
	}
	
	/**
	 * @return the appointmentType
	 */
	public String getAppointmentType() 
	{
		return appointmentType;
	}
	
	/**
	 * @param appointmentType the appointmentType to set
	 */
	public void setAppointmentType(String appointmentType) 
	{
		this.appointmentType = appointmentType;
	}
	
	/**
	 * @return the startTime
	 */
	public float getStartTime() 
	{
		return startTime;
	}
	
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(float startTime) 
	{
		this.startTime = startTime;
	}
	
	/**
	 * @return the endTime
	 */
	public float getEndTime() 
	{
		return endTime;
	}
	
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(float endTime) 
	{
		this.endTime = endTime;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() 
	{
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	/**
	 * @return the nextAppointment
	 */
	public Appointment getNextAppointment() 
	{
		return nextAppointment;
	}
	
	/**
	 * @param nextAppointment the nextAppointment to set
	 */
	public void setNextAppointment(Appointment nextAppointment) 
	{
		this.nextAppointment = nextAppointment;
	}
	
	/**
	 * @return the appointmentDate
	 */
	public Calendar getAppointmentDate() 
	{
		return appointmentDate;
	}
	
	/**
	 * Sets the appointment date 
	 * @param year The year of appointment
	 * @param month The month of appointment
	 * @param day The day of appointment
	 */
	public void setAppointmentDate(int year, int month, int day) 
	{
		this.appointmentDate = new GregorianCalendar(year, month, day);
	}
}
