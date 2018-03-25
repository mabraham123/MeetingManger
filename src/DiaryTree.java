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
 * @author DAN
 *
 */
public class DiaryTree 
{
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
	 * Adds an employee's diary to the tree which stores their employee info and info about all their appointments
	 * @param diaryToAdd The diary node to be added to the tree
	 */
	/**
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
	 * Will pick a type of a node deletion method and delete a node.
	 * @param username this is the employee's username.
	 */
	public void determineDeletionMethod(String username) 
	{
		//TreeNode is created here to edit the data in the node of the tree.
		Diary pointer = new Diary();
		//The current node is set to the node that needs to be deleted.
		current = searchTree(username);
		/* The if block will test if the current node has either no nodes to the left or right, 
		 * one node to either the left or right, or two nodes connected to it.
		 * 
		 * If Both nodes connected to current node(node being deleted) are empty we know that the node is a leaf.
		 */
		if(current.isLeftEmpty(current) && current.isRightEmpty(current))
		{
			//This method deletes a leaf node.
			deleteLeaf(pointer);
		}
		//If the node to the left of the node being deleted is empty and the right has a connected node the following block runs.
		else if (current.isLeftEmpty(current) && !current.isRightEmpty(current)) 
		{
			deleteRightConnectedNode(pointer);
		}
		//If the node to the right of the node being deleted is empty and the left has a connected node the following block runs.
		else if (!current.isLeftEmpty(current) && current.isRightEmpty(current)) 
		{
			deleteLeftConnectedNode(pointer);
		}
		//The only other option is for the node to have 2 nodes connected to it.
		else 
		{
			deleteDoubleJointedBranch(pointer);
		}
	}
	
	/**
	 * Will delete a leaf node in a tree.
	 * @param pointer Is a pointer to the node above the leaf.
	 */
	public void deleteLeaf(Diary pointer) 
	{
		//The pointer is set to be the previous node.
		pointer = current.getPrevious();
		
		//This if block will delete the reference to the node being deleted.
		if(pointer.getLeft() == current) 
		{
			pointer.setLeft(null);
		}
		else 
		{
			pointer.setRight(null);
		}
		
		//The node is deleted.
		current = null;
	}
	
	/**
	 * Deletes a node which has an empty left reference and a node to it's right.
	 * @param pointer This is a pointer to handle editing the contents of the nodes on the tree.
	 */
	public void deleteRightConnectedNode(Diary pointer) 
	{
		//The pointer is set to point to the node to the right of the node being deleted.
		pointer = current.getRight();
		
		//The pointer will make it's node's previous reference point to the node being deleted's previous node reference.
		pointer.setPrevious(current.getPrevious());
		
		//The pointer is set to the node before the current node.
		pointer = current.getPrevious();
		
		if(pointer.getRight() == current)
		{
			//The node to the right of the pointer is set to be the node that is on the right of the node being deleted.
			pointer.setRight(current.getRight());
		}
		else 
		{
			//The pointer will set the left reference to the node being deleted's right reference.
			pointer.setLeft(current.getRight());
		}
	}
	
	/**
	 * Deletes a node which has an empty right reference and a node to it's left.
	 * @param pointer This is a pointer to handle editing the contents of the nodes on the tree.
	 */
	public void deleteLeftConnectedNode(Diary pointer) 
	{
		//The pointer is set to point to the node to the left of the node being deleted.
		pointer = current.getLeft();
		
		//The pointer will make it's node's previous reference point to the node being deleted's previous node reference.
		pointer.setPrevious(current.getPrevious());
		
		//The pointer is set to the node before the node being deleted.
		pointer = current.getPrevious();
		
		//The node to the left of the pointer is set to be the node that is on the left of the node being deleted.
		pointer.setLeft(current.getLeft());
		
		//The node is deleted.
		current = null;
	}
	
	/**
	 * Will delete a node with a connection to each the left and the right and will clean the tree up to connect it all together once split.
	 * @param pointer This is the node that needs to be moved to fill in the gaps in the tree.
	 */
	public void deleteDoubleJointedBranch(Diary pointer) 
	{
		//A secondary pointer is made to facilitate editing the information stored on the nodes on the tree.
		Diary pointer2 = new Diary();
		
		//The pointer points to the subtree to the left.
		pointer = current.getLeft();
		
		//As long as there is a node to the right of the pointer the pointer will point further right.
		while(!pointer.isRightEmpty(pointer)) 
		{
			pointer = pointer.getRight();
		}
		//A second pointer is introduced here to make the deleting process easier.
		pointer2 = pointer;
		
		//The largest node will be moved to the top and replace the deleted node.
		moveLargestNode(pointer, pointer2);
		
		//Will move the node at the rightmost position on the left subtree to the position occupied by the node being deleted.
		pointer.setPrevious(current.getPrevious());
		
		//Will connect the left and right nodes to the appropriate places.
		connectLeftAndRightToTop(pointer, pointer2);
		
		//Will place the pointer in the node being deleted's location.
		connectToTop(pointer, pointer2);
				
		//The node is deleted here.
		current = null;
	}
	
