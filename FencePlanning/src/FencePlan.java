import java.util.*;
import java.io.*;
public class FencePlan {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("fenceplan.in"));
		PrintWriter p = new PrintWriter("fenceplan.out");
		int numcows = s.nextInt();
		int numconnects = s.nextInt();
		int[][] cows = new int[numcows][3]; //cow ID, X, Y
		for (int i = 0; i < numcows; i++) {
			cows[i][0] = i;
			cows[i][1] = s.nextInt();
			cows[i][2] = s.nextInt();
			//System.out.println(cows[i][2]);
		}
		
		ArrayList<Integer>[] connects = new ArrayList[numcows];
		for (int i = 0; i < connects.length; i++) {
			connects[i] = new ArrayList(0);
		}
		for (int i = 0; i < numconnects; i++) {
			int a = s.nextInt()-1;
			int b = s.nextInt()-1;
			connects[a].add(b);
			connects[b].add(a);
			
		}
		ArrayList< ArrayList<Integer> > networks = new ArrayList(0);
		
		ArrayList<Integer> queue = new ArrayList();
		
		queue.add(0);
		boolean[] visited = new boolean[numcows];
		for (int i = 0; i < numcows; i++) {
			visited[i] = false;
		}
		int pointer = 0;
		
		while (pointer < numcows) {
			while (visited[pointer]) {
				pointer++;
				if (pointer == numcows) {
					break;
				}
			}
			if (pointer == numcows) {
				break;
			}
			queue.add(pointer);
			networks.add(new ArrayList(0));
			while (queue.size() > 0) {
				
				
			}
			
		}
		
		
		
		
		s.close();
		p.close();
	}

}
