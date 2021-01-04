package AJstuff;

import java.util.ArrayList;

public class AJHashMap<K, V> {
	ArrayList<KVPair>[] yes = new ArrayList<KVPair>[100];
	public AJHashMap() {
		
	}
	public int size() {
		return 0;
	}
	
	// TODO
	public void clear() {
		
	}
	
	// TODO
	public boolean remove(K key) {
		return false;
	}
	
	// TODO
	public Object put(K key, V value) {
		return value;
	}
	
	// TODO
	public Object get(K key) {
		return null;
	}
}
class KVPair<K,V>{
	final K key;
	final V value;
	KVPair(K key, V value){
		this.key = key;
		this.value = value;
	}
	K getKey() {
		return key;
	}
	V getValue() {
		return value;
	}
}