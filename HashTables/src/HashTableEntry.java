import java.util.Map.Entry;

public class HashTableEntry<K,V> implements Entry<K, V> {
	
	private K key;
	private V value;
	private boolean available;

	public HashTableEntry(K key, V value){
		this.key = key;
		this.value = value;
		this.available = false;
	}
	
	public boolean isAvailable(){
		return available;
	}
	
	public void setAvailable(boolean isAvailable){
		this.available = isAvailable;
	}

	
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		V oldVal = this.value;
		this.value = value;
		return oldVal;
	}
	
	@Override
	public int hashCode(){
		// CHECK AND SEE IF THIS IS RIGHT??
		int hash;
		hash =  (this.getKey()==null   ? 0 : this.getKey().hashCode());
		hash =  (this.getValue()==null ? 0 : this.getValue().hashCode());
		
		return hash;
	}
	
	@Override
	public boolean equals(Object o){
		if (value == o) {
			return true;
		}
		return false;
	}
}