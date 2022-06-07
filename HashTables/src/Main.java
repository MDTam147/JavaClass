
public class Main {

	public static void main(String[] args) {
		LinearProbingHashTable<Integer, String> hashTable = new LinearProbingHashTable<Integer, String>();
		
		hashTable.put(0, "Hello");
		hashTable.put(1, "World");
		hashTable.put(2, "This");
		hashTable.put(3, "Is");
		hashTable.put(4, "A");
		hashTable.put(5, "Test");
		
		
		for(int i=0;i<hashTable.size();i++) {
			System.out.println(i+": "+hashTable.get(i));
		}
		

	}

}
