import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @author DAN
 *
 */
public class Menu 
{
	private DiaryTree diaryTree;
	private Diary loggedIn;
	private String username;
	private static final String Appointmeant = null;
	private Object Appointment;
	private StackNode head;
	private Appointment save = new Appointment();
	private Appointment edit = new Appointment();
	
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
		diaryTree = new DiaryTree();
		//SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		
		int year = 2018;
		int month = 04;
		int day = 28;

		Employee employee1 = new Employee("Daniel", "Scheitler", "Dan" , "pass1", "CEO", 100);
		Appointment appointment1 = new Appointment("Client meeting", "Test description", 900, 1000, null, year, month, day);
		//Undo appendUndo = new Undo (appointment1);
		push(appointment1);
		printList();
		//myList.pop(menu);
		//myList.printList();
		Diary DanielScheitlerDiary = new Diary(employee1, appointment1);
		diaryTree.addDiaryNode(DanielScheitlerDiary);

		
		year = 2018;
		month = 11;
		day = 14;
		
		Employee employee2 = new Employee("Ben", "Franklin", "franku", "pass2", "CTO", 120);
		Appointment appointment2 = new Appointment("Tech meeting", "Test description", 1200, 1300, null, year, month, day);
		Diary BenFranklinDiary = new Diary(employee2, appointment2);
		
		diaryTree.addDiaryNode(BenFranklinDiary);

		
		year = 2018;
		month = 8;
		day = 14;
		
		Employee employee3 = new Employee("George", "Washington", "Washlad", "pass3", "CIO", 110);
		Appointment appointment3 = new Appointment("Information meeting", "Test description", 1600, 1800, null, year, month, day);
		Diary GeorgeWashingtonDiary = new Diary(employee3, appointment3);
		
		diaryTree.addDiaryNode(GeorgeWashingtonDiary);

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
		//String username = input.nextLine();
		
		//TODO: DELETE TEST
		String username = "Dan";
		
		
		//The username will be searched for in the binary tree.

		Diary user = diaryTree.searchTree(username);
		System.out.println();
		//The password will be asked for from the user.
		System.out.print("Password: ");
		//String password = input.nextLine();
		
		//TODO: DELETE TEST
		String password = "pass1";
		
		
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
               case "u":
               case "U":
            	   pop();
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
		Scanner s = new Scanner(System.in);
		String appointmentType = getString("Enter the appointment type");
		String description = getString("Enter the description");
		System.out.println("Enter the start time in the form e.g. 0900");
		float startTime = s.nextFloat();
		System.out.println("Enter the end time in the form e.g. 1200");
		float endTime = s.nextFloat();
		int year = getInt("Enter the year in the form e.g. 2018");
		int month = getInt("Enter the month in the form e.g. 03");
		int day = getInt("Enter the day in the form e.g. 26");
		
