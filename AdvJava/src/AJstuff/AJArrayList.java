package AJstuff;

import java.util.Iterator;

public class AJArrayList<E> implements AJCollection<E> {

	Object[] elements;
	int size = 0;
	int capacity = 1;

	public AJArrayList(int startcap) {
		elements = new Object[startcap];
		capacity = startcap;
	}
	public AJArrayList() {
		elements = new Object[1];
		
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
		elements[size] = e;
		size++;
		return true;
	}
	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		boolean found = false;
		int i;
		for (i = 0; i < size; i++) {
			if (elements[i].equals(e)) {
				found = true;
				break;
			}
		}
		if (found) {
			for (; i < size-1; i++) {
				elements[i] = elements[i + 1];
			}
			elements[i+1] = null;
			size--;
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(elements[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void clear() {
		//elements = new Object[capacity];
		//capacity = 1;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}
//	@Override
//	public E get(int i) {
//		if (i > size)
//		return elements[i];
//	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new AJArrayListIterator(elements, size);
		//return null;
	}

}
