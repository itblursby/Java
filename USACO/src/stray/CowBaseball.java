//problem 359

package stray;

import java.util.*;
import java.io.*;

public class CowBaseball {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String testinput = "\n" + "5\n" + "3\n" + "1\n" + "10\n" + "7\n" + "4";
		Scanner s = new Scanner(new File("baseball.in"));

		int N = s.nextInt();
		int[] cows = new int[N];
		for (int i = 0; i < N; i++) {
			cows[i] = s.nextInt();
		}
		Arrays.sort(cows);
		s.close();
		int result = 0;
		for (int c1 = 0; c1 < N - 2; c1++) {
			for (int c2 = c1 + 1; c2 < N - 1; c2++) {
				for (int c3 = c2 + 1; c3 < N; c3++) {
					// System.out.println("s");
					if ((cows[c3] - cows[c2]) >= (cows[c2] - cows[c1])
							&& (cows[c3] - cows[c2]) <= 2 * (cows[c2] - cows[c1])) {
						result++;
					}
				}
			}
		}
		PrintWriter p = new PrintWriter("baseball.out");
		// System.out.println(result);
		p.println(result);
		p.close();
	}

}
