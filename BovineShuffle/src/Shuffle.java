
import java.io.*;
import java.util.*;

public class Shuffle {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("shuffle.in"));
		int cows = s.nextInt();
		int[] cowID = new int[cows];
		int[] newCowID = new int[cows];
		int[] cowShuffle = new int[cows];
		
		for (int i = 0; i < cows; i++) {
			cowShuffle[i] = s.nextInt()-1;
		}
		for (int i = 0; i < cows; i++) {
			cowID[i] = s.nextInt();
		}
		s.close();
		//System.out.println(findint(cowShuffle,2));
		for (int bruh = 0; bruh < 3; bruh++) {
			for (int i = 0; i < cows; i++) {
				newCowID[i] = cowID[cowShuffle[i]];
				
			}
			for (int i = 0; i < cows; i++) {
				cowID[i] = newCowID[i];
			}
		}
		PrintWriter u = new PrintWriter("shuffle.out");
		for (int i = 0; i < cows; i++) {
			u.println(cowID[i]);
			//System.out.println(cowID[i]);
		}
		
		u.close();

	}
	/*
	 * 1 2 3 4 5
	 * 1 3 4 5 2
		
	 */
	static int findint(int[] nice,int j) {
		
		for (int s = 0; s < nice.length; s++) {
			if (nice[s] == j){
				return s;
			}
		}
		return -1;
	}
	
}
