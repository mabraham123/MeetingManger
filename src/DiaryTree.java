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
	
	/**
	 * Will search for a node in the binary tree.
	 * @param employeeUsername This is the username used by the employee to log in.
	 */
	public Diary searchDiaryNode(String employeeUsername)
	{
		//current pointer is set to point tot he root.
		Diary current = root;
		
		//TODO:Implement getUsername method.
		//If the username of the current node is equal to the username entered by the user.
		if(current.getUsername().equals(employeeUsername)) 
		{
			//The current node is returned.
			return current;
		}
		else 
		{
			determineLeftOrRight(employeeUsername);
		}
	}
	
	/**
	 * Will determine if the node is on the left or right of the current branch in the tree.
	 */
	public void determineLeftOrRight(String username) 
	{
		String firstLetter = Character.toString(username.charAt(0));
		
		//If the first letter in the username is a letter that comes before p the current node points left.
		if(firstLetter.equals("a") || firstLetter.equals("b") || firstLetter.equals("c") || firstLetter.equals("d") || firstLetter.equals("e") || firstLetter.equals("f") || firstLetter.equals("g") || firstLetter.equals("h") || firstLetter.equals("i") || firstLetter.equals("j") || firstLetter.equals("k") || firstLetter.equals("l") || firstLetter.equals("m") || firstLetter.equals("n") || firstLetter.equals("o") || firstLetter.equals("p")) 
		{
			//TODO: make getLeft method.
			current = current.getLeft();
		}
	}
}
