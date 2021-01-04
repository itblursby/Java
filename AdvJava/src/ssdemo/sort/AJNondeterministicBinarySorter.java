package ssdemo.sort;

import ssdemo.Utility;

public class AJNondeterministicBinarySorter implements AJSorter {

	@Override
	public void sort(int[] array) {
		sort(array, 0, array.length-1);
	}

	public void sort(int[] array, int begin, int end) {
		if (begin >= end) {
			return;
		}
		
		int RIndex = (int)(Math.random() * (end - begin + 1)) + begin;
		int R = array[RIndex];
		Utility.swp(array, RIndex, end);
		
		int A = begin;
		int B = end-1;
		
		while(A <= B) {
			if (array[A] <= R) {
				A += 1;
			} else {
				Utility.swp(array, A, B);
				B -= 1;
			}
		}
		
		Utility.swp(array, end, A);
		
		// TODO - there's some code missing here to make this
		// actually work right...
		// ...
		// ...
	}
}
