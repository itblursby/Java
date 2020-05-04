import java.io.*;
import java.util.*;

public class socdist {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("socdist2.in"));
		int N = s.nextInt();
		//N = 2;
		Cow[] cows = new Cow[N];
		for (int i = 0; i < N; i++) {
			cows[i] = new Cow(s.nextInt(),s.nextInt());
		}
		s.close();
		//TEST AREA
//		cows = new Cow[] {new Cow(0,1),new Cow(1,1), new Cow(2,1)};
//		N = cows.length;
		//NO MORE
		Arrays.sort(cows);
		System.out.println(Arrays.toString(cows));
		int R = Integer.MAX_VALUE;
		for (int i = 0; i < N-1; i++) {
			if (cows[i].isSick()^cows[i+1].isSick()) {
				if (R > cows[i+1].position() - cows[i].position()) {
					R = cows[i+1].position() - cows[i].position();
				}
			}
		}
		R -= 1;
		System.out.println("R = " + R);
		int A = 0;
		boolean sick = false;
		for (int i = 0; i < N; i++) {
			if ((!sick)&&cows[i].isSick()) {
				A++;
				sick = true;
			} else if (sick&&(!cows[i].isSick())) {
				sick = false;
			}
//			if (cows[i].isSick()) {
//				if (cows[i+1].isSick()) {
//					if (cows[i+1].position()-cows[i].position()>R) {
//						
//					}
//				}else {
//					if (i+1 != cows.length-1) {
//						A++;
//					}
//				}
//				
//			}
		}
		for (int i = 0; i < N-1; i++) {
			if (cows[i].isSick()&&cows[i+1].isSick()) {
				if (cows[i+1].position()-cows[i].position()>R) {
					A++;
				}
			}
		}
		System.out.println(A);
		PrintWriter p = new PrintWriter("socdist2.out");
		p.println(A);
		p.close();
		
		
		
	}

}
class Cow implements Comparable{
	private int pos;
	private boolean sick;
	Cow(int pos_, int sick_){
		pos = pos_;
		sick = (sick_ == 1);
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Cow s = (Cow) o;
		return this.pos-s.pos;
	}
	public String toString() {
		if (sick) {
			return "sick cow at " + pos + "\n";
		}
		return "okay cow at "+pos+"\n";
	}
	public boolean isSick() {
		return sick;
	}
	public int position() {
		return pos;
	}
}