/**
 * Undo
 * 
 * This class enables the meeting manager to undo it's work.
 * 
 * @author Elliot Kinkead       
 * @version v1.0
 * 
 *
 */
public class Undo 
{
    private UndoNode head; 
    
    public Undo()
    {
        head = null;
    }

    public UndoNode getHead()
    {
        return head;
    }

    public void setHead(UndoNode newHead)
    {
        head = newHead;
    }
    
    public void push(Object Meeting)
    {
    	/**
    	 * This method allows the user to add (Push)
    	 * 
    	 */
    	UndoNode  newNode;
    	newNode = new UndoNode(Meeting);
    	newNode.setNext(head);
    	head = newNode;
    }
    
    public void printList()
    {
    /**
     * This method allows the user to print the stack.
     */
    	UndoNode marker = null;
    	marker = head;
    	while (marker != null)
    	{
    		System.out.println(marker.getObject());
    		marker = marker.getNext();
    	}
    }
    
    
    public boolean isStackEmpty()
    {
    /**
    * This method checks if the stack is empty
    * a number to the Stack
    */
    	if (head == null)
    	{
    		return true;
    	}
    	else 
    	{
    		return false;
    	}
    }
    
    public boolean isStackAdd() {
    if (Object meeting)
    {
    	
    }
    else
    {
    	
    }
    }
    
    public boolean isStackEdit () {
    if 
    {
    	
    }
    
    else
    {
    	
    }
 	public UndoNode pop()
    {
 		/**
    	 * This method allows the user to delete the head
    	 * 
    	 */
 		// Set the Current List node to Null
 		UndoNode nodeToPop = null;
	
		if (isStackEmpty()== true) 
		//Check if the Stack is empty
		{
			return null;
		// Only if the stack is empty then it will just return null. aka there's nothing there.
		}
		else
		//If stack not empty
		{
			if (isStackAdd() == true)
			{
				// Add Parameter for if this object comes from the add method
				// Delete Meeting
				nodeToPop = head;
				// Remove the current node
				head = head.getNext();
				// Set the previous node to top of the list aka Head
				return nodeToPop;
				
			}
				
			else if isStackEdit() == true)
			{
				// Add Parameter for if this object comes from the edit methodd.
				// Restore parameter stored.
				// Delete Meeting
				nodeToPop = head;
				// Remove the current node
				head = head.getNext();
				// Set the previous node to top of the list aka Head
				return nodeToPop;
			}
			else 
			// Delete Meeting
			nodeToPop = head;
			// Remove the current node
			head = head.getNext();
			// Set the previous node to top of the list aka Head
			return nodeToPop;
		}
	}
 
}
    