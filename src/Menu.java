import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;


/**
 * @author Melvin Abraham
 * @author Daniel Scheitler
 * @author Aditya Kumar Menon
 * @author Elliot Kinkhead
 *
 *Class that runs the front end
 */
public class Menu 
{
	private DiaryTree diaryTree;
	private Diary loggedIn;
	private String username;
	
	//A scanner object is created here to get user input.
	Scanner input = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Menu menu = new Menu();
		
		menu.init();
		menu.authenticateLogin();
        menu.process();
	}
	/**
	 * Instantiates any objects at the start
	 */
	public void init()
	{
		setDiaryTree(new DiaryTree());
		diaryTree.loadTree(0);
		
	}

	/**
	 * Will authenticate if the login is valid or not.
	 * @return authenticated This value determines if the login is successful or not.
	 */
	public boolean authenticateLogin() 
	{
		//The authenticated value is false unless proven otherwise.
		boolean authenticated = false;
		//The username will be asked for from the user.
		System.out.print("Username: ");
		String username = input.nextLine();
		//The username will be searched for in the binary tree.
		Diary user = diaryTree.searchTree(username);
		System.out.println();
		//The password will be asked for from the user.
		System.out.print("Password: ");
		String password = input.nextLine();
		//If the input password is equal to the stored password then the credentials have been authorized.
		if(password.equals(user.getEmployee().getPassword()))
		{
			System.out.println("Login successful");
			authenticated = true;
			loggedIn = user;
		}
		return authenticated;
	}
	
	/**
	 * Method that runs the menu
	 */
	public void process()
   {
		// Run the menu
		runMenu();
   }
	
	/**
	 * The menu that runs and the user can input letters to run methods of the program
	 */
	public void runMenu()
	{
		String choice;

		boolean exit=false;

		do
		{
			System.out.println("Meeting Manager Test Menu");
			System.out.println("A - add appointment to diary");
			System.out.println("E - edit appointment in diary");
			System.out.println("D - delete appointment from diary");
			System.out.println("P - print appointments of employee");
			System.out.println("S - Save binary tree");
			System.out.println("Q - quit");        

			choice=getString("Please make a choice, and press ENTER: ");

			switch (choice)
			{
			case "A":
			case "a":
				//Method to add an appointment
				addAppointment();
				break;
			case "E":
			case "e":
				//Check if the user has any appointments at all
				if (loggedIn.getAppointment() != null)
				{
					//Method to edit an appointment
					editAppointment();
				}
				else
				{
					System.out.println("Error: You must first add an appointment!");
				}
				break;
			case "P":
			case "p":
				//Method to print the diary
				viewDiary();
				break;
			case "D":
			case "d":
				//Check if the user has any appointments at all
				if (loggedIn.getAppointment() != null)
				{
					//method to delete appointments
					deleteAppointment();
				}
				else
				{
					System.out.println("Error: You must first add an appointment!");
				}
				break;
			case "S":
			case "s":
				//save
				diaryTree.writeFile(diaryTree.getRoot());
				break;
			case "Q":
			case "q": 
				System.out.println("Goodbye\n");
				exit=true;
				break;
			default: System.out.println("That is not a valid choice, please try again");
			break;         
			}
		}while (!exit);
		
		System.exit(0);
   }
	
	/**
	 * Method to create a new appointment
	 * Asks the user for the appointment information and then gives the user a list of times an appointment can take place
	 */
	public void addAppointment() 
	{		
		//Get the appointment type
		System.out.println("Appointment Type: ");
		String appointmentType= getValidString(); 

		//Get the description
		System.out.println("Description: ");
		String description= getValidString();


		//Get the duration
		System.out.println("Duration: ");
		System.out.println("(Hours e.g 1.5)" );
		float duration= getValidFloat();




		//Get the members of the meeting
		
		//Ask how many members for one meeting
		System.out.println("Number of members in the meeting: ");
		System.out.println("(Whole number e.g 2)" );
		int numberOfMembers= getValidInt();
		
		//Creating an array to hold the members of that specific meeting
		Employee[] employeesInTheMeeting= new Employee[numberOfMembers];


		for(int counter=0; counter<employeesInTheMeeting.length; counter++) {
			//Find member
			System.out.println("Enter the username for who you want to add: ");
			String user= getValidString();

			//Find the user name in the binary tree
			Employee member= diaryTree.searchTree(user).getEmployee();

			//Add the employee to the array
			employeesInTheMeeting[counter]= member;
		}

			//Get the date- Day
			System.out.println("Day: ");
			int dateDay=getValidInt();

			//Get the date- Month
			System.out.println("Month: ");
			int dateMonth=getValidInt();
			
			//Get the date- Year
			System.out.println("Year: ");
			int dateYear=getValidInt();

		//Find the meeting times

			//Start timer
			Date timeStarted = new Date();
	
			Set<Float> possibleTimes=loggedIn.findAMeetingTime(employeesInTheMeeting, dateDay);
			//End timer
			long timeTaken= getElapsedTime(timeStarted);
	
			//Display the time taken to find a time
			System.out.println();
			System.out.println("Search Time taken: " +timeTaken);
	
			//Select the time
			if(possibleTimes.isEmpty() == false) {
	
				//Converting the possible times set into an array
				Float[] possibleTimesArray = possibleTimes.toArray(new Float[possibleTimes.size()]);
				//Sorting the array
				Arrays.sort(possibleTimesArray);
	
				//Printing out the possible times
				System.out.println("Possible Meeting Times: ");
				for(int i = 0; i < possibleTimesArray.length; i++) {
					System.out.print((i+1)+") "+possibleTimesArray[i]+"\t \t");
				}
				
				
				//Initialising local variables 
				float time = 0.0f;
				boolean validNumber=false;
				
				do {
					try {
							//Ask user for a time
							System.out.println();
							System.out.println("Select a time: ");
							int selectedTime= getValidInt();
							
							//Get the time the use selected from the array
							time= possibleTimesArray[selectedTime-1];
							validNumber= true;
						}catch(ArrayIndexOutOfBoundsException e) {
							//Error message if the user inputs a value not in the array of possible times
							System.out.println("Error: Enter a number displayed above");
						}
				}while(validNumber != true);
				float endTime= time+duration;


			//Make a new appointment
			Appointment newAppointment= new Appointment(appointmentType, description, time,endTime,dateYear,dateMonth,dateDay);

			//set the busy time for all the employee's
			for(int j=0; j<employeesInTheMeeting.length; j++) {

				//Find the diary for each member
				Diary diaryOfMember= diaryTree.searchTree(employeesInTheMeeting[j].getUsername());

				//Add the appointment to each members diary
				diaryTree.addAppointment(newAppointment, diaryOfMember);

				//Add the 30 minute increments of the meeting into the busy times set for each member
				while(time != endTime){
					boolean isAdded=employeesInTheMeeting[j].addBusyTime(time);
					time+= 0.5;	//Add a half hour
				}

			}
			System.out.println("Appointment made");
			System.out.println();
		}else {
			//Let the user know there are not times available for a meeting
			System.out.println("There are no free times to have a meeting");
		}

	}
	
	/**
	 *  Method that gets a valid float from the user
	 * @return A valid float
	 */
	public float getValidFloat(){
		//Initialising local variables
    	float number= 0.0f;
    	boolean isValid= false;
    	
    	//Keep asking for a float until the number given by the user is valid
    	do {
    		try {
    			//Get the String form the user
    	    	Scanner numberFloatReader= new Scanner(System.in);
    	    	number= numberFloatReader.nextFloat();
    	    	isValid=true;
        	}catch(InputMismatchException e) {
        		//Error message if the user enters a character that is not a float
        		System.out.println();
        		System.out.println("Error: Please enter a Real number");
        	}
    	}while(isValid!=true);
    	
    	//Return the valid float
    	return number;

	}
	
	
	
	/**
	 *  Method that gets a valid String from the user
	 * @return A valid String
	 */
	public String getValidString(){
		//Initialising local variables
    	String text= "";
    	boolean isValid= false;
    	
    	//Keep asking for a String until the text given by the user is valid
    	do {
    		try {
    			//Get the String form the user
    	    	Scanner numberReader= new Scanner(System.in);
    	    	text= numberReader.nextLine();
    	    	isValid=true;
        	}catch(InputMismatchException e) {
        		//Error message if the user enters a mark that is not a String
        		System.out.println();
        		System.out.println("Error: Please enter a string of letter");
        	}
    	}while(isValid!=true);
    	
    	//Return the valid text
    	return text;

	}
	
	
	/**
	 * Method that gets a valid integer from the user
	 * @return A valid integer
	 */
	public int getValidInt(){
		//Initialising local variables
    	int	number = 0;
    	boolean isValid= false;
    	
    	//Keep asking for a number until the number given by the user is valid
    	do {
    		try {
    			//Get the integer form the user
    	    	Scanner numberReader= new Scanner(System.in);
    	    	number= numberReader.nextInt();
    	    	isValid=true;
        	}catch(InputMismatchException e) {
        		//Error message if the user enters a mark that is not a whole number
        		System.out.println();
        		System.out.println("Error: Please enter a whole number");
        	}
    	}while(isValid!=true);
    	
    	//Return a valid mark
    	return number;

	}
	
	/**
	 * Method that prints out the appointments for the user specified
	 */
	public void viewDiary()
	{
		String username = getString("Enter the username of the employee to view their diary: ");
		Diary employeeDiary = getDiaryTree().searchTree(username);
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		System.out.println(employeeDiary.getEmployee().getEmployeeForename() + " " + employeeDiary.getEmployee().getEmployeeSurname() + ":");
		System.out.println();
		diaryTree.sortAppointments(employeeDiary);
		for (int i = 0; i < employeeDiary.getSortedAppointments().length; i++)
		{
			System.out.println("Meeting "+ (i+1));
			System.out.println(employeeDiary.getSortedAppointments()[i].getAppointmentType() + "\n" + employeeDiary.getSortedAppointments()[i].getDescription() + "\n" + employeeDiary.getSortedAppointments()[i].getStartTime() + "\n" + employeeDiary.getSortedAppointments()[i].getEndTime() + "\n" + sdf.format(employeeDiary.getSortedAppointments()[i].getAppointmentDate().getTime()));
			System.out.println();
		}
	}
	
	/**
	 * Method that edits the users appointments
	 */
	public void editAppointment()
	{
		int fieldChoice;
		int appointmentEdit;
		int counter = 1;
		Appointment current = loggedIn.getAppointment();
		
		while (current != null)
		{
			System.out.println("Appointment " + counter);
			System.out.println(current.getAppointmentType() + "\n" + current.getDescription() + "\n" + current.getStartTime() + "\n" + current.getEndTime());
			current = current.getNextAppointment();
			counter += 1;
		}
		do
		{
			fieldChoice = getInt("Enter the number of the field you would like to edit: \n1. Appointment Type \n2. Description \n3. Start time \n4. End time \n5. Date");
			appointmentEdit = getInt("Enter the number of the appointment to edit");
		}
		while (fieldChoice < 1 || fieldChoice > 5 || appointmentEdit < 0 || appointmentEdit > counter);
		
		String fieldInfo = null;
		int year = 0, month = 0, day = 0;
		
		if (fieldChoice < 5)
		{
			fieldInfo = getString("Input the new value of the field");
		}
		else
		{
			year = getInt("Enter the year in the form e.g. 2018");
			month = getInt("Enter the month in the form e.g. 03");
			day = getInt("Enter the day in the form e.g. 26");
		}

		getDiaryTree().editDiaryNode(loggedIn, fieldChoice, appointmentEdit, fieldInfo, year, month, day);
	}
	
	/**
	 * Method that lets the user delete an appointment
	 */

	public void deleteAppointment()
	{
		int counter = 1;
		int appointmentDelete;
		Appointment current = loggedIn.getAppointment();

		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		while (current != null)
		{	
			System.out.println();
			System.out.println("Appointment " + counter);
			System.out.println(current.getAppointmentType() + "\n" + current.getDescription() + "\n" + current.getStartTime()+ "\n" +current.getEndTime()+ "\n" + sdf.format(current.getAppointmentDate().getTime()));
			current = current.getNextAppointment();
			counter += 1;
		}
		do
		{
			System.out.println();
			appointmentDelete = getInt("Enter the number of the appointment to delete: ");
		}
		while (appointmentDelete < 0 || appointmentDelete > counter);
		

		diaryTree.deleteAppointment(appointmentDelete, loggedIn);
		System.out.println("Appointment removed");
		System.out.println();
	}
	/**
     * Uses Scanner to get a new String from the user
     * @param userPrompt the string inputed by the user 
     * @return the string inputed by the user
     */
	 public String getString(String userPrompt)
	    {
	    	Scanner s = new Scanner(System.in);
			System.out.print(userPrompt);
			while (!s.hasNext())
			{
				s.next();
				System.out.print(userPrompt);
			}
			
			return s.next();
	    }
	 
	 /**
	  * Uses Scanner to obtain an integer input
	  * Uses Scanner's hasNextInt() method to check that a valid int
	  * has been inputed. One issue is that lines of text with spaces will
	  * result in unneeded prompts but the program does not crash with invalid input
	  * @param userPrompt the number inputed by the user
	  * @return Returns the number inputed by the user
	  */
	 public int getInt(String userPrompt)
		{
			Scanner s = new Scanner(System.in);
			
			System.out.print(userPrompt);
			while (!s.hasNextInt())
			{
				s.next();
				System.out.print(userPrompt);
			}
			
			int num = s.nextInt();
			return num;
		}

	 
	/**
	 * Method that gets the username
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Method that sets the usersname
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	
	/**
	 * Method that gets the diary tree
	 * @return the diaryTree
	 */
	public DiaryTree getDiaryTree() 
	{
		return diaryTree;
	}

	
	/**
	 * Method that sets the diary tree
	 * @param diaryTree the diaryTree to set
	 */
	public void setDiaryTree(DiaryTree diaryTree) 
	{
		this.diaryTree = diaryTree;
	}

	
	/**
     * Elapsed - calculate the time elapsed since this object was created
     * 
     * @param       The start time
     * @return      time in milliseconds
     */
    public long getElapsedTime(Date timerStarted)
    {
        Date timerEnded = new Date();
        long elapsed= timerEnded.compareTo(timerStarted);
       
        return elapsed;
    }
	
}
