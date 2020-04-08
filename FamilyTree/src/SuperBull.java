import java.util.*;
import java.io.*;

public class SuperBull {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> IDs = new ArrayList(0);
		ArrayList<Integer> IDsc = new ArrayList(0);
		Scanner s = new Scanner(new File("superbull.in"));
		PrintWriter pw = new PrintWriter("superbull.out");
		int teams = s.nextInt();
		int new1 = -1;
		int current = 0;
		int scmax1 = -1;
		int scmax2 = -1;

		long sum = 0;
		for (int i = 0; i < teams; i++) {
			IDs.add(s.nextInt());
		}
		IDs.add(IDsc.get(0));
		IDsc.remove(0);
		for (int i = 0; i < teams; i++) {
			int max1 = current;
			int max2 = -1;
			for (int j = 0; j < IDsc.size() ; j++) {
				if ((IDs.get(current)^IDsc.get(j))>(max1^max2)) {
					
				}
			}
			
		}
		s.close();
		pw.close();
	}

}
