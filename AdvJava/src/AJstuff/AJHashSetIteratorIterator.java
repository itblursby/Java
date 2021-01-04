package AJstuff;
import java.util.Iterator;
public class AJHashSetIteratorIterator<E> implements Iterator<E>{
	
	Iterator[] iterators = new Iterator[100];
	int current = 0;
	public AJHashSetIteratorIterator(Iterator<E>[] yeet) {
		for (int i = 0; i < 100; i++) {
			iterators[i] = yeet[i];
		}
	}
	@Override
	public boolean hasNext() {
		if (current < 99) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E next() {
		if (iterators[current].hasNext()) {
			return (E) iterators[current].next();
		}else {
			current++;
			return (E) iterators[current].next();
			
		}
		// TODO Auto-generated method stub
		//return null;
	}

}
