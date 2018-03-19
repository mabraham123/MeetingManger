import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author DAN
 *
 */
public class DiaryTree {
	private Diary root;
	private Diary current;
	/**
	 * Adds an employee's diary to the tree which stores their employee info and info about all their appointments
	 * @param diaryToAdd The diary node to be added to the tree
	 */
	public void addDiaryNode(Diary diaryToAdd) 
	{
		//Will check to see if the tree is empty.
		boolean	empty = isTreeEmpty();
		
		if (empty)
		{
			//If the tree is empty the new node becomes the root.
			setRoot(diaryToAdd);
		}
		else
		{
			//The current node is set to point to the root reference.
			current = root;
			//This function will place the new node in a relevant position in the tree.
			determineTreePosition(diaryToAdd);
		}
	}
	
	/**
	 * This function will decide where in the tree a new node will be placed and place the node.
	 * @param newNode This is node that is being placed in the tree.
	 */
	public void determineTreePosition(Diary newNode)
	{		
		//The key is retrieved from the employee class and then stored in a big integer.
		String key = newNode.getEmployee().getKey();
		BigInteger newKey = new BigInteger(key);
		
		//The loop repeats until the node is added to the tree.
		boolean notAdded = true;
		while(notAdded) 
		{
			//The key is retrieved from the employee class and then stored in a big integer.
			key = current.getEmployee().getKey();
			BigInteger currentKey = new BigInteger(key);
			
			//The values are compared here to find out which is greater or less than each other.
			int greaterOrLess = currentKey.compareTo(newKey);
			
			//if the current node's key is greater than the new node's key then the node may be placed to the left.
			if(greaterOrLess == 1)
			{
				//The new node will be placed in the left reference only if it is empty otherwise the current reference points to the left.
				if(current.isLeftEmpty(current))
				{
					current.setLeft(newNode);
					newNode.setPrevious(current);
					notAdded = false;
				}
				else 
				{
					current = current.getLeft();
				}	
			}
			else if(greaterOrLess == 0)
			{
				//This will prevent entries with the same ID from existing in the tree.
				System.out.println("ID already in use! Please use a different ID.");
				System.out.println("Returning to menu...");
				notAdded = false;
			}
			else
			{
				//The only other option for the new node to be entered into will be the right and this will do the same task as when the node is being placed in the left branch.
				if(current.isRightEmpty(current))
				{
					current.setRight(newNode);
					newNode.setPrevious(current);
					notAdded = false;
				}
				else 
				{
					current = current.getRight();
				}
			}
		}
	}
	
	/**
	 * This method will check if the tree is empty.
	 * @return empty It tests if the tree is empty.
	 */
	public boolean isTreeEmpty() 
	{
		boolean empty;
		if (root == null) 
		{
			//Will set empty to true if the root is a null value.
			empty = true;
		}
		else 
		{
			//Will set empty to false if the root is not null.
			empty = false;
		}
		return empty;
	}
	
