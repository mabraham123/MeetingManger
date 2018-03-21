import java.util.Set;

/**
 * 
 */

/**
 * @author DAN
 *
 */
public class Employee {
	private String employeeForename;
	private String employeeSurname;
	private String jobPosition;
	private String password;
	private String username;
	private int ID;
	private String Key;
	private float dayStart;
    private float dayEnd;
    private Set<Float> busyTimes;
	
	public Employee(String forename, String surname, String pass, String position, int id,String key, float DayStart, float DayEnd,Set<Float> BusyTimes)
	{
		employeeForename = forename;
		employeeSurname = surname;
		jobPosition = position;
		setPassword(pass);
		ID = id;
		dayStart= DayStart;
		dayEnd= DayEnd;
		busyTimes= BusyTimes;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() 
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) 
	{
		this.username = username;
		textToKey(username);
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeForename() {
		return employeeForename;
	}
	/**
	 * @param employeeForename the employeeForename to set
	 */
	public void setEmployeeForename(String employeeForename) {
		this.employeeForename = employeeForename;
	}
	/**
	 * @return the jobPosition
	 */
	public String getJobPosition() {
		return jobPosition;
	}
	/**
	 * @param jobPosition the jobPosition to set
	 */
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
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
	/**
	 * @return the employeeSurname
	 */
	public String getEmployeeSurname() {
		return employeeSurname;
	}
	/**
	 * @param employeeSurname the employeeSurname to set
	 */
	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = employeeSurname;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This is an identifier for the username.
	 * @return the key
	 */
	public String getKey() 
	{
		return Key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) 
	{
		Key = key;
	}
	
	/**
	 * Will convert the username to a key that acts like an ID.
	 * @param username This is the user's username.
	 */
	public String textToKey(String username)
	{
		String key = "";
		for(int i = 0; i < username.length(); i++) 
		{
			String currentLetter = username.substring(i,i+1);
			switch(currentLetter) 
			{
			case "a":
				key = key + "01";
				break;
			case "b":
				key = key + "02";
				break;
			case "c":
				key = key + "03";
				break;
			case "d":
				key = key + "04";
				break;
			case "e":
				key = key + "05";
				break;
			case "f":
				key = key + "06";
				break;
			case "g":
				key = key + "07";
				break;
			case "h":
				key = key + "08";
				break;
			case "i":
				key = key + "09";
				break;
			case "j":
				key = key + "10";
				break;
			case "k":
				key = key + "11";
				break;
			case "l":
				key = key + "12";
				break;
			case "m":
				key = key + "13";
				break;
			case "n":
				key = key + "14";
				break;
			case "o":
				key = key + "15";
				break;
			case "p":
				key = key + "16";
				break;
			case "q":
				key = key + "17";
				break;
			case "r":
				key = key + "18";
				break;
			case "s":
				key = key + "19";
				break;
			case "t":
				key = key + "20";
				break;
			case "u":
				key = key + "21";
				break;
			case "v":
				key = key + "22";
				break;
			case "w":
				key = key + "23";
				break;
			case "x":
				key = key + "24";
				break;
			case "y":
				key = key + "25";
				break;
			case "z":
				key = key + "26";
				break;
			}
		}
		setKey(key);
		return key;
	}

	public float getDayStart() {
		return dayStart;
	}

	public void setDayStart(int dayStart) {
		this.dayStart = dayStart;
	}

	public float getDayEnd() {
		return dayEnd;
	}

	public void setDayEnd(int dayEnd) {
		this.dayEnd = dayEnd;
	}

	public Set<Float> getBusyTimes() {
		return busyTimes;
	}

	public void setBusyTimes(Set<Float> busyTimes) {
		this.busyTimes = busyTimes;
	}
}
