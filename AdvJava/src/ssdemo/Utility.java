package ssdemo;

public class Utility {
	public static void swp(int array[], int i, int j) {
		int tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}
}
