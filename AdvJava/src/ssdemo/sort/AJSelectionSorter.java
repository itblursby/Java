package ssdemo.sort;

import ssdemo.Utility;

public class AJSelectionSorter implements AJSorter {
	public void sort(int array[]) {
		for(int target = 0; target < array.length; target += 1) {
			int min = array[target];
			int minIndex = target;
			for(int j = target+1; j < array.length; j += 1) {
				if (min > array[j]) {
					min = array[j];
					minIndex = j;
				}
			}

			Utility.swp(array, target, minIndex);
		}
 	}
}
