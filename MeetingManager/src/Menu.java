import java.util.Scanner;

/**
 * 
 */

/**
 * @author DAN
 *
 */
public class Menu {
	private DiaryTree diaryTree;
	private Diary loggedIn;
	private String username;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Menu menu = new Menu();
		
		menu.init();
		menu.login();
        menu.process();
	}
	/**
	 * Instantiates any objects at the start
	 */
	public void init()
	{
		diaryTree = new DiaryTree();
		
		Employee employee1 = new Employee("Daniel", "Scheitler", "pass1", "CEO", 100);
		Appointment appointment1 = new Appointment("Client meeting", "Test description", "0900", "1000", null);
		Diary DanielScheitlerDiary = new Diary(employee1, appointment1);
		
		diaryTree.addDiaryNode(DanielScheitlerDiary);
		
		Employee employee2 = new Employee("Ben", "Franklin", "pass2", "CTO", 120);
		Appointment appointment2 = new Appointment("Tech meeting", "Test description", "1200", "1300", null);
		Diary BenFranklinDiary = new Diary(employee2, appointment2);
		
		diaryTree.addDiaryNode(BenFranklinDiary);
		
		Employee employee3 = new Employee("George", "Washington", "pass3", "CIO", 110);
		Appointment appointment3 = new Appointment("Information meeting", "Test description", "1600", "1800", null);
		Diary GeorgeWashingtonDiary = new Diary(employee3, appointment3);
		
		diaryTree.addDiaryNode(GeorgeWashingtonDiary);
	}
	public void login()
	{
		int ID = getInt("Enter your ID");
		String password = getString("Input your password");
		loggedIn = diaryTree.checkLogin(password, ID);
		
		String forename = loggedIn.getEmployee().getEmployeeForename();
		String surname = loggedIn.getEmployee().getEmployeeSurname();
		char firstLetter = forename.charAt(0);
		
		setUsername(firstLetter + surname);
		System.out.println("Welcome " + getUsername());
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
           System.out.println("Binary Trees Test Menu");
           System.out.println("A - add appointment to diary");
           System.out.println("E - edit appointment in diary");
           System.out.println("P - print appointments of employee");
           System.out.println("F - find meeting times");
           System.out.println("D - delete appointment from diary");
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
            	   editAppointment();
            	break;
               case "P":
               case "p":
            	   viewDiary();
               	break;
               case "F":
               case "f":
            	   //find meeting times
               	break;
               case "D":
               case "d":
            	   //delete appointment
               	break;
               case "S":
               case "s":
            	   //save
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
		//Appointment current = null;
		
		String appointmentType = getString("Enter the appointment type");
		String description = getString("Enter the description");
		String startTime = getString("Enter the start time in the form e.g. 0900");
		String endTime = getString("Enter the end time in the form e.g. 1200");
		
		diaryTree.addAppointment(appointmentType, description, startTime, endTime, loggedIn);
	}
	public void viewDiary()
	{
		int search = getInt("Enter the ID of the employee to view their diary");
		diaryTree.searchDiaryNode(search);
	}
	public void editAppointment()
	{
		int choice;
		do
		{
			choice = getInt("Enter the number of the field you would like to edit: \n1. Appointment Type \n2. Description \n3. Start time \n4. End time");
		}
		while (choice < 1 || choice > 4);
		
		String fieldInfo = getString("Input the new value of the field");
		diaryTree.editDiaryNode(loggedIn, choice, fieldInfo);
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
}
