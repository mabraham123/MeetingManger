<<<<<<< HEAD

public class Tester 
{

	//These are tester employee diaries
	Diary mark = new Diary("mark", "surname", "vghse2", "position", "marky");
	Diary gary = new Diary("gary", "surname", "asd0j", "position", "garile");
	Diary barry = new Diary("barry", "surname", "ashd98", "position", "borry");
	Diary harry = new Diary("harry", "surname", "nujsia03", "position", "haggy");
	Diary larry = new Diary("larry", "surname", "dbhj83", "position", "laggy");
	Diary jim = new Diary("jim", "surname", "gd3278", "position", "poppy");
	Diary flint = new Diary("flint", "surname", "hc7893g", "position", "mega");
	Diary Varga = new Diary("Varga", "surname", "f923uj", "position", "baye");
	Diary gavin = new Diary("gavin", "surname", "ah923n", "position", "manly");
	Diary Cyle = new Diary("Cyle", "surname", "fe8yh3", "position", "cenfty");
	Diary Homer = new Diary("Homer", "surname", "wqyh32", "position", "Phaggot");
	Diary marge = new Diary("marge", "surname", "fs84hn", "position", "tinderlover");
	Diary marklin = new Diary("marklin", "surname", "32bnoa", "position", "scrappy");
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
	}
	
	public void testerTree() 
	{
=======
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
>>>>>>> master
		
	}

}
