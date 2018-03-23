import java.util.Scanner;
/**
 * @author DAN
 *
 */
public class Diary 
{
	private Employee employee;
	private Appointment appointment;
	private Diary left;
	private Diary right;
	private Diary previous;
	private DiaryTree tree = new DiaryTree();
	
	//A scanner object is created here to get user input.
	Scanner input = new Scanner(System.in);
	
	/**
	 * @return the previous
	 */
	public Diary getPrevious() 
	{
		return previous;
	}

	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(Diary previous) 
	{
		this.previous = previous;
	}

	//Add this as a parameter later
	//Appointment appointmentInfo
	public Diary(String forename, String surname, String pass, String position, String username)
	{
		Employee employee = new Employee(forename, surname, pass, position, username);
		//appointment = appointmentInfo;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the appointment
	 */
	public Appointment getAppointment() {
		return appointment;
	}

	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	/**
	 * @return the left
	 */
	public Diary getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 * @return 
	 */
	public Diary setLeft(Diary left) {
		return this.left = left;
	}
	/**
	 * @return the right
	 */
	public Diary getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 * @return 
	 */
	public Diary setRight(Diary right) {
		return this.right = right;
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
		String username = input.nextLine();
		//The username will be searched for in the binary tree.
		Diary user = tree.searchTree(username);
		System.out.println();
		//The password will be asked for from the user.
		System.out.print("Password: ");
		String password = input.nextLine();
		//If the input password is equal to the stored password then the credentials have been authorized.
		if(password.equals(user.getEmployee().getPassword()))
		{
			authenticated = true;
		}
		return authenticated;
	}
	
	/**
	 * Will test if the node to the left is empty.
	 * @param node This is the current node being tested for.
	 * @return empty It is the value that determines if the reference to the left is empty or not.
	 */
	public boolean isLeftEmpty(Diary node) 
	{
		boolean empty;
		if (node.getLeft() == null) 
		{
			//Will set empty to true if the node to the left is a null value.
			empty = true;
		}
		else 
		{
			//Will set empty to false if the node to the left is not null.
			empty = false;
		}
		return empty;
	}
	
	/**
	 * Will test if the node to the right is empty.
	 * @param node This is the current node being tested for.
	 * @return empty It is the value that determines if the reference to the right is empty or not.
	 */
	public boolean isRightEmpty(Diary node) 
	{
		boolean empty;
		if (node.getRight() == null) 
		{
			//Will set empty to true if the node to the right is a null value.
			empty = true;
		}
		else 
		{
			//Will set empty to false if the node to the right is not null.
			empty = false;
		}
		return empty;
	}
	
	public String convertToKey(String username) 
	{
		return employee.textToKey(username);
	}
	
}
	
