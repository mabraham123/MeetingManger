/**
 * 
 */

/**
 * @author DAN
 *
 */
public class DiaryTree {
	private Diary root;

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
	public void searchDiaryNode(int search)
	{
		Diary current = root;
		boolean found = false;
		
		while (current != null && found == false)
		{
			if (current.getEmployee().getID() == search)
			{
				found = true;
				System.out.println(current.getEmployee().getEmployeeForename() + " " + current.getEmployee().getEmployeeSurname()+ ":" + "\n" + current.getAppointment().getAppointmentType() + "\n" + current.getAppointment().getDescription() + "\n" + current.getAppointment().getStartTime() + "\n" + current.getAppointment().getEndTime());
				Appointment currentAppointment = current.getAppointment();
				currentAppointment = currentAppointment.getNextAppointment();
				while (currentAppointment != null)
				{
					//currentAppointment = current.getAppointment().getNextAppointment();
					System.out.println("\n" + currentAppointment.getAppointmentType() + "\n" + currentAppointment.getDescription() + "\n" + currentAppointment.getStartTime() + "\n" + currentAppointment.getEndTime());
					currentAppointment = currentAppointment.getNextAppointment();
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
	public void editDiaryNode(Diary loggedIn, int fieldChoice, int appointmentEdit, String fieldInfo) 
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
	}
	public void addAppointment(String appointmentType, String description, String startTime, String endTime, Diary loggedIn)
	{
		Appointment current = loggedIn.getAppointment();
		Appointment appointmentToAdd = new Appointment(appointmentType, description, startTime, endTime, null);
		
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
		if (appointmentDelete > 1)
		{
			previous.setNextAppointment(appointmentToDelete.getNextAppointment());
		}
		else
		{
			if (appointmentToDelete.getNextAppointment() == null)
			{
				loggedIn.setAppointment(null);
			}
			else
			{
				loggedIn.setAppointment(appointmentToDelete.getNextAppointment());
			}
		}
	}
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
	public Diary getRoot()
	{
		return root;
	}
	public Diary setRoot(Diary root)
	{
		return this.root = root;
	}
}
