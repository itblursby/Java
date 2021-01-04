package dec2020;
import java.util.Scanner;
import java.util.ArrayList;
public class Cowntagion {
	public static void main(String[] args) {
		String testinput = 
			"4\n" + 
			"1 2\n" + 
			"1 3\n" + 
			"1 4";
		//Scanner s = new Scanner(testinput);
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int[] pathcount = new int[N];
		for (int i = 0; i < N-1; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			pathcount[a-1] = pathcount[a-1]+1;
			pathcount[b-1] = pathcount[b-1]+1;
		}
		int total = 0;
		for (int i = 0; i < pathcount.length; i++) {
			if (i == 0) {
				total += findLeastP2(pathcount[i]+1);
				total += pathcount[i];
			}else {
				total += findLeastP2(pathcount[i]);
				total += pathcount[i]-1;
			}
			
		}
		System.out.println(total);
	}
	static int findLeastP2(int paths) {
		int x = 1;
		int n = 0;
		while(x < paths) {
			n++;
			x <<= 1;
		}
		return n;
	}

}
