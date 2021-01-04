//problem 858

package stray;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Convention {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("convention.in"));
		int N = s.nextInt();
		int M = s.nextInt();
		int C = s.nextInt();
		int[] cowTimes = new int[N];
		for (int i = 0; i < N; i++) {
			cowTimes[i]=s.nextInt();
		}
		s.close();
		Arrays.sort(cowTimes);
		int begin = 0;
		int end = 1000000000;
		while(end - begin > 1) {
			int middle = (begin + end)/2;
			
		}
		// TODO Auto-generated method stub

	}
	private static boolean good(int[] cows, int M, int C, int W) {
		int bus = 0;
		int wait = 0;
		for (int i = 1; i < cows.length; i++) {
			if (cows[i])
		}
	}

}
