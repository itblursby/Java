//bronze 3
package jan2021;
import java.util.Scanner;
import java.util.Arrays;
public class JustStallin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String testinput = "4\n"+"1 2 3 4\n"+"2 2 3 3";
		Scanner s;
		s = new Scanner(System.in);
		//s = new Scanner(testinput);
		int N = s.nextInt();
		int[] cows = new int[N];
		int[] stalls = new int[N];
		for (int i = 0; i < N; i++) {
			cows[i] = s.nextInt();
		}
		for (int i = 0; i < N; i++) {
			stalls[i] = s.nextInt();
		}
		s.close();
		Arrays.sort(cows);
		Arrays.sort(stalls);
//		System.out.println(Arrays.toString(cows));
//		System.out.println(Arrays.toString(stalls));
		long ways = 1;
		int cC = 0;
		int cS = 0;
		int count = 0;
		while(cS < N) {
			while(cC < N && cows[cC] <= stalls[cS]) {
				cC++;
				count++;
			}
			cS++;
			
			ways *= count;
			//System.out.println(count);
			count--;
		}
		System.out.println(ways);
		
		
	}

}
