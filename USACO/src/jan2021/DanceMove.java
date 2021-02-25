package jan2021;
import java.util.*;

public class DanceMove {
	public static void main(String[] args) {
		String testinput = "5 4\n" + 
				"1 3\n" + 
				"1 2\n" + 
				"2 3\n" + 
				"2 4\n" + 
				"";
		Scanner scan = new Scanner(testinput);
		//Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		int[][] swaps = new int[K][2];
		PosCount[] NP = new PosCount[N];
		PosCount[] NPA = new PosCount[N];
		for (int i = 0; i < N; i++) {
			NP[i] = new PosCount();
			NP[i].visits.add(i);
			NPA[i] = NP[i];
		}
		for (int i = 0; i < K; i++) {
			swaps[i][0] = scan.nextInt()-1;
			swaps[i][1] = scan.nextInt()-1;
		}
		scan.close();
		//System.out.println(Arrays.deepToString(swaps));
		for (int i = 0; i < K; i++) {
			int s1 = swaps[i][0];
			int s2 = swaps[i][1];
			NPA[s1].visits.add(s2);
			NPA[s2].visits.add(s1);
			PosCount temp = NPA[s1];
			NPA[s1] = NPA[s2];
			NPA[s2] = temp;
			
		}
		for (int i = 0; i < N; i++) {
			NPA[i].end = i;
			//System.out.println(NP[i].visits);
		}
		HSI[] cows = new HSI[N];
		for (int i = 0; i < N; i++) {
			cows[i] = new HSI();
		}
		LinkedList<HSI> path = new LinkedList<HSI>();
		for (int i = 0; i < N; i++) {
			if (cows[i].done == -1) {
				cows[i].a.add(i);
				
				int pos = i;
				do {
					if (pos < i) {
						cows[i].a.addAll(cows[pos].a);
						break;
					}else {
						cows[i].a.addAll(NP[pos].visits);
						pos = NP[pos].end;
					}
					path.add(cows[pos]);
				} while (pos != i);
				System.out.print(path.size()+" ");
				System.out.println(cows[i].a.size());
				//
				for (HSI s: path) {
					s.done = cows[i].a.size();
				}
				
				path.clear();
			}else {
				System.out.println(cows[i].done);
			}
			
		}
		//System.out.println("poggers");
		
		
	}
}
class PosCount {
	int end;
	HashSet<Integer> visits = new HashSet<Integer>();
	
}
class HSI {
	int done = -1;
	HashSet<Integer> a = new HashSet<Integer>();
}
