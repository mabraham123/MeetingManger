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
 * @author Melvin Abraham
 * @author Aditya Kumar Menon
 * @author Daniel Scheitler
 * 
 * The diary tree is a binary tree which holds each of the diary nodes.
 */
public class DiaryTree 
{
	//The root and current nodes are defined here.
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
     * Method to find a node with the id in the tree
     * @param idNumber	The id you want to find
     * @return	The node with that id number
     */
    public Diary searchTree(String username)
    {
    	//Start of the tree
    	Diary current=root;
    	Diary toFind = new Diary();
    	
    	//Variable will check if the diary node has been found.
    	boolean found=false;
    	
    	//The username is converted into a key and then stored in a big integer to allow comparisons to be made.
    	BigInteger userID = new BigInteger(toFind.convertToKey(username));
    	
    	
    	//while the current node is not null and the node being searched for has not been found.
    	while(current != null && found !=true) 
    	{
    		//The key is retrieved from the current node's employee. 
			String key = current.getEmployee().getKey();
			//The key is stored as a biginteger.
			BigInteger currentKey = new BigInteger(key);
			//will test if the current key is greater or less than the userID.
			int greaterOrLess = userID.compareTo(currentKey);
			
    		//Travel down the binary tree till the employee is found
    		if(greaterOrLess == 0) 
    		{
    			found=true;
    		}
    		else 
    		{
    			//if the id is smaller than the current nodes id
    			if(greaterOrLess< 0) 
    			{
    				//set current to the left node
    				current= current.getLeft();
    			}
    			else if(greaterOrLess > 0) 
    			{
    				//set current to the right node
    				current= current.getRight();
    			}
    		}
    	}
    	
    	//If the id was found in the tree send the node
    	if(found==true) 
    	{
    		return current;
    	}
    	else 
    	{
    		noUserFoundMessage();
    		//return null if the node was not found
    		return null;
    	}
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
	 * @param loggedIn The user who is currently logged in and the diary to be edited
	 * @param fieldChoice The info to be changed
	 * @param appointmentEdit Which appointment to edit
	 * @param fieldInfo The new info to replace old
	 * @param day The day the meeting will be held.
	 * @param month The month the meeting will be held.
	 * @param year The year the meeting will be held.
	 */
	public void editDiaryNode(Diary loggedIn, int fieldChoice, int appointmentEdit, String fieldInfo, int year, int month, int day) 
	{
		//TODO: Add comment
		Appointment appointmentToEdit = loggedIn.getAppointment();
		
		//TODO: Add comment
		for (int i = 0; i < appointmentEdit-1; i++)
		{
			//TODO: Add comment?
			appointmentToEdit = appointmentToEdit.getNextAppointment();
		}
		
		//if the field chosen is the appointment type, the input field will be set as the appointment type.
		if (fieldChoice == 1)
		{
			appointmentToEdit.setAppointmentType(fieldInfo);
		}
		//if the field chosen is the description, the input field will be set as the description.
		else if (fieldChoice == 2)
		{
			appointmentToEdit.setDescription(fieldInfo);
		}
		//if the field chosen is the start time, the input field will be set as the start time.
		else if (fieldChoice == 3)
		{
			appointmentToEdit.setStartTime(Float.parseFloat(fieldInfo));
		}
		//if the field chosen is the end time, the input field will be set as the end time.
		else if (fieldChoice == 4)
		{
			appointmentToEdit.setEndTime(Float.parseFloat(fieldInfo));
		}
		//if the field chosen is the date, the input field will be set as the date.
		else if (fieldChoice == 5)
		{
			appointmentToEdit.setAppointmentDate(year, month, day);
		}
	}
	
	/**
	 * Method to add an Appointment to the employee's diary
	 * @param appointmentToAdd	The node that contains the appointment object
	 * @param diaryToAdd	The employee's diary
	 */
	public void addAppointment(Appointment appointmentToAdd, Diary diaryToAdd)
	{
		//The current appointment is set to the first appointment in the diary
		Appointment current = diaryToAdd.getAppointment();
		
		//If there are no appointments in the diary.
		if (diaryToAdd.getAppointment() == null)
		{
			//Add the appointment to the diary.
			diaryToAdd.setAppointment(appointmentToAdd);
		}
		else
		{
			//While there is an appointment in the diary.
			while (current.getNextAppointment() != null)
			{
				//The current appointment is switched to the next appointment.
				current = current.getNextAppointment();
			}
			
			//The next appointment is set to be the input appointment.
			current.setNextAppointment(appointmentToAdd);
		}
	}
	
	/**
	 * Deletes an appointment from the diary
	 * @param appointmentDelete The appointment to be deleted
	 * @param loggedIn The logged on user's diary entry to be deleted
	 */
	public void deleteAppointment(int appointmentDelete, Diary loggedIn)
	{
		//The appointment to delete is set to the appointment in the logged in user's diary.
		Appointment appointmentToDelete = loggedIn.getAppointment();
		//The previous appointment is set to the same appointment as appointmentToDelete.
		Appointment previous = appointmentToDelete;
		
		//TODO: Add comment
		for (int i = 0; i < appointmentDelete-1; i++)
		{
			//TODO: Add comment
			previous = appointmentToDelete;
			appointmentToDelete = appointmentToDelete.getNextAppointment();
		}

		//TODO: Add comment
		if (previous != appointmentToDelete.getNextAppointment())
		{
			previous.setNextAppointment(appointmentToDelete.getNextAppointment());
		}
		//TODO: Add comment
		else
		{
			loggedIn.setAppointment(null);
		}
	}
	
	/**
	 * Will sort the appointments in order from the earliest to the latest.
	 * @param loggedIn
	 */
	public void sortAppointments(Diary loggedIn)
	{
		//An arraylist of appoinments is initialised.
		ArrayList<Appointment> arrayList = new ArrayList<Appointment>();
		//The current appointment is set to the first appoinment in the logged in user's diary.
		Appointment current = loggedIn.getAppointment();
		//A temporary appointment is defined as null.
		Appointment temp = null;
		
		//While the current appointment is not empty.
		while (current != null)
		{
			//add the current appointment to the array list.
			arrayList.add(current);
			//set current to be the next appointment.
			current = current.getNextAppointment();
		}
		//An array of appointments is made and made as large as the arrayList.
		Appointment[] sortedArray = new Appointment[arrayList.size()];
		
		//The current appointment is set to be the first appointment of the logged in user's.
		current = loggedIn.getAppointment();
		//TODO: Add comment
		for (int p = 0; p < sortedArray.length; p++)
		{
			//TODO: Add comment
			sortedArray[p] = current;
			current = current.getNextAppointment();
		}
		//TODO: Add comment
		for (int i = 0; i < sortedArray.length - 1; i++)
		{
			//TODO: Add comment
			for (int j = 0; j < (sortedArray.length - i - 1); j++)
			{
				//TODO: Add comment
				if (sortedArray[j].getAppointmentDate().after(sortedArray[j+1].getAppointmentDate()))
				{
					//TODO: Add comment
					temp = sortedArray[j];  
					sortedArray[j] = sortedArray[j+1];  
					sortedArray[j+1] = temp; 
				}
			}
		}
		//TODO: Add comment
		loggedIn.setSortedAppointments(sortedArray);
	}
	
	/**
	 * This method handles the file operations of the save feature and calls the second part of the method so that no data is lost
	 * @param nodeToTraverse The node currently being explored
	 */
	public void writeFile(Diary nodeToTraverse)
	{
	    //The file output stream and the print writer are defined here.
		FileOutputStream outputStream = null;
	    PrintWriter printWriter = null;

	    try
	    {
	    	//The outputstream will save output to save.txt
	    	outputStream = new FileOutputStream("save.txt");
	    	//The print writer is set as the output stream.
	    	printWriter = new PrintWriter(outputStream); 
	    	
	    	//TODO: Add comment
	    	write(nodeToTraverse, printWriter);
	    	
	    	//TODO: Add comment
	    	printWriter.flush();
	    }
	    catch(IOException e)
	    {
	    	System.out.println("There has been a problem opening or writing to the file");
	    }
	    finally
	    {
	    	//The print writer is closed to prevent memory leaks.
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
		//TODO: Add comment
		//A simple date format object is created.
		SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
		//if the input diary node is not empty
		if (nodeToTraverse != null)
		{
			//TODO: Add comment
			Appointment AppointmentToTraverse = nodeToTraverse.getAppointment();
			//TODO: Add comment
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
			
			//TODO: Add comment
			AppointmentToTraverse = AppointmentToTraverse.getNextAppointment();
			
			//while the appointment to traverse is not empty.
			while (AppointmentToTraverse != null)
			{
				//TODO: Add comment
				printWriter.println(AppointmentToTraverse.getAppointmentType());
				printWriter.println(AppointmentToTraverse.getDescription());
				printWriter.println(AppointmentToTraverse.getStartTime());
				printWriter.println(AppointmentToTraverse.getEndTime());
				printWriter.println(sdf.format(AppointmentToTraverse.getAppointmentDate().getTime()));
				AppointmentToTraverse = AppointmentToTraverse.getNextAppointment();
			}
			//TODO: Add comment
			printWriter.println("---");
			//TODO: Add comment
			write(nodeToTraverse.getLeft(), printWriter);
			write(nodeToTraverse.getRight(), printWriter); 
		}
	}
	
	//TODO: Add comment
	/**
	 * 
	 * @param readCounter
	 */
	public void loadTree(int readCounter)
	{
		//TODO: Add comment
		int counter = readCounter;
		//TODO: Add comment
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String nextLine = null;
		Employee employeeToAdd = null;
		Appointment appointmentToAdd = null;
		//An empty arraylist of appointments is initialized here
		ArrayList<Appointment> listOfAppointments = new ArrayList<Appointment>();
		try
		{
			//The file reader will read text from save.txt
			fileReader = new FileReader("save.txt");
			//The buffered reader will read from the file reader.
			bufferedReader = new BufferedReader(fileReader);
			//TODO: Add comment
			if (counter > 0)
			{
				//TODO: Add comment
				for (int j = 0; j < counter+1; j++)
				{
					//TODO: Add comment
					nextLine = bufferedReader.readLine();
				}
			}
			//TODO: Add comment
			else
			{
				nextLine = bufferedReader.readLine();
			}
			
			//while the next line is not "---" 
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
				nextLine = bufferedReader.readLine();
				float startDay = Float.parseFloat(nextLine); //sixth line is start of day
				nextLine = bufferedReader.readLine();
				float endDay = Float.parseFloat(nextLine); //seventh line is start of day
				
				employeeToAdd = new Employee(forename, surname, username, password, jobPosition, startDay, endDay);
				nextLine = bufferedReader.readLine(); //required as there will be infinite loop otherwise
			}
			nextLine = bufferedReader.readLine();
			counter = counter + 8;
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
				
				appointmentToAdd = new Appointment(type, desc, start, end, year, month, day);


				
				listOfAppointments.add(appointmentToAdd);
				//add the busy times to the busy set
				
				//Add the 30 minute increments of the meeting into the busy times set for each member
				float currentTime = start;
				
				while(currentTime != end){
					boolean isAdded=employeeToAdd.addBusyTime(currentTime);
					currentTime+= 0.5;	//Add a half hour
				}
				
				
				
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
