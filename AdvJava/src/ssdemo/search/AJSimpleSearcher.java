package ssdemo.search;

public class AJSimpleSearcher implements AJSearcher {
	public boolean searchFor(int array[], int target) {
		for(int i = 0; i < array.length; i+=1) {
			if (array[i] == target) {
				return true;
			}
		}
		
		return false;
	}
}
