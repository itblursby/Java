//http://www.usaco.org/index.php?page=viewproblem2&cpid=810
package stray;
import java.util.*;
import java.io.*;
public class RestStops {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		Scanner s = new Scanner (new File("reststops.in"));
		int L = s.nextInt();
		int N = s.nextInt();
		int john = s.nextInt();
		int bessie = s.nextInt();
		int[][] stops = new int[N][2]; //location, tastiness
		for (int i = 0; i < N; i++) {
			stops[i][0] = s.nextInt();
			stops[i][1] = s.nextInt();
		}
		s.close();
//		Arrays.sort(stops, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] a, int[] b) {
//				return a[0]-b[0];
//			}
//		});
		System.out.println(Arrays.deepToString(stops));
		int maxtasty = 0;
		int besttaste = stops[stops.length-1][1];
		for (int i = stops.length-1; i >= 0; i--) {
			int adv;
			if (i == 0) {
				adv = stops[i][0];
			}else {
				adv = stops[i][0] - stops[i-1][0];
			}
			adv *= (bessie - john);
			if (stops[i][1] > besttaste) {
				besttaste = stops[i][1];
			}
			maxtasty += adv * besttaste;
		}
		PrintWriter p = new PrintWriter("reststops.out");
		p.println(-maxtasty);
		p.close();
		System.out.println(-maxtasty);
	}
}