		loggedIn.addAppointment(appointmentType, description, startTime, endTime, year, month, day, loggedIn);
		loggedIn.sortAppointments(loggedIn);
		push(Appointment);
	}
	
	public void viewDiary()
	{
		String username = getString("Enter the username of the employee to view their diary");
		Diary employee = getDiaryTree().searchTree(username);
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		System.out.println(employee.getEmployee().getEmployeeForename() + "" + employee.getEmployee().getEmployeeSurname() + ":");
		loggedIn.sortAppointments(employee);
		for (int i = 0; i < employee.getSortedAppointments().length; i++)
		{
			System.out.println(employee.getSortedAppointments()[i].getAppointmentType() + "\n" + employee.getSortedAppointments()[i].getDescription() + "\n" + employee.getSortedAppointments()[i].getStartTime() + "\n" + employee.getSortedAppointments()[i].getEndTime() + "\n" + sdf.format(employee.getSortedAppointments()[i].getAppointmentDate().getTime()));
		}
	}
	
	public void editAppointment()
	{
		int fieldChoice;
		int appointmentEdit;
		int counter = 1;
		
		Appointment current = loggedIn.getAppointment();
		push(this.loggedIn.getAppointment());
		
		
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
		
		edit.setDescription(loggedIn.getAppointment().getDescription());
		edit.setEndTime((loggedIn.getAppointment().getEndTime()));
		edit.setStartTime((loggedIn.getAppointment().getStartTime()));
		edit.setAppointmentType(loggedIn.getAppointment().getAppointmentType());
		edit.setAppointmentDate(loggedIn.getAppointment().getAppointmentDate());
		
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
		diaryTree.editDiaryNode(loggedIn, fieldChoice, appointmentEdit, fieldInfo, year, month, day);
	}
	
	public void deleteAppointment()
	{
		int counter = 1;
		int appointmentDelete;
		Appointment current = loggedIn.getAppointment();
		push(this.loggedIn.getAppointment());
		save = this.loggedIn.getAppointment();
		
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
	public void deleteAppointmentfromStack()
	{
		/**
		 *  The following method is a modified version of the delete appointment method however it allows
		 *  appointments from the Stack class to be deleted without having to manually deleting the appointment via the delete 
		 *  appointment from stack.
		 *  @Parm loggedIn
		 */
		Appointment current = loggedIn.getAppointment();
		Appointment previous = loggedIn.getAppointment();
		
		while (current != null)
		{
			previous = current;
			current = current.getNextAppointment();
		}
		if (previous.getNextAppointment() != null)
		{
			previous.setNextAppointment(null);
		}
		else
		{
			loggedIn.setAppointment(null);
		}
		
	}
	
	 public void Undo(Object appointment)
	    {
	    	Appointment = appointment;
	    }

	    public StackNode getHead()
	    {
	        return head;
	    }
	    
	    public void setHead(StackNode newHead)
	    {
	        head = newHead;
	    }
	    
	    public void push(Object appointment)
	    {
	    	/**
	    	 * This method adds the appointment that were either added or deleted or changed to the stack.
	    	 *  	    	 * 
	    	 */
	    	StackNode  newNode;
	    	newNode = new StackNode(appointment);
	    	newNode.setNext(head);
	    	head = newNode;
	    }
	    
	    public void printList()
	    {
	    /**
	     * This method can be used to check if the appointments are being stored in the stack.
	     */
	    	StackNode marker = null;
	    	marker = head;
	    	while (marker != null)
	    	{
	    		System.out.println(marker.getObject());
	    		marker = marker.getNext();
	    	}
	    }
	    
	    
	    public boolean isStackEmpty()
	    {
	    /**
	    * This method checks if the stack is empty
	    * a number to the Stack
	    */
	    	if (head == null)
	    	{
	    		return true;
	    	}
	    	else 
	    	{
	    		return false;
	    	}
	    }
	    
	
	 	public StackNode pop()
	    {
	 		/**
	    	 * This method removes the appointments from the stack if the Undo button is used.
	    	 * @Parm Undo
	    	 * 
	    	 */
	 		if (this.edit != null)
	 		{
	 			/**
		    	 * This method removes the appointment if undo was invoked and the last change to the appointment was
		    	 * was am edited appointment.
		    	 */	 			
	 			
		 		StackNode temp = null;
		 		Appointment tempoff = null;
		 		
		 		// Stores the modified appointment.
		 		tempoff = this.edit;
		 		
		 		StackNode nodeToPop = null;
		 		
				
			
				if (isStackEmpty()== true) 
				//This check if the Stack is empty
				{
					return null;
				// Only if the stack is empty then it will just return null. And will throw an error.
				}
				else
				//If the stack isn't empty then the undo method will proceed.
				{
					
					if (isStackEmpty() == false)
					{
					
						nodeToPop = head;
						temp = nodeToPop;
						loggedIn.sortAppointments(loggedIn);
						loggedIn.appointment = tempoff;
						edit = null;
						// Remove the current node
						head = head.getNext();
						// Set the previous node to top of the list aka Head
						System.out.println("Removed modified appointment");
						return nodeToPop;
					}
					else  
					{
						return null;
					}
				}
	 		}
	 		
	 		else
	 		{
	 			
	 			if(this.save != null)
	 			{
		 			/**
			    	 * This method removes the appointment if undo was invoked and the last action was
			    	 * an appointment being removed.
			    	 */		
	 				
	 				StackNode temp = null;
	 				StackNode nodeToPop = null;
			
	 				if (isStackEmpty()== true) 
	                //Check if the Stack is empty
	 				{
	 					System.out.println("Error Stack has been Empty @Save" );
	 					return null;
	 				// Only if the stack is empty then it will just return null. And will throw an error.
					}
	 				
	 				else
	 				//If the stack isn't empty then the undo method will proceed.
	 				{			
	 					nodeToPop = head;
						
	 					temp = nodeToPop;
	 					loggedIn.sortAppointments(loggedIn);
	 					// Remove the current node
	 					head = head.getNext();
	 					// Set the previous node to top of the list aka Head
	 					System.out.println("Readded appointment that was deleted");
	 					save = null;
	 					return nodeToPop;
	 			    } 	
	 			}
	 			
	 		else
	 		{
	 		/**
	 		 *  This final option is used if the previous appointment was recently added and wasn't modified or was an appointment that
	 		 *  was deleted.
	 		 */
	 			StackNode nodeToPop = null;
		
	 			if (isStackEmpty()== true) 
	 				//Check if the Stack is empty
	 			{
	 				return null;
	 				// Only if the stack is empty then it will just return null. And will throw an error.
				}
	 				
	 			else
	 			//If the stack isn't empty then the undo method will proceed.
	 			{
	 				if (isStackEmpty() == false)
	 				{
	 			
	 					nodeToPop = head;
					
	 					deleteAppointmentfromStack();
	 					head = head.getNext();
	 					return nodeToPop;
	 				}
					
	 				else 
	 				{
					System.out.println("An error has occured");
					return null;
	 				}
	 			}
	 		}
	 	}
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
	 * 
	 * @return loggedin details.
	 */
	public Diary getLoggedIn() {
		return loggedIn;
	}
	
	
	
	
}
