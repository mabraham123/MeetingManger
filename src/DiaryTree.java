import java.text.SimpleDateFormat;
import java.math.BigInteger;

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
	 * Will search the binary tree for a specific node and return it.
	 * @param username This is the username being searched for within the tree.
	 * @return current This will be the diary node with the same username as the initial parameter.
	 */
	Diary searchTree(String username) 
	{
		//The current node pointer is set to reference to the root.
		current = root;
		//The username is converted into a key and then stored in a big integer to allow comparisons to be made.
		BigInteger userID = new BigInteger(current.convertToKey(username));
		//The loop continues as long as exitloop is false.
		boolean exitLoop = false;
		while (!exitLoop) 
		{
			//If the current node is not a null value
			if(current != null) 
			{	
				//The key is retrieved from the current node's employee. 
				String key = current.getEmployee().getKey();
				//The key is stored as a biginteger.
				BigInteger currentKey = new BigInteger(key);
				//will test if the current key is greater or less than the userID.
				int greaterOrLess = currentKey.compareTo(userID);
				//If the userID is less than the current ID-the current reference will point to the node on the left.
				if(greaterOrLess == 1) 
				{
					if(current.isLeftEmpty(current)) 
					{
						//Since there is no more nodes to the left therefore the user does not exist.
						noUserFoundMessage();
						exitLoop = true; 
					}
					else 
					{
						current = current.getLeft();
					}
				}
				//If the UserID is more than the current key the current reference will point to the node on the right.
				else if (greaterOrLess == -1) 
				{
					if(current.isRightEmpty(current))
					{
						//Since there is no more nodes to the right therefore the user does not exist.
						noUserFoundMessage();
						exitLoop = true;
					}
					else
					{
						current = current.getRight();
					}
				}
				else
				{
					//The userID and the current key are equal therefore the current node will be returned.
					return current;
				}
			}
		}
	}
	
	public void noUserFoundMessage() 
	{
		System.out.println("Username does not exist");
	}
	
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
	 * 
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
		current = root;
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