package jan2021;

import java.util.*;

public class BessieTheArtist {
	static int[] before;
	static int[] after;
	static char min = 'Z' + 1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String testinput = "8 2\n" + "ABCDEFG\n" + "1 7\n" + "1 6";
		//Scanner scan = new Scanner(testinput);
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int Q = scan.nextInt();
		before = new int[N];
		after = new int[N];
		String fence = scan.next();

		int[][] intrs = new int[Q][2];
		for (int i = 0; i < Q; i++) {
			intrs[i][0] = scan.nextInt() - 1;
			intrs[i][1] = scan.nextInt();
		}
		//System.out.println(Arrays.deepToString(intrs));
		scan.close();
		for (int i = 0; i < fence.length(); i++) {
			if (fence.charAt(i) < min) min = fence.charAt(i);
		}
		big(fence,before);
		//System.out.println(fence);
		//System.out.println(new StringBuilder(fence).reverse().toString());
		big(new StringBuilder(fence).reverse().toString(),after);
		//System.out.println(Arrays.toString(before));
		//System.out.println(Arrays.toString(after));


//		for (int i = 0; i < Q; i++) {
//			System.out.println(st(fence,0,intrs[i][0])+st(fence,intrs[i][1],fence.length()));
//		}
		for (int i = 0; i < Q; i++) {
			int x = 0;
			if (intrs[i][0]-1>=0) {
				x+= before[intrs[i][0]-1];
			}
			if (fence.length()-intrs[i][1]-1>= 0) {
				x+= after[fence.length()-intrs[i][1]-1];
			}
			System.out.println(x);
		}
		// System.out.println(st("CBCAB"));

	}

	public static int st(String a) {
		return st(a, 0, a.length());
	}

	public static void big(String a, int[] r) {
		// System.out.println("starting----------");
		int s = 1;
//		char min = 'Z' + 1;
//		for (int i = 0; i < a.length(); i++) {
//			if (a.charAt(i) < min)
//				min = a.charAt(i);
//		}
		char demin = 'Z' + 1;
		// System.out.println(min);
		int e = -1;
		// int i = begin;
		for (int i = 0; i < a.length(); i++) {
			// System.out.println(i);
			if (a.charAt(i) < demin) {
				demin = a.charAt(i);
			}
			if (a.charAt(i) > min && e == -1) {
				e = i;
			} else if (a.charAt(i) == min && e != -1) {
				// System.out.println("call");
				s += st(a, e, i);
				e = -1;
			}
			if (e != -1) {

				int d = st(a, e, i + 1);
				// System.out.println("re " + d);
				r[i] = s + d;
			} else {
				r[i] = s;
			}
			if (demin != min) {
				r[i] -= 1;
			}
			

		}
	}
//	public static void small(String a) {
//		// System.out.println("starting----------");
//		int s = 1;
//		char min = 'Z' + 1;
//		for (int i = 0; i < a.length(); i++) {
//			if (a.charAt(i) < min)
//				min = a.charAt(i);
//		}
//		// System.out.println(min);
//		int e = -1;
//		// int i = begin;
//		for (int i = 0; i < a.length(); i++) {
//			int alti = a.length()-i;
//			// System.out.println(i);
//			if (a.charAt(alti) > min && e == -1) {
//				e = alti;
//			} else if (a.charAt(alti) == min && e != -1) {
//				// System.out.println("call");
//				s += st(a, e, i);
//				e = -1;
//			}
//			if (e != -1) {
//
//				int d = st(a, e, i + 1);
//				// System.out.println("re " + d);
//				after[i] = s + d;
//			} else {
//				after[i] = s;
//			}
//
//		}
//	}

	public static int st(String a, int begin, int end) {
		if (end - begin <= 0)
			return 0;
		int s = 1;
		char min = 'Z' + 1;

		for (int i = begin; i < end; i++) {
			if (a.charAt(i) < min)
				min = a.charAt(i);
		}
		// System.out.println(min);
		int e = -1;
		int i = begin;
		while (i < end && a.charAt(i) == min) {
			i++;
		}
		boolean other = false;
		for (; i < end; i++) {
			if (a.charAt(i) > min && e == -1) {
				other = true;
				e = i;
			} else if (a.charAt(i) == min && e != -1) {
				s += st(a, e, i);
				e = -1;
			}
		}
		if (e != -1 && other) {
			s += st(a, e, end);
		}
		return s;
	}
//	public static int st(String a, int begin, int end, char min) {
//		int s = 1;
//		int e = -1;
//		for (int i = begin; i < end; i++) {
//			if (a.charAt(i) > min) {e = i;}
//			else if (a.charAt(i) == min) {s += st(a,e,i,min);}
//		}
//	}

}
