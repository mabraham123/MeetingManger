/**
 * List Nodes for Stacks
 * 
 * @author Elliot Kinkead
 * @version v1.0
 */
public class StackNode    
{
    private Appointment meeting;
    
    private StackNode next;

	private Object Object;

    /**
     * Default constructor. Initialise fields to default values
     */
    public StackNode()
    {
    	meeting = null;
        next = null; 
    }

    public StackNode(Object meeting)
    {
        this.Object = meeting;
        next = null;
    }

    public Object getObject()
    {
        return Object;
    }

    public StackNode getNext()
    {
    	return next; 
    }

    public void setNext(StackNode head)
    {
    	this.next = head;
    }
    
}
