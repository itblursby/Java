import java.util.*;
import java.io.*;

public class Swappity {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("swap.in"));
		PrintWriter p = new PrintWriter("swap.out");
		int N = s.nextInt();
		int M = s.nextInt();
		long K = s.nextLong();
		int[][] swaps = new int[M][2];
		for (int i = 0; i < M; i++) {
			swaps[i][0] = s.nextInt() - 1;
			swaps[i][1] = s.nextInt() - 1;
		}
		
		int[][] shuffles = new int[10][N];
		//TODO
		int[] cows = new int[N];
		for (int i = 0; i < N; i++) {
			cows[i] = i;
		}
		for (int i = 0; i < M; i++) {
			cows = rever(cows,swaps[i][0],swaps[i][1]);
		}
		shuffles[0] = cows.clone();
		print(shuffles[0]);
		for (int i = 1; i < 10; i++) {
			int[] c = new int[N];
			for (int j = 0; j < N; j++) {
				c[j] = j;
			}
			for (int k = 0; k < 10; k++) {
				c = shuffle(c,shuffles[i-1]);
			}
			shuffles[i] = c.clone();
		}
		
		for (int j = 0; j < N; j++) {
			cows[j] = j;
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < K%10; j++) {
				cows = shuffle(cows, shuffles[i]);
			}
			K /= 10;
		}
		for (int i = 0; i < N; i++) {
			p.println(cows[i]+1);
	    }
		
		s.close();
		p.close();
		
		
	}
	
	
	static int[] b (int[] a) {
		int[] out = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			out[i] = a[i];
		}
		return out;
	}
	static void print(int[] a) {
		System.out.println("");
		for (int i= 0; i < a.length; i++) {
			System.out.print(a[i]+",");
		}
	}
	
	static int[] shuffle(int[] a, int[] b) {
		int[] out = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			out[i] = a[b[i]];
		}
		return out;
	}
	static int[] rever(int[] cows, int s1, int s2) {
		int[] cow = cows;
		int f = s1+s2;
		for (int i = 0; i < 1+(s2-s1)/2; i++) {
			int temp;
			temp = cow[i+s1];
			cow[i+s1] = cow[f-(i+s1)];
			cow[f-(i+s1)] = temp;
		}
		return cow;
		
	}
	

}
