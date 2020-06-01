//http://www.usaco.org/index.php?page=viewproblem2&cpid=918
import java.util.*;
import java.io.*;
public class CowHerd {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("herding.in"));
		PrintWriter p = new PrintWriter("herding.out");
		int N = s.nextInt();
		int[] cows = new int[N];
		for (int i = 0; i < N; i++) {
			cows[i] = s.nextInt();
		}
//		cows = new int[] {3,4,10};
//		N = cows.length;
		System.out.println(N);
		s.close();
		int min = cows[0];
		int max = cows[N-1];
		Arrays.sort(cows);
		
		System.out.println(Arrays.toString(cows));
		int maxmoves;
		if (cows[1]-cows[0]>cows[N-1]-cows[N-2]) {
			//System.out.println((cows[N-2]-cows[0]-1)-(N-3));
			maxmoves = (cows[N-2]-cows[0]-1)-(N-3);
		} else {
			//System.out.println((cows[N-1]-cows[1]-1)-(N-3));
			maxmoves = (cows[N-1]-cows[1]-1)-(N-3);
		}
		//System.out.println("Max is " + maxmoves);
		int minmoves;
		int maxcows = -1;
		for (int i = 1; i < N-1; i++) {
			if (cows[i] + N -1> cows[N-1]) {
			}else {
				int tbegin = cows[i];
				int tend = cows[i] + N;
				int tcows = 0;
				for (int j = i; j<N&&cows[j]<tend; j++) {
					tcows++;
				}
				if (tcows > maxcows) {
					maxcows = tcows+0;
				}
			}
			if (cows[i] - (N)<cows[0]) {
			} else {
				int tbegin = cows[i];
				int tend = cows[i] - (N);
				int tcows = 0;
				for (int j = i; j>=0&&cows[j]>tend; j--) {
					tcows++;
				}
				if (tcows > maxcows) {
					maxcows = tcows+0;
				}
			}
		}
		int tend = cows[0]+N;
		int tcows = 0;
		boolean valid = true;
		for (int i = 0; i < N; i++) {
			if (i>0) {
				if (i > 0&&i < N-1) {
					if (cows[i]-cows[i-1]>1) {
						valid = false;
						break;
					}
				}
				if (i == N-1) {
					if (cows[i]-cows[i-1]==1) {
						valid = false;
						break;
					}
				}
			}
		}
		if (!valid) {
			for (int i = 0; i < N&&cows[i]<tend; i++) {
				tcows++;
			}
			if (tcows > maxcows) {
				maxcows = tcows+0;
			}
		}
		valid = true;
		for (int i = N-1; i >= 0; i--) {
			if (i<N-1) {
				if (i < N-1&&i >1) {
					if (cows[i+1]-cows[i]>1) {
						valid = false;
						break;
					}
				}
				if (i == 0) {
					if (cows[i+1]-cows[i]==1) {
						valid = false;
						break;
					}
				}
			}
		}
		tend = cows[N-1]-N;
		if (!valid) {
			for (int i = N-1; i >= 0 &&cows[i]>tend; i--) {
				tcows++;
			}
			if (tcows > maxcows) {
				maxcows = tcows+0;
			}
		}
		
		minmoves = N - maxcows;
		//System.out.println("Min is " + minmoves);
		if (cows[N-1]-cows[0] == N-1) {
			p.println(0);
			System.out.println("Min is "+0);
			p.println(0);
			System.out.println("Max is "+0);
		}else {
			p.println(minmoves);
			System.out.println("Min is " + minmoves);
			p.println(maxmoves);
			System.out.println("Max is " + maxmoves);
		}
		
		p.close();

	}

}
