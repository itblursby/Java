//problem 597
package stray;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AngryCows {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String testinput = "2 1 40000";
		// Scanner s = new Scanner(new File("angry.in"));
		Scanner s = new Scanner(testinput);
		
		int N = s.nextInt();
		int[] cows = new int[N];
		for (int i = 0; i < N; i++) {
			cows[i] = s.nextInt();
		}
		System.out.println("N = " + N);
		s.close();
		Arrays.sort(cows);
		System.out.println(Arrays.toString(cows));
		int Rsmall = 0;
		int Rbig = 2000000001;
		while (Rbig - Rsmall > 1) {
			System.out.print("new stuffies: ");
			System.out.print(Rsmall);
			System.out.println(" " + Rbig);
			int Rtest = (Rsmall + Rbig) / 2;
			int Psmall = 0;
			int Pbig = N;
			while (Pbig - Psmall > 1) {
				int Ptest = (Psmall + Pbig) / 2;
				int pos = Ptest;
				int rad = Rtest;
				int pos2 = pos;
				while (pos >= 0) {
					while (pos >= 0 && (cows[pos2] - cows[pos]) * 2 <= rad) {
						pos--;
					}
					if (pos == pos2 - 1) {
						break;
					}
					pos2 = pos + 1;
					rad--;
				}
				if (pos >= 0) {
					Pbig = Ptest;
				} else {
					Psmall = Ptest;
				}
			}
			int phpos = cows[Psmall] * 2 + Rsmall;
			int rad = Rtest;
			int pos = Psmall;
			while (pos < cows.length && ((cows[pos] * 2) - phpos) <= rad) {
				pos++;
			}
			int pos2 = pos;
			while (pos < cows.length) {
				while (pos < cows.length && (cows[pos] - cows[pos2]) * 2 <= rad) {
					pos++;
				}
				if (pos == pos2 + 1) {
					break;
				}
				pos = pos2 + 1;
				rad--;
			}
			if (pos == cows.length) {
				System.out.println("good " + Rtest);
				Rbig = Rtest;
			} else {
				System.out.println("bad " + Rtest);
				Rsmall = Rtest + 1;
			}
		}

		PrintWriter p = new PrintWriter("angry.out");
		p.println(Rsmall);
		p.close();
		System.out.println(Rsmall);
		System.out.println("yay");
	}

}
