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
	private String key;
	
	public Employee(String forename, String surname, String username, String pass, String position)
	{
		employeeForename = forename;
		employeeSurname = surname;
		jobPosition = position;
		setPassword(pass);
		this.username = username;
		//The username is ensured to be a non-duplicate value.
		key = textToKey(username);

	}
	/**
	 * Will convert the username to a key that acts like an ID.
	 * @param username This is the user's username.
	 * @return 
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
			case "A":
				key = key + "27";
				break;
			case "B":
				key = key + "28";
				break;
			case "C":
				key = key + "29";
				break;
			case "D":
				key = key + "30";
				break;
			case "E":
				key = key + "31";
				break;
			case "F":
				key = key + "32";
				break;
			case "G":
				key = key + "33";
				break;
			case "H":
				key = key + "34";
				break;
			case "I":
				key = key + "35";
				break;
			case "J":
				key = key + "36";
				break;
			case "K":
				key = key + "37";
				break;
			case "L":
				key = key + "38";
				break;
			case "M":
				key = key + "39";
				break;
			case "N":
				key = key + "40";
				break;
			case "O":
				key = key + "41";
				break;
			case "P":
				key = key + "42";
				break;
			case "Q":
				key = key + "43";
				break;
			case "R":
				key = key + "44";
				break;
			case "S":
				key = key + "45";
				break;
			case "T":
				key = key + "46";
				break;
			case "U":
				key = key + "47";
				break;
			case "V":
				key = key + "48";
				break;
			case "W":
				key = key + "49";
				break;
			case "X":
				key = key + "50";
				break;
			case "Y":
				key = key + "51";
				break;
			case "Z":
				key = key + "52";
				break;
			}
		}
		setKey(key);
		return key;
		
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
}
