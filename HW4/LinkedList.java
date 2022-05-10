
import java.util.Iterator;

/**
 * 
 * @author Tam Doan
 * Linked List class implementation without using java import for HW4
 *
 * @param <T>
 */


public class LinkedList<T> implements List<T> {
	
	private class Node {
		Node next , prev ;
		T data ;
		
		Node(T data){
			this.data = data;
		}
	}
	
	private Node head, tail;
	private int size;
	
	public LinkedList () {
		// Do nothing .
	}
	
	// **** METHODS *****

	@Override
	public void add(T item) { 
		addLast(item);

	}
	
	/**
	 * clears all nodes of the linked list and resets size to 0
	 * 
	 */
	@Override
	public void clear() { 
		Node n = head;
		
		while (n!=null) {
			Node temp = n.next;
			n.data = null;
			n.next = null;
			n.prev = null;
			
			size--;
			n = temp;
		}

	}
	
	/**
	 * @param item
	 * @return true if the item in the linked list, false if it isnt't
	 *
	 */

	@Override
	public boolean contains(Object item) { 
		for(Node n = head; n != null; n=n.next) {
			if(n.data == item || ( n.data != null && n.data == item)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return true if list is empty, false if list is not
	 */

	@Override
	public boolean isEmpty() { 
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * @param item
	 * @return the removed item at given index
	 * removes item at given index and returns said item
	 *  
	 */

	@Override
	public T remove(Object item) { 
		for(Node n = head; n != null; n=n.next) {
			if(n.data == item || ( n.data != null && n.data == item)) {
				Node temp = n;
				n.data = null;
				n.prev.next = temp.next;
				n.next.prev = temp.prev;
				
				size--;
				
				return temp.data;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterate = new Iterator<T>() {
			
			private Node currentIndex = head;

			@Override
			public boolean hasNext() {
				
				if (currentIndex!=null) {
					return true;
				}
				
				return false;
			}

			@Override
			public T next() {
				Node n = currentIndex;
				currentIndex = currentIndex.next;
				
				return n.data;
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
			
		};
		
		return iterate;
		
		
	}
	
	/**
	 * @param item, index
	 * adds given item into the list at the given index
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */

	@Override
	public void add(T item, int index) { 
		
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		if(index == 0) { 
			addFirst(item);
		}
		else if(index == size) { 
			addLast(item);
		}
		else {
			Node newItem = new Node(item);
			Node n = head;
			
			for(int i = 0; i<=index;i++) {
				if (i==index) {
					Node temp = n;
					temp.prev.next = newItem;
					newItem.next = n;
					n.prev = newItem;
					newItem.prev = temp.prev;
					size++;
					break;
					
				}
				
				n = n.next;
			}
		}
		

	}
	
	/**
	 * @param index
	 * @return the item at given index in the linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty or index is greater than size of list
	 */

	@Override
	public T get(int index) { 
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		Node n = head;
		for (int i = 0; i <= index; i++) {
			if (i == index) {
				return n.data;
			}
			n = n.next;
		}
		return null;
	}
	
	/**
	 * @param item
	 * @return the index of a given item in the linked list
	 * 
	 */

	@Override
	public int indexOf(Object item) { 
		int i = 0;
		for (Node n = head; n!=null; n=n.next) {
			if(n.data == (T)item) {
				return i;
			}
			i++;
		}
		
		return -1;
	}
	
	/**
	 * @param index
	 * @return the item removed from given index in linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty or index is greater than list size
	 */

	@Override
	public T remove(int index) { 
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index == 0) {
			removeFirst();
			
		}
		else if(index == size-1) {
			removeLast();
		}
		else {
			
			Node n = head;
			for (int i = 0; i <=index ; i++) {
				if (i == index) {
					Node temp = n;
					n.prev.next = temp.next;
					n.next.prev = temp.prev;
					n.next = null;
					n.prev = null;
					size--;
					
					return temp.data;
					
				}
				n = n.next;
			}
		}
		
		
		return null;
	}

	/**
	 * @return the first item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getFirst() { 
		if (head == null) {
			throw new NoSuchElementException();
		}
		else {
			return head.data;
		}
	}

	/**
	 * @return the last item in this linked list
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T getLast() { 
		if (tail == null) {
			throw new NoSuchElementException();
		}
		else {
			return tail.data;
		}
	}

	/**
	 * Adds 'item' to front of this linked list
	 * 
	 * @param item
	 */
	public void addFirst(T item) { 
		Node newHead = new Node(item);
		newHead.next = head;
		if(head!=null) {
			head.prev = newHead;
		}
		head = newHead;
		size++;

	}

	/**
	 * Adds 'item' to the end of this linked list
	 * 
	 * @param item
	 */
	public void addLast(T item) { 
		Node newTail = new Node(item);
		
		if(tail != null) {
			tail.next = newTail;
		}		
		newTail.prev = tail;
		newTail.next = null;
		if(size==0) {
			head = newTail;
		}
		tail = newTail;
		size++;
		
	}

	/**
	 * Removes and returns the first item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeFirst() { 
		if(size == 0) {
			throw new NoSuchElementException();
		}
		
		T temp = head.data;
		Node newHead = head.next;
		newHead.prev = null; // removing next Node's pointer to head
		head.next = null; // removing head's pointer to next Node
		head = newHead;
		size--;
		return temp;
	}

	/**
	 * Removes and returns the last item from this linked list
	 * 
	 * @return
	 * @throws NoSuchElementException
	 *             if this linked list is empty
	 */
	public T removeLast() { 
		if(size == 0) {
			throw new NoSuchElementException();
		}
		
		T temp = tail.data;
		Node newTail = tail.prev;
		tail.prev.next = null;
		tail.prev = null;
		tail = newTail;
		size--;
		return temp;
	}
}
