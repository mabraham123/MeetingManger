import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.Date;


/**
 * @author Melvin Abraham
 *
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
		//SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		/**
		int year = 2018;
		int month = 04;
		int day = 28;
		
		Employee employee1 = new Employee("Daniel", "Scheitler", "Dan" , "pass1", "CEO");
		Appointment appointment1 = new Appointment("Client meeting", "Test description", 900, 1000, null, year, month, day);
		Diary DanielScheitlerDiary = new Diary(employee1, appointment1);
		
		getDiaryTree().addDiaryNode(DanielScheitlerDiary);

		
		year = 2018;
		month = 11;
		day = 14;
		
		Employee employee2 = new Employee("Ben", "Franklin", "franku", "pass2", "CTO");
		Appointment appointment2 = new Appointment("Tech meeting", "Test description", 1200, 1300, null, year, month, day);
		Diary BenFranklinDiary = new Diary(employee2, appointment2);
		
		getDiaryTree().addDiaryNode(BenFranklinDiary);

		
		year = 2018;
		month = 8;
		day = 14;
		
		Employee employee3 = new Employee("George", "Washington", "Washlad", "pass3", "CIO");
		Appointment appointment3 = new Appointment("Information meeting", "Test description", 1600, 1800, null, year, month, day);
		Diary GeorgeWashingtonDiary = new Diary(employee3, appointment3);
		
		getDiaryTree().addDiaryNode(GeorgeWashingtonDiary);
		*/
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
	 * Runs the menu
	 */
	public void process()
   {
		// Run our test Menu
		runTestMenu();
   }
	/**
	 * The menu that runs and the user can input letters to run methods of the program
	 */
	public void runTestMenu()
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
			System.out.println("F - find meeting times");
			System.out.println("S - Save binary tree");
			System.out.println("L - Load binary tree");
			System.out.println("Q - quit");        

			choice=getString("Please make a choice, and press ENTER: ");

			switch (choice)
			{
			case "A":
			case "a":
				addAppointment();
				break;
			case "E":
			case "e":
				if (loggedIn.getAppointment() != null)
				{
					editAppointment();
				}
				else
				{
					System.out.println("You must first add an appointment!");
				}
				break;
			case "P":
			case "p":
				viewDiary();
				break;
			case "D":
			case "d":
				if (loggedIn.getAppointment() != null)
				{
					deleteAppointment();
				}
				else
				{
					System.out.println("You must first add an appointment!");
				}
				break;
			case "F":
			case "f":
				//find meeting times
				break;
			case "S":
			case "s":
				//save
				diaryTree.writeFile(diaryTree.getRoot());
				break;
			case "L":
			case "l":    
				//load
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
   }
	public void addAppointment() 
	{		
		//Get the appointment type
		Scanner appointmentTypeReader= new Scanner(System.in);
		System.out.println("Appointment Type: ");
		String appointmentType= appointmentTypeReader.nextLine();

		//Get the description
		Scanner descriptionReader= new Scanner(System.in);
		System.out.println("Description: ");
		String description= descriptionReader.nextLine();


		//Get the duration
		Scanner durationReader= new Scanner(System.in);
		System.out.println("Duration: ");
		System.out.println("(Hours e.g 1.5)" );
		float duration= durationReader.nextFloat();




		//Get the members of the meeting
		//Ask how many members for one meeting
		Scanner numberOfMembersReader= new Scanner(System.in);
		System.out.println("Number of members in the meeting: ");
		System.out.println("(Whole number e.g 2)" );
		int numberOfMembers= numberOfMembersReader.nextInt();

		Employee[] employeesInTheMeeting= new Employee[numberOfMembers];


		for(int counter=0; counter<employeesInTheMeeting.length; counter++) {
			//Find member
			Scanner usernameReader= new Scanner(System.in);
			System.out.println("Enter the username for who you want to add: ");
			String user= usernameReader.nextLine();

			//Find the user name in the binary tree
			Employee member= diaryTree.searchTree(user).getEmployee();

			//Add to array
			employeesInTheMeeting[counter]= member;
		}


		//Get the date- Day
		Scanner dateDayReader= new Scanner(System.in);
		System.out.println("Day: ");
		int dateDay=dateDayReader.nextInt();

		//Get the date- Month
		Scanner dateMonthReader= new Scanner(System.in);
		System.out.println("Month: ");
		int dateMonth=dateMonthReader.nextInt();

		//Get the date- Year
		Scanner dateYearReader= new Scanner(System.in);
		System.out.println("Year: ");
		int dateYear=dateYearReader.nextInt();


		//Find the meeting times

		//Start timer
		Date timeStarted = new Date();

		Set<Float> possibleTimes=loggedIn.findAMeetingTime(employeesInTheMeeting, dateDay);
		//End timer
		long timeTaken= getElapsedTime(timeStarted);

		//Display the time taken to find a time
		System.out.println();
		System.out.println(timeTaken);

		//Select the time
		if(possibleTimes.isEmpty() == false) {

			//Converting the possible times set into an array
			Float[] possibleTimesArray = possibleTimes.toArray(new Float[possibleTimes.size()]);
			//Sorting the array
			Arrays.sort(possibleTimesArray);

			//Printing out the possible times
			System.out.println("Possible Meeting Times: ");
			for(int i = 0; i < possibleTimesArray.length; i++) {
				System.out.print(possibleTimesArray[i]+"\t");
			}

			//Ask user for a time
			Scanner meetingReader= new Scanner(System.in);
			System.out.println();
			System.out.println("Select a time: ");
			float time= meetingReader.nextFloat();

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
		}else {
			//Let the user know there are not times available for a meeting
			System.out.println("There are no free times to have a meeting");
		}

	}
	
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
	
	public void deleteAppointment()
	{
		int counter = 1;
		int appointmentDelete;
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
			appointmentDelete = getInt("Enter the number of the appointment to delete");
		}
		while (appointmentDelete < 0 || appointmentDelete > counter);
		


		diaryTree.deleteAppointment(appointmentDelete, loggedIn);
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
	 * @return the diaryTree
	 */
	public DiaryTree getDiaryTree() 
	{
		return diaryTree;
	}
	/**
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
