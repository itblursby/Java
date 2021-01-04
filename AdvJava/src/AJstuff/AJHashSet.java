package AJstuff;

import java.util.Iterator;
import java.util.ArrayList;

public class AJHashSet<E> implements AJCollection<E>{
	ArrayList<E>[] buckets;// = new ArrayList[100];
	int size = 0;
	public AJHashSet() {
		clear();
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		Iterator<E>[] iterators = new Iterator[100];
		for (int i = 0; i < 100; i++) {
			iterators[i] = buckets[i].iterator();
		}
		return new AJHashSetIteratorIterator(iterators);
		//return null;
	}
	@Override
	public void clear() {
		size = 0;
		buckets = new ArrayList[100];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<E>();
		}
		// TODO Auto-generated method stub

	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override
	public boolean add(E element) {
		if (this.contains(element)) {
			return false;
		}
		size++;
		int bucket = ((element.hashCode()%100)+100)%100;
		//ArrayList<E> bruh = buckets[bucket];
		buckets[bucket].add(element);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean remove(E element) {
		// TODO Auto-generated method stub
		int bucket = ((element.hashCode()%100)+100)%100;
		boolean result = buckets[bucket].remove(element);
		if (result) {
			size--;
		}
		return result;
		//return false;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return buckets[((element.hashCode()%100)+100)%100].contains(element);
		//return false;
	}
	//dont use this please have a nice day
	public ArrayList<E> getBucket(int index){
		return buckets[index];
	}

}
