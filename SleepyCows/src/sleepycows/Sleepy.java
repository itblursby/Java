//Problem URL:
//http://usaco.org/index.php?page=viewproblem2&cpid=915
package sleepycows;
import java.io.*;
import java.util.*;
public class Sleepy {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File in = new File("herding.in");
		Scanner s = new Scanner(in);
		//PrintWriter e = new PrintWriter(in);
		/*int[] pos = new int[3];
		pos[0] = s.nextInt();
		pos[1] = s.nextInt();
		pos[2] = s.nextInt();
		int maxi = Math.max(Math.max(pos[0], pos[1]), pos[2]);
		int mini = Math.min(Math.min(pos[0], pos[1]), pos[2]);
		s.close();
		if (maxi - mini == 2) {
			e.println(0);
		} else if (maxi - mini == 3) {
			e.println(1);
		} else if (maxi - mini > 3)*/
		System.out.println(s.nextInt());
		System.out.println(s.nextInt());
		System.out.println(s.nextInt());
		s.close();
	}

}
