package ssdemo;

import ssdemo.search.AJSearcher;
import ssdemo.search.AJSimpleSearcher;
import ssdemo.sort.AJNondeterministicBinarySorter;
import ssdemo.sort.AJSelectionSorter;
import ssdemo.sort.AJSorter;

public class AJSSDemo {

	public static void main(String[] args) {
		int sampleArray[] = new int[] {7, 1, 5, 10, 3, 11, 2};
		
		AJSorter sorter = new AJSelectionSorter();
		sorter.sort(sampleArray);
		
		for (int i = 0; i < sampleArray.length; i+=1) {
			System.out.println("sampleArray["+i+"] == " + sampleArray[i]);
		}
		
		AJSearcher searcher = new AJSimpleSearcher();
		System.out.println("Has a 3: " + searcher.searchFor(sampleArray, 3));
		System.out.println("Has a 4: " + searcher.searchFor(sampleArray, 4));
	}

}
