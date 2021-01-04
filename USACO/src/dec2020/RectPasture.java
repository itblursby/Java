package dec2020;

import java.util.*;

public class RectPasture {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testinput = "4\n" + "0 2\n" + "1 0\n" + "2 3\n" + "3 5\n" + "\n" + "";
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(testinput);
		int N = sc.nextInt();
		int[][] cows = new int[N][];
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int[] c = new int[] {x, y};
			cows[i] = c;
		}
		sc.close();
		Arrays.sort(cows, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0]-b[0];
			}
		});
		int[][] sums = new int[N][N];
		for (int y = 0; y < N; y++) {
			
		}
		System.out.println(Arrays.deepToString(cows));
		long result = 1;
		for (int begin = 0; begin < cows.length; begin++) {
			for (int end = begin + 1; end <= cows.length; end++) {
				
			}
		}
		/*
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < N - i + 1; j++) {
//				int max = j;
//				int min = j;
//				for (int k = j+1; k < j+i; k++) {
//					//Cow c = ;
//					if (cows[k].x < cows[min].x) {
//						min = k;
//					}
//					if (cows[k].x > cows[max].x) {
//						max = k;
//					}
//				}
				int tcount = 1;
				int bcount = 1;
				for (int k = j; k < j + i; k++) {
					if (cows[k].y > cows[j].y && cows[k].y > cows[j + i - 1].y) {
						tcount++;
					} else if (cows[k].y < cows[j].y && cows[k].y < cows[j + i - 1].y) {
						bcount++;
					}
				}
				/*
				 * System.out.println("span:" + i + " "+ j); System.out.println("min:" + j);
				 * System.out.println("max:" + (j+i-1));
				 * 
				 * 
				 * System.out.println((tcount)*bcount);
				 /
//				System.out.println((bcount));
				result += (tcount * bcount);
			}
//			//System.out.println(i);
//			result += (N-i+1)*contSubset(i);
//			result -= (N-i)*contSubset(i);
//			System.out.println((N-i+1)*contSubset(i));
//			System.out.println("------------------------");
		}
		// System.out.println(Arrays.deepToString(cows));
		 */
		System.out.println(result);
	}

	public static int contSubset(int N) {

		return (N * (N + 1)) / 2;
	}

	public static int contSubset(int N, int len) {
		return (N - len);
	}

	public static int contSubsetLeast(int N, int len) {
		return (N - len);
	}
}
/*
class Cow {
	final int x, y;

	public Cow(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}

class YSorter implements Comparator<Cow> {
	@Override
	public int compare(Cow a, Cow b) {
		return a.y - b.y;
	}
}

class XSorter implements Comparator<Cow> {
	@Override
	public int compare(Cow a, Cow b) {
		return a.x - b.x;
	}
}*/