	/**
	 * This will move the largest node to replace the node being deleted.
	 * @param pointer This is the node that needs to be moved.
	 * @param pointer2 This node is used to edit the information stored on each node.
	 */
	public void moveLargestNode(Diary pointer, Diary pointer2) 
	{
		pointer2 = pointer.getLeft();
		//This code only runs if there is a node to the left of the pointer and the .
		if(pointer.getLeft() != null && pointer2.getRight() != null) 
		{
			//The pointer points to the node on the left and then makes its previous the previous of the node that is being moved.
			pointer2 = pointer2.getLeft();
			pointer2.setPrevious(pointer.getPrevious());
				
			//The pointer points to the node above the node being moved.
			pointer2 = pointer.getPrevious();
			
			//The pointer points to the node to the left of the node being moved.
			pointer2.setRight(pointer.getLeft());
		}
		
		//This code runs only if the node before the pointer is not the "current" node.
		if(pointer.getPrevious() != current)
		{
			//Pointer 2 is set to be the node before the pointer.
			pointer2 = pointer.getPrevious();
			
			//pointer 2's right reference is emptied.
			pointer2.setRight(null);
		}
		//If the node to the right of the node being deleted is not empty this if block will activate.
		else if(current.getRight() != null) 
		{
			//The pointer makes its right reference point to the right reference of the node being deleted.
			pointer.setRight(current.getRight());
			
			//The second pointer becomes the node to the right of the pointer.
			pointer2 = pointer.getRight();
			
			//Pointer 2 has it's previous reference point to the pointer1.
			pointer2.setPrevious(pointer);
		}
	}
	
	/**
	 * Will place the pointer in the node being deleted's location.
	 * @param pointer Node being moved.
	 * @param pointer2 Used to edit information stored in the nodes of the tree.
	 */
	public void connectToTop(Diary pointer, Diary pointer2) 
	{
		//This code runs as long as the node before the current node is not a null value.
		if(current.getPrevious() != null) 
		{
			//Pointer 2 is set to be the node before the current node.
			pointer2 = current.getPrevious();
			
			//The if statement "searches" for the current node and changes the direction reference to point to another node.
			if(pointer2.getRight() == current) 
			{
				pointer2.setRight(pointer);
			}
			else
			{
				pointer2.setLeft(pointer);
			}
		}
		//If the node before the node being deleted is null the root will be changed to the correct node.
		else 
		{
			root = pointer;
		}
	}
	
	/**
	 * Will connect the left and right nodes to the appropriate places.
	 * @param pointer This is the node where links are being made to.
	 * @param pointer2 This will allow data in the nodes in the tree to be edited.
	 */
	public void connectLeftAndRightToTop(Diary pointer, Diary pointer2) 
	{
		//If the pointer is the same node as the node to the left of the node being deleted this branch will run.
		if(pointer == current.getLeft()) 
		{
			//Pointer 2 is set to be the node before the pointer.
			pointer2 = pointer.getPrevious();
			
			//The if block activates only if the ID's of the pointer 2 and node being deleted's ID's are equal.
			if(pointer2.getEmployee().getKey().equals(current.getEmployee().getKey())) 
			{
				//The node to the right of the node being moved is set to point to the node to the right of the node being deleted.
				pointer.setRight(current.getRight());
			}
			
				
			//Pointer 2 will be set to the node to the right of the node being deleted.
			pointer2 = current.getRight();
					
			//Pointer 2 will make the node to the right of the node being deleted's previous reference point to the node being moved to the top.
			pointer2.setPrevious(pointer);
		}
		else 
		{
			//The node to the right of the node being moved is set to point to the node to the right of the node being deleted.
			pointer.setRight(current.getRight());
			
			//The node to the left of the node being moved is set to point to the node to the left of the node being deleted.
			pointer.setLeft(current.getLeft());
					
			//Pointer 2 will be set to the node to the left of the node being deleted.
			pointer2 = current.getLeft();
					
			//Pointer 2 will make the node to the left of the node being deleted's previous reference point to the node being moved to the top.
			pointer2.setPrevious(pointer);
					
			//Pointer 2 will be set to the node to the right of the node being deleted.
			pointer2 = current.getRight();
					
			//Pointer 2 will make the node to the right of the node being deleted's previous reference point to the node being moved to the top.
			pointer2.setPrevious(pointer);
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