	/**
	 * Adds an employee's diary to the tree which stores their employee info and info about all their appointments
	 * @param diaryToAdd The diary node to be added to the tree
	 */
	/**
	public void addDiaryNode(Diary diaryToAdd) 
	{
		Diary current = root;
		Diary previous = null;

		if (root == null)
		{
			root = diaryToAdd;
		}
		else
		{
			while (current != null)
			{
				previous = current;

				if (diaryToAdd.getEmployee().getID() < current.getEmployee().getID())
				{
					current = current.getLeft();
				}
				else if (diaryToAdd.getEmployee().getID() > current.getEmployee().getID())
				{
					current = current.getRight();
				}
				else if (diaryToAdd.getEmployee().getID() == current.getEmployee().getID())
				{
					System.out.println("The ID is already in the tree!");
					break;
				}
			}

			if (diaryToAdd.getEmployee().getID() < previous.getEmployee().getID())
			{
				diaryToAdd = previous.setLeft(diaryToAdd);
			}
			else if (diaryToAdd.getEmployee().getID() > previous.getEmployee().getID())
			{
				diaryToAdd = previous.setRight(diaryToAdd);
			}
			else
			{
				//exits as already exists
			}
		}
	}
	*/
	/**
	 * Searches for a particular person in the tree and prints their appointment info
	 * @param search The ID to search for
	 */
	public void searchDiaryNode(int search)
	{
		Diary current = root;
		boolean found = false;
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		
		while (current != null && found == false)
		{
			if (current.getEmployee().getID() == search)
			{
				found = true;
				System.out.println(current.getEmployee().getEmployeeForename() + " " + current.getEmployee().getEmployeeSurname()+ ":");
				for (int i = 0; i < current.getSortedAppointments().length; i++)
				{
					System.out.println("\n" + current.getSortedAppointments()[i].getAppointmentType() + "\n" + current.getSortedAppointments()[i].getDescription() + "\n" + current.getSortedAppointments()[i].getStartTime() + "\n" + current.getSortedAppointments()[i].getEndTime() + "\n" + sdf.format(current.getSortedAppointments()[i].getAppointmentDate().getTime()));
				}
			}
			else if (search < current.getEmployee().getID())
			{
				current = current.getLeft();
			}
			else if (search > current.getEmployee().getID())
			{
				current = current.getRight();
			}
			
		}
	}
	/**
	 * Searches for a particular person in the tree and prints their appointment info
	 * @param search The ID to search for
	 */
	/**
	public Diary searchDiaryNode(String username)
	{
		//Pointer is set to the root.
		current = root;
		
		//Boolean value to determine whether the node has been found.
		boolean found = false;
		
		//A simple date format object is created here.
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy"); 
		
		//Code loops as long as the node is not empty and the node being searched for has not been found.
		while (current != null && found == false)
		{
			//The first letter of the username is obtained here.
			char firstCharForUsername = 
			
			if (current.getEmployee().getUsername().equals(username))
			{
				//The found value has been set to true.
				found = true;
			}
			else if (search < current.getEmployee().getID())
			{
				current = current.getLeft();
			}
			else if (search > current.getEmployee().getID())
			{
				current = current.getRight();
			}
			
		}
		return current;
	}
	*/
	/**
	 * Edits a field of the chosen appointment in the diary of the logged on user 
	 * @param loggedIn The user who is current logged in and the diary to be edited
	 * @param fieldChoice The info to be changed
	 * @param appointmentEdit Which appointment to edit
	 * @param fieldInfo The new info to replace old
	 * @param day 
	 * @param month 
	 * @param year 
	 */
	public void editDiaryNode(Diary loggedIn, int fieldChoice, int appointmentEdit, String fieldInfo, int year, int month, int day) 
	{
		Appointment appointmentToEdit = loggedIn.getAppointment();
		
		for (int i = 0; i < appointmentEdit-1; i++)
		{
			appointmentToEdit = appointmentToEdit.getNextAppointment();
		}
		
		if (fieldChoice == 1)
		{
			appointmentToEdit.setAppointmentType(fieldInfo);
		}
		else if (fieldChoice == 2)
		{
			appointmentToEdit.setDescription(fieldInfo);
		}
		else if (fieldChoice == 3)
		{
			appointmentToEdit.setStartTime(fieldInfo);
		}
		else if (fieldChoice == 4)
		{
			appointmentToEdit.setEndTime(fieldInfo);
		}
		else if (fieldChoice == 5)
		{
			appointmentToEdit.setAppointmentDate(year, month, day);
		}
	}
	/**
	 * Adds an appointment to the diary of the logged in user
	 * @param appointmentType Type of appointment
	 * @param description Description of appointment
	 * @param startTime Start time of appointment
	 * @param endTime End time of appointment
	 * @param year Year of appointment
	 * @param month Month of appointment
	 * @param day Day of appointment
	 * @param loggedIn The diary to be added to
	 */
	public void addAppointment(String appointmentType, String description, String startTime, String endTime, int year, int month, int day, Diary loggedIn)
	{
		Appointment current = loggedIn.getAppointment();
		Appointment appointmentToAdd = new Appointment(appointmentType, description, startTime, endTime, null, year, month, day);
		
		if (loggedIn.getAppointment() == null)
		{
			loggedIn.setAppointment(appointmentToAdd);
		}
		else
		{
			while (current.getNextAppointment() != null)
			{
				current = current.getNextAppointment();
			}
			current.setNextAppointment(appointmentToAdd);
			//loggedIn = current;
		}
	}
	/**
	 * Deletes an appointment from the diary
	 * @param appointmentDelete The appointment to be deleted
	 * @param loggedIn The logged on user's diary entry to be deleted
	 */
	public void deleteAppointment(int appointmentDelete, Diary loggedIn)
	{
		Appointment appointmentToDelete = loggedIn.getAppointment();
		Appointment previous = appointmentToDelete;
		
		for (int i = 0; i < appointmentDelete-1; i++)
		{
			previous = appointmentToDelete;
			appointmentToDelete = appointmentToDelete.getNextAppointment();
		}
		
		//appointmentToDelete = appointmentToDelete.getNextAppointment();
		previous.setNextAppointment(appointmentToDelete.getNextAppointment());
	}
	/**
	 * Checks that the login details match the ones stored
	 * @param password The password of the user
	 * @param ID The ID of the user
	 * @return current The diary of the logged on user
	 */
	public Diary checkLogin(String password, int ID)
	{
		Diary current = root;
		boolean found = false;
		
		while (current != null && found == false)
		{
			/**
			if (current.getEmployee().getID() == ID && current.getEmployee().getPassword() == password)
			{
				found = true;
			}
			*/
			if (ID == current.getEmployee().getID())
			{
				if (password.equals(current.getEmployee().getPassword()))
				{
					found = true;
				}
				else
				{
					System.out.println("Incorrect password");
					return null;
				}
			}
			else if (ID < current.getEmployee().getID())
			{
				current = current.getLeft();
			}
			else if (ID > current.getEmployee().getID())
			{
				current = current.getRight();
			}
		}
		return current;
	}
	public void sortAppointments(Diary loggedIn)
	{
		ArrayList<Appointment> arrayList = new ArrayList<Appointment>();
		Appointment current = loggedIn.getAppointment();
		Appointment temp = null;
		
		while (current != null)
		{
			arrayList.add(current);
			current = current.getNextAppointment();
		}
		Appointment[] sortedArray = new Appointment[arrayList.size()];
		
		current = loggedIn.getAppointment();
		for (int p = 0; p < sortedArray.length; p++)
		{
			sortedArray[p] = current;
			current = current.getNextAppointment();
		}
		
		for (int i = 0; i < sortedArray.length - 1; i++)
		{
			for (int j = 0; j < (sortedArray.length - i - 1); j++)
			{
				if (sortedArray[j].getAppointmentDate().after(sortedArray[j+1].getAppointmentDate()))
				{
					temp = sortedArray[j];  
					sortedArray[j] = sortedArray[j+1];  
					sortedArray[j+1] = temp; 
				}
			}
		}
		loggedIn.setSortedAppointments(sortedArray);
	}
	
	/**
	 * Gets the root of the tree
	 * @return root The root of the tree
	 */
	public Diary getRoot()
	{
		return root;
	}
	/**
	 * Sets the root of the tree
	 * @param root The root of the tree
	 * @return root The root of the tree
	 */
	public Diary setRoot(Diary root)
	{
		return this.root = root;
	}
}
