import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
	 * Will search the binary tree for a specific node and return it.
	 * @param username This is the username being searched for within the tree.
	 * @return current This will be the diary node with the same username as the initial parameter.
	 */
	public Diary searchTree(String username) 
	{
		//The current node pointer is set to reference to the root.
		current = root;
		//The username is converted into a key and then stored in a big integer to allow comparisons to be made.
		BigInteger userID = new BigInteger(current.convertToKey(username));
		//The found field will check if the diary node has been found.
		boolean found = false;
		
		//The loop continues as long as exitloop is false.
		boolean exitLoop = false;
		while (exitLoop == false) 
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
					//The diary node has been found so found is set to true.
					found = true;
					exitLoop = true;
				}
			}
		}
		
		//If the diary node has not been found the current node will be set to null.
		if(found == false) 
		{
			current = null;
		}
		
		return current;
	}
	/**
	 * Will inform the user that the username cannot be found.
	 */
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
			appointmentToEdit.setStartTime(Float.parseFloat(fieldInfo));
		}
		else if (fieldChoice == 4)
		{
			appointmentToEdit.setEndTime(Float.parseFloat(fieldInfo));
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
	public void addAppointment(String appointmentType, String description, float startTime, float endTime, int year, int month, int day, Diary loggedIn)
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
	public void addAppointment(Appointment appointmentToAdd, Diary diaryToAdd)
	{
		Appointment current = diaryToAdd.getAppointment();
		
		if (diaryToAdd.getAppointment() == null)
		{
			diaryToAdd.setAppointment(appointmentToAdd);
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
		if (previous != appointmentToDelete.getNextAppointment())
		{
			previous.setNextAppointment(appointmentToDelete.getNextAppointment());
		}
		else
		{
			loggedIn.setAppointment(null);
		}
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
	 * This method handles the file operations of the save feature and calls the second part of the method so that no data is lost
	 * @param nodeToTraverse The node currently being explored
	 */
	public void writeFile(Diary nodeToTraverse)
	{
	    FileOutputStream outputStream = null;
	    PrintWriter printWriter = null;

	    try
	    {
	        outputStream = new FileOutputStream("save.txt");
	        printWriter = new PrintWriter(outputStream); 

	        write(nodeToTraverse, printWriter);

	        printWriter.flush();

	    }
	    catch(IOException e)
	    {
	    	System.out.println("There has been a problem opening or writing to the file");
	    }
	    finally
	    {
	    	printWriter.close();
	    	System.out.println("Binary tree has been saved successfully!");
	    }
	   
	}
	/**
	 * Does the traversal aspect of the save feature by PREORDER means
	 * @param nodeToTraverse The node currently being explored
	 * @param printWriter The object that writes data to the text file
	 */
	public void write(Diary nodeToTraverse, PrintWriter printWriter)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		if (nodeToTraverse != null)
		{
			Appointment AppointmentToTraverse = nodeToTraverse.getAppointment();
			
			printWriter.println(nodeToTraverse.getEmployee().getEmployeeForename());
			printWriter.println(nodeToTraverse.getEmployee().getEmployeeSurname());
			printWriter.println(nodeToTraverse.getEmployee().getJobPosition());
			printWriter.println(nodeToTraverse.getEmployee().getUsername());
			printWriter.println(nodeToTraverse.getEmployee().getPassword());
			printWriter.println("---");
			printWriter.println(AppointmentToTraverse.getAppointmentType());
			printWriter.println(AppointmentToTraverse.getDescription());
			printWriter.println(AppointmentToTraverse.getStartTime());
			printWriter.println(AppointmentToTraverse.getEndTime());
			printWriter.println(sdf.format(AppointmentToTraverse.getAppointmentDate().getTime()));
			
			AppointmentToTraverse = AppointmentToTraverse.getNextAppointment();
			
			while (AppointmentToTraverse != null)
			{
				printWriter.println(AppointmentToTraverse.getAppointmentType());
				printWriter.println(AppointmentToTraverse.getDescription());
				printWriter.println(AppointmentToTraverse.getStartTime());
				printWriter.println(AppointmentToTraverse.getEndTime());
				printWriter.println(sdf.format(AppointmentToTraverse.getAppointmentDate().getTime()));
				AppointmentToTraverse = AppointmentToTraverse.getNextAppointment();
			}
			printWriter.println("---");
			write(nodeToTraverse.getLeft(), printWriter);
			write(nodeToTraverse.getRight(), printWriter); 

		}
	}
	public void loadTree(int readCounter)
	{
		int counter = readCounter;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String nextLine = null;
		Employee employeeToAdd = null;
		Appointment appointmentToAdd = null;
		ArrayList<Appointment> listOfAppointments = new ArrayList<Appointment>();
		try
		{
			fileReader = new FileReader("save.txt");
			bufferedReader = new BufferedReader(fileReader);
			if (counter > 0)
			{
				for (int j = 0; j < counter+1; j++)
				{
					nextLine = bufferedReader.readLine();
				}
			}
			else
			{
				nextLine = bufferedReader.readLine();
			}
			while (nextLine.equals("---") == false) 
			{
				String forename = nextLine; //first line is forename
				nextLine = bufferedReader.readLine();
				String surname = nextLine; //second line is surname
				nextLine = bufferedReader.readLine();
				String jobPosition = nextLine; //third line is job position
				nextLine = bufferedReader.readLine();
				String username = nextLine; //fourth line is username
				nextLine = bufferedReader.readLine();
				String password = nextLine; //fifth line is password
				
				employeeToAdd = new Employee(forename, surname, username, password, jobPosition);
				nextLine = bufferedReader.readLine(); //required as there will be infinite loop otherwise
			}
			nextLine = bufferedReader.readLine();
			counter = counter + 6;
			while (nextLine.equals("---") == false)
			{
				int year, month, day;
				String type = nextLine; //first line is appointment type
				nextLine = bufferedReader.readLine();
				String desc = nextLine; //second line is description
				nextLine = bufferedReader.readLine();
				float start = Float.parseFloat(nextLine); //third line is start time
				nextLine = bufferedReader.readLine();
				float end = Float.parseFloat(nextLine); //fourth line is start time
				nextLine = bufferedReader.readLine();
				String time[] = nextLine.split("\\s+"); //splits date into 3
				day = Integer.parseInt(time[0]); //first part is day
				month = Integer.parseInt(time[1]); //second part is day
				year = Integer.parseInt(time[2]); //third part is day
				
				appointmentToAdd = new Appointment(type, desc, start, end, null, year, month, day);
				listOfAppointments.add(appointmentToAdd);
				
				nextLine = bufferedReader.readLine(); //required as there will be infinite loop otherwise
				counter = counter + 5;
			}
			Diary diaryToAdd = new Diary(employeeToAdd, null);
			addDiaryNode(diaryToAdd); //add diary to tree
			
			Appointment[] appointmentArray = new Appointment[listOfAppointments.size()];
			
			for (int i = 0; i < appointmentArray.length; i++)
			{
				appointmentArray[i] = listOfAppointments.get(i);
				addAppointment(appointmentArray[i], diaryToAdd); //add appointments to diary
			}
			nextLine = bufferedReader.readLine();
			counter = counter + 1;
			if (nextLine != null)
			{
				loadTree(counter); //read in the other diaries too passing over already read lines
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("There has been a error in locating the file");
		}
		catch (IOException e)
		{
			System.out.println("There has been a problem opening or reading from the file");
		}
		finally
		{
			if (bufferedReader != null)
			{
				try
				{
					bufferedReader.close();    
				}
				catch (IOException e)
				{
					System.out.println("An error occurred when attempting to close the file");
				}
			}
			System.out.println("Diary loaded successfully!");
		}
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
