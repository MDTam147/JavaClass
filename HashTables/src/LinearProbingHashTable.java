
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinearProbingHashTable<K, V> implements GradableMap<K, V> {
	private HashTableEntry<K,V>[] entries;
	private double maxLoad;
	private int size;
	private int numberOfEntries = 0;
	
	public LinearProbingHashTable(){
		entries = new HashTableEntry[11];
		this.size = 11;
		this.maxLoad = .75;
		
	}
	
	public LinearProbingHashTable(int size){
		this.size = size;
		this.maxLoad = .75;
		entries = new HashTableEntry[size];
		
	}

	public LinearProbingHashTable(int size, double loadFactor){
		this.size = size;
		this.maxLoad = loadFactor;
		entries = new HashTableEntry[size];
	
	}
	
	@Override
	public void clear() {
		for (int i=0; i<numberOfEntries; i++) {
			entries[i] = null;
		}
		
		this.size = 0;
		
	}

	@Override
	public boolean containsKey(Object arg0) {
		for(int i =0; i<numberOfEntries;i++) {
			if(entries[i].getKey()==arg0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		for(int i = 0; i<numberOfEntries; i++) {
			if (entries[i]==arg0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K,V>> setOfEntries = new HashSet<Map.Entry<K,V>>();
		for(int i=0;i<numberOfEntries;i++) {
			setOfEntries.add(entries[i]);
		}
		
		return setOfEntries;
	}

	@Override
	public V get(Object arg0) {
		if(arg0==null) {
			throw new NullPointerException();
		}
		else {
			for(int i=0;i<numberOfEntries;i++) {
				if(entries[i].getKey()==arg0) {
					return entries[i].getValue();
				}
			}
		}
		
		return null;
	}

	@Override
	public boolean isEmpty() {
		if( numberOfEntries == 0) {
			return true;
		}
		return false;
	}

	@Override
	public Set<K> keySet() {
		HashMap keys = new HashMap();
		
		for(int i=0; i<numberOfEntries;i++) {
			keys.put(i,entries[i].getKey());
		}
		return (Set<K>) keys;
	}

	@Override
	public V put(K key, V value) {
		HashTableEntry<K,V> entry = new HashTableEntry(key, value);
		if(key!= null && this.containsKey(key)==false) {
			if((numberOfEntries/size)>maxLoad) {
				this.setSize(size*2);
			}
			entries[numberOfEntries]=entry;
			numberOfEntries++;
			return null;
		}
		else if(key!= null && this.containsKey(key)==true) {
			V oldVal;
			for(int i=0; i<entries.length;i++) {
				if(entries[i].getKey()==key) {
					oldVal = entries[i].getValue();
					entries[i]=entry;
					return oldVal;
				}
			}
		}
		else if (key==null){
			throw new NullPointerException();
		
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		for(K k: otherMap.keySet()) {
			this.put(k, otherMap.get(k));
		}
		
	}

	@Override
	public V remove(Object key) {
		V val = null;
		if(key == null) {
			throw new NullPointerException();
		}
		else if(this.containsKey(key)) {
			for(int i = 0; i<entries.length;i++) {
				if(entries[i].getKey()==key) {
					val = entries[i].getValue();
					entries[i] = null;
					numberOfEntries--;
					return val;
				}
			}
		}
		
		return val;
	}

	@Override
	public int size() {
		return numberOfEntries;
	}

	@Override
	public Collection<V> values() {
		ArrayList<Object> vals = new ArrayList<>();
		for(int i = 0; i<entries.length;i++) {
			vals.add(entries[i].getValue());
		}
		return (Collection<V>) vals;
	}

	@Override
	public HashTableEntry<K, V>[] getArray() {
		return entries;
	}

	@Override
	public void setArray(HashTableEntry<K, V>[] array) {
		this.entries = array;
		
	}

	@Override
	public void setSize(int size) {
		this.size = size;
		
	}

}