import java.util.*;
import java.io.*;
public class cowgym {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner (new File("gymnastics.in"));
		PrintWriter p = new PrintWriter("gymnastics.out");
		int sessions = s.nextInt();
		int cows = s.nextInt();
		//System.out.println(cows);
		int[][] ranking = new int[sessions][cows];
		for (int i = 0; i < sessions; i++) {
			for (int j = 0; j < cows; j++) {
				ranking[i][j] = s.nextInt();
			}
			
		}
		int pairs = 0;
		for (int i = 1; i < cows+1; i++) {
			for (int j = i; j < cows+1; j++) {
				
				if (i != j) {
					boolean isConsistent = true;
					boolean greaterThan = findint(ranking,i,0)>findint(ranking,j,0);
					for (int sesh = 0; sesh < sessions; sesh ++) {
						if (greaterThan != findint(ranking,i,sesh)>findint(ranking,j,sesh)) {
							isConsistent = false;
						}
					}
					if (isConsistent) {
						pairs++;
					}
					
				}
			}
		}
		p.println(pairs);
		System.out.println(pairs);
		s.close();
		p.close();
		
	}
	static int findint(int[][] nums, int findthis, int session) {
		for (int i = 0; i < nums[session].length; i++) {
			if (findthis == nums[session][i]) {
				return i;
			}
		}
		return -1;
	}

}
