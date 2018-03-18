/**
 * List Nodes for Stacks
 * 
 * @author Elliot Kinkead
 * @version v1.0
 */
public class ListNode    
{
    private Object meeting;
    
    private ListNode next;

	private Object Object;

    /**
     * Default constructor. Initialise fields to default values
     */
    public ListNode()
    {
    	Object meeting = null;
        next = null; 
    }

    public ListNode(Object meeting)
    {
        this.Object = meeting;
        next = null;
    }

    public Object getObject()
    {
        return Object;
    }

    public ListNode getNext()
    {
    	return next; 
    }

    public void setNext(ListNode head)
    {
    	this.next = head;
    }
    
}
