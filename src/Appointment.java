import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author DAN
 *
 */
public class Appointment {
	private String appointmentType;
	private String description;
	private float startTime;
	private float endTime;
	private Calendar appointmentDate;
	private Appointment nextAppointment;
	
	public Appointment() 
	{
		appointmentType = null;
		description = null;
		startTime = 0;
		endTime = 0;
		appointmentDate = null;
	}
	
	public Appointment(String type, String desc, float start, float end, Object next, int i, int j, int k)
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
	
	public void setAppointment1Type(String appointmentType) {
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
	public void setEndTime(float endTime) {
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
	
	public void setAppointmentDate(Calendar calander) 
	{
		this.appointmentDate = calander;
	}

	/**
	 * Will save appointment details to a text file.
	 * @param appointment This is the appointment object to be saved.
	 * @param diary This is the diary object the appointment will be saved to.
	 */
	public void saveAppointment(Appointment appointment, Diary diary) 
	{
		try
		{
			//A filewriter object is created with the append parameter set to true and the filename to be the unique employer's key.
			FileWriter file = new FileWriter(diary.getEmployee().getKey(), true);
			//The bufferedwriter takes the filewriter object as input.
			BufferedWriter writer = new BufferedWriter(file);
			
			//The fields in this appointment are recorded in the file.
			writer.write(appointment.getAppointmentType() + ";");
			writer.write(appointment.getDescription());
			writer.newLine();
			writer.write(appointment.getStartTime() + ",");
			writer.write(String.valueOf(appointment.getEndTime()));
			//writer.write(appointment.getAppointmentDate());
			writer.newLine();
			//The writer is closed to avoid memory leaks.
			writer.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Will load the employee's schedule and print it to console.
	 * @param diary This is the employee's diary.
	 */
	public void loadSchedule(Diary diary) 
	{
		try 
		{ 
			//File is found based on the employee's key.
			FileReader file = new FileReader(diary.getEmployee().getKey());
			//Buffered Reader will begin reading the file.
			BufferedReader reader = new BufferedReader(file);
			
			//The current line is set to be the first line in the file.
			String currentLine = reader.readLine();
			//Loop continues until the file is empty.
			while (currentLine != null) 
			{
				//The line is split into the appointment type and the description and then printed individually.
				String[] details = currentLine.split(";");
				System.out.println("Appointment Type: " + details[0]);
				System.out.println("Description: " + details[1]);
				//The next line is read and split into the start and end times and printed individually.
				currentLine = reader.readLine();
				details = currentLine.split(",");
				System.out.println("Start Time: " + details[0]);
				System.out.println("End Time: " + details[1]);
				//The current line is read twice.
				currentLine = reader.readLine();
				currentLine = reader.readLine();
			}
			//The reader is closer to avoid memory leaks.
			reader.close();
		}
		catch(java.io.FileNotFoundException e) 
		{
			System.out.println("File not found.");
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}
