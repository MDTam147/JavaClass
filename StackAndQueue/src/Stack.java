public class Stack<V>
{
	
	private V[] data;
	private int maxSize;
	private int currSize = 0;
	
    /**
        Constructor to initialize the stack with a maximum capacity of maxSize.
    */
    @SuppressWarnings("unchecked")
    public Stack(int maxSize)
    {
    	data = (V[]) new Object[maxSize];
    	this.maxSize = maxSize;
    }
 
    /**
         Pushes an item onto the top of this stack.
    */
    public void push(V element) {
    	if (currSize != maxSize) {
    		data[currSize] = element;
    		currSize++;
    		
    	}
    }
 
    /**
        Removes the object at the top of this stack and returns that object as the value of this function.
    */
    public V pop()
    {
    	V popped = data[currSize-1];
    	data[currSize-1] = null;
    	currSize--;
    	
    	return popped;
    }
 
    /**
        Looks at the object at the top of this stack without removing it from the stack.
    */
    public V peek()
    {
    	return data[currSize-1];
    }
 
    /**
        Returns the number of items currently in the stack
    */
    public int currentSize() {
    	return currSize;
    }
 
    /**
        Tests if this stack is empty.
    */
    public boolean isEmpty() {
    	if(currSize!=0) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
 
    /**
        Tests if this stack is full
    */
    public boolean isFull() {
    	if(currSize==maxSize) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
}