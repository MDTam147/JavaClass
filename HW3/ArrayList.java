import java.util.Arrays;

/**
 * 
 * @author Tam Doan
 * 
 * ArrayList class implementation of ArrayList without using the java import.
 *
 * @param <T>
 */

public class ArrayList<T> implements List<T> {

	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private T[] data; // stores the items added to the arraylist
	private int size; // keeps track of how many items have been added to list

	/**
	 * Constructs an ArrayList using the default capacity
	 */
	public ArrayList() {
		
		data = (T[]) new Object[11];
		this.size = 0;
	
	}

	/**
	 * Constructs an ArrayList with an 'initialCapacity'
	 * 
	 * If 'initalCapacity' is non-positive use the default capacity
	 * 
	 * @param initialCapacity
	 */
	public ArrayList(int initialCapacity) {
		
		if (initialCapacity < 1) {
			data = (T[]) new Object[11];
		}
		else {
			data = (T[]) new Object[initialCapacity];
		}
		
		this.size = 0;
		
	}
	
	/**
	 * 
	 * takes the data array and doubles its length, copying all the elements over to the new array
	 * 
	 * @param data
	 * @return regrownArr
	 */
	
	private T[] regrow(T[] data) {
		T[] regrownArr = (T[]) new Object[data.length*2];
		
		System.arraycopy(data, 0, regrownArr, 0, data.length-1);
		
		return regrownArr;
	}

	@Override
	public void add(T item, int index) {
		if(index < 0 || index > size) {
			return;
		}
		
		if(size == data.length-1) {

			data = regrow(data);
		}
		if(index == size) {
			data[index]=item;
		}
		else {
			System.arraycopy(data, index, data, index+1, size); //movies all elements starting from given index over to the right by one
			data[index]=item; // inserts given item into the now-free index
		}
		this.size++;
		

	}

	@Override
	public void clear() {
		Arrays.fill(data, null);
		this.size=0;

	}

	@Override
	public boolean contains(Object item) {
		for(int i =0; i< this.size;i++) {
			if (data[i] == item) {
				return true;
			}
		}
		return false;
	}

	@Override
	public T get(int index) {
		if(index<0 || index>=size) {
			return null;
		}
		else {
			return data[index];
		}
	}

	@Override
	public int indexOf(Object item) {
		for(int i =0; i< this.size;i++) {
			if (data[i] == item) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		for(int i=0;i<size-1;i++) {
			if(data[i]!=null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int size() {
		
		return this.size;
	}
}
