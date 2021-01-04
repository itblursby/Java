package AJstuff;

import java.util.Iterator;

public class AJHashSetIterator<E> implements Iterator<E>{

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	int bucket = 0;
	int index = 0;
	AJHashSet<E> hashset;
	public AJHashSetIterator(AJHashSet<E> bruh) {
		hashset = bruh;
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return index < hashset.size();
		//return false;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		if (index >= hashset.getBucket(bucket).size()) {
			bucket++;
			index = 0;
		}
		if (bucket == 100) {
			return null;
		}
		return (hashset.getBucket(bucket).get(index));
		//return null;
	}

}
