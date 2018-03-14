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
		//TreeNode diaryToAdd = new TreeNode(ID, name, mark, null, null);
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
					System.out.println("The student's ID is already in the tree!");
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
		Appointment currentAppointment = current.getAppointment();
		boolean found = false;
		
		while (current != null && found == false)
		{
			if (current.getEmployee().getID() == search)
			{
				found = true;
				System.out.println(current.getEmployee().getEmployeeName() + ":" + "\n" + current.getAppointment().getAppointmentType() + "\n" + current.getAppointment().getDescription() + "\n" + current.getAppointment().getStartTime() + "\n" + current.getAppointment().getEndTime());
				while (current.getAppointment().getNextAppointment() != null)
				{
					currentAppointment = current.getAppointment().getNextAppointment();
					System.out.println("\n" + currentAppointment.getAppointmentType() + "\n" + currentAppointment.getDescription() + "\n" + currentAppointment.getStartTime() + "\n" + currentAppointment.getEndTime());
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

}
