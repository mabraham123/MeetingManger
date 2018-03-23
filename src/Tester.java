import java.util.LinkedList;

/**
 * 	For testing if undo and linkedlist works
 * 
 * @author Elliot Kinkead
 * @version 1.0
 */
public class Tester 
{
	

	private Undo undo;
	private EmployeeManagement employeeManagement;
	
	public void initialise()
	{
		undo = new Undo();
		employeeManagement = new EmployeeManagement(0, null, null, null);
		
	}

	public void undoTest()
	{
		boolean emptyCheck = undo.isStackEmpty();
		System.out.println(emptyCheck);
		emptyCheck = undo.isStackEmpty();
		System.out.println(emptyCheck);
		
	}
	
	public void testEmployee()
	{
		LinkedList<EmployeeManagement> details = new LinkedList<EmployeeManagement>();
		
		details.add( new EmployeeManagement(101,"GWashington","George Washington","CEO"));
		details.add( new EmployeeManagement(102,"GWashington","George Washington","CEO"));
		details.add( new EmployeeManagement(103,"GWashington","George Washington","CEO"));
		
		System.out.println(details);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tester myTester = new Tester();
		
		myTester.initialise();
		myTester.testEmployee();
		
	}

}
