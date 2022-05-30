public class Queue<V> {

	private V[] queue;
	private int maxSize;
	private int currSize;
	
    /**
    * Constructor to initialize the queue with a maximum capacity of maxSize.
    */
    @SuppressWarnings("unchecked")
    public Queue(int maxSize) {
    	queue = (V[]) new Object[maxSize];
    	this.maxSize=maxSize;
    	
    }

    /**
        Returns the maximum size this queue can support.
    */
    public int getMaxSize() {
    	return maxSize;
    }

     /**
        Returns the current number of items enqueued.
    */
    public int getCurrentSize() {
    	return currSize;
    }

    /**
        Returns true if there are no elements in the queue.
    */
    public boolean isEmpty() {
    	if (currSize==0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
        Returns true if the queue is size is at max size.
    */
    public boolean isFull() {
    	if(currSize==maxSize) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    /**
        Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    */
    public V peek() {
    	return queue[0];
    }
    
   /**
        Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
    */
    public void add(V value) {
    	if(currSize<maxSize) {
    		queue[currSize] = value;
    		currSize++;
    		System.out.println(currSize+", "+ queue[currSize-1]);
    	}
    	else {
    		throw new IllegalStateException("Queue is full.");
    	}
    }

    /**
        Retrieves and removes the head of this queue, or returns null if this queue is empty.
    */
    public V poll() {
    	if (currSize==0) {
    		return null;
    	}
    	else {
    		V deque = queue[0];
    		
    		for(int i=0; i<currSize-1;i++) {
    			queue[i] = queue[i+1];
    		}
    		
    		queue[currSize]=null;
    		currSize--;
    		
    		return deque;
    	}
    }
    
    /**
        Retrieves and removes the head of this queue.
    */
     public V remove() {
    	
 		V deque = queue[0];
 		
 		for(int i=0; i<currSize-1;i++) {
 			queue[i] = queue[i+1];
 		}
 		
 		queue[currSize-1]=null;
 		currSize--;
 		
 		return deque;
     	
    }
    
}