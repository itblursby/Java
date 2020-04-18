import java.io.*;
import java.util.*;

public class socdist {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("socdist2.in"));
		PrintWriter p = new PrintWriter("socdist2.out");
		//System.out.println(s.nextLine());
		int N = s.nextInt();
		int R;
		Cow[] cows = new Cow[N];
		for (int i = 0; i < N; i++) {
			cows[i] = new Cow(s.nextInt() == 1, s.nextInt());
		}
		Arrays.sort(cows);
		System.out.println(cows.toString());
		s.close();
		p.close();
	}

}
class Cow implements Comparable{
	boolean isSick;
	int pos;
	Cow(boolean sick, int posi){
		isSick = sick;
		pos = posi;
	}
	public int compareTo(Object obj) {
		Cow other = (Cow) obj;
		return other.pos - this.pos;
	}
	public String toString() {
		if (isSick) {
			return "Sick cow at " + pos;
		} else {
			return "Healthy cow at " + pos;
		}
	}
	
	
}