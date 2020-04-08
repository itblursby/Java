import java.util.*;
import java.io.*;
public class MilkFactory {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(new File("factory.in"));
		PrintWriter p = new PrintWriter("factory.out");
		int total = s.nextInt();
		ArrayList[] tree = new ArrayList[total];
		for (int i = 0; i < tree.length;i++) {
			tree[i] = new ArrayList<Integer>(0);
		}
		
		
		while(s.hasNext()) {
			int s1 = s.nextInt()-1;
			int s2 = s.nextInt()-1;
			System.out.println(s1);
			System.out.println(s2);
			tree[s1].add(s2);
		}
		for (int i = 0;i < total; i++) {
			
		}
		s.close();
		p.close();

	}

}
