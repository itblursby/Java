package AJstuff;

import java.util.Iterator;

public class AJArrayListIterator<E> implements Iterator<E>{

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	}
	int index = 0;
	int size = -1;
	Object[] elements;
	
	public AJArrayListIterator(E[] elements, int size) {
		this.elements = elements;
		this.size = size;
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		
		return index<size;
	}

	@Override
	public E next() {
		if (this.hasNext()) {
			E toReturn = (E) elements[index];
			index++;
			return toReturn;
			
		}
		throw new IndexOutOfBoundsException("stop doing that");
		// TODO Auto-generated method stub
		
	}

}
