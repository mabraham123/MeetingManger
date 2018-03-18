/**
 * List Nodes for Stacks
 * 
 * @author Elliot Kinkead
 * @version v1.0
 */
public class UndoNode    
{
    private Object meeting;
    
    private UndoNode next;

	private Object Object;

    /**
     * Default constructor. Initialise fields to default values
     */
    public UndoNode()
    {
    	Object meeting = null;
        next = null; 
    }

    public UndoNode(Object meeting)
    {
        this.Object = meeting;
        next = null;
    }

    public Object getObject()
    {
        return Object;
    }

    public UndoNode getNext()
    {
    	return next; 
    }

    public void setNext(UndoNode head)
    {
    	this.next = head;
    }
    
}
