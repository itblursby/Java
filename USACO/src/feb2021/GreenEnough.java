package feb2021;

import java.util.*;
//import java.io.*;

public class GreenEnough {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testinput = "3\n" + "57 120 87\n" + "200 100 150\n" + "2 141 135";
		Scanner s;
		//s = new Scanner(testinput);

		 s = new Scanner(System.in);
		int N = s.nextInt();
		int[][] field = new int[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				int next = s.nextInt();
				if (next > 100) {
					next = 1;
				}else if (next < 100){
					next = -1;
				}else {
					next = 0;
				}
				field[x][y] = next;
			}
		}
		s.close();
		long result1 = 0;
		//all with a minimum of 0 or 1
		long result2 = 0;
		//all with a minimum of 1
		int[][] threshold = new int[N][2];
		//calculate thresholds for 0,0
//		for (int x = 0; x < N; x++) {
//			for (int y = 0; y < N; y++) {
//				for (int x2 = x+1; x2 <= N; x2++) {
//					for (int y2 = y+1; y2 <= N; y2++) {
//						int min = 10000;
//						for (int x3 = x; x3 < x2; x3++) {
//							for (int y3 = y; y3 < y2; y3++) {
//								if (field[x3][y3]<min) {
//									min = field[x3][y3];
//								}
//							}
//						}
//						if (min == 0) {
//							result1++;
//						}
//					}
//				}
//			}
//		}
		System.out.println(result1);
	}
	public static void fill(int[][] threshold, int[][] field, int x, int y, int N) {
		for (int y2 = y; y2 < N; y2++) {
			int x2 = x;
			threshold[y2-y]
			while(x2 < N) {
				
			}
		}
	}

}
