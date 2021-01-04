package AJstuff;

import java.util.Arrays;
import java.util.Iterator;

public class AJSortedList<E extends Comparable<E>> implements AJCollection<E> {
	
	int capacity = 1;
	int size = 0;
	Object[] elements;
	public AJSortedList(int startcap) {
		elements = new Object[startcap];
		capacity = startcap;
	}
	@Override
	public boolean add(E e) {
		if (size + 1 > capacity) {
			capacity = 1 + (capacity << 1);
			Object[] elements2 = new Object[capacity];
			for (int i = 0; i < elements.length; i++) {
				elements2[i] = elements[i];
			}
			elements = elements2;
		}
		int startbound = 0;
		int endbound = size;
		//int insertindex;
		while(endbound - startbound > 1) {
			if (e.compareTo((E)elements[(startbound+endbound)>>1])>0) {
				startbound = (startbound + endbound) >> 1+1;
			}else {
				endbound = (startbound+endbound) >> 1;
			}
		}
		for (int i = startbound+1; i < size; i++) {
			elements[i] = elements[i-1];
		}
		elements[startbound] = e;
		size++;
		return true;
		
		// TODO Auto-generated method stub
	}

	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		int startbound = 0;
		int endbound = size;
		//int insertindex;
		while(endbound - startbound > 1) {
			if (e.compareTo((E)elements[(startbound+endbound)>>1])>0) {
				startbound = (startbound + endbound) >> 1+1;
			}else {
				endbound = (startbound+endbound) >> 1;
			}
		}
		if (elements[startbound].equals(e)) {
			for (int i = startbound; i < size; i++) {
				elements[i] = elements[i+1];
			}
			size--;
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E e) {
		int startbound = 0;
		int endbound = size;
		//int insertindex;
		while(endbound - startbound > 1) {
			if (e.compareTo((E)elements[(startbound+endbound)>>1])>0) {
				startbound = (startbound + endbound) >> 1+1;
			}else {
				endbound = (startbound+endbound) >> 1;
			}
		}
		if (elements[startbound].equals(e)) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		size = 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	@Override 
	public String toString() {
		return Arrays.deepToString(elements);
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return AJArrayListIterator<E>(elements, length);
	}
	
}
