package shell2;
import java.io.*;
import java.util.*;
public class ShellGame2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		int maxscore = -1;
		if (maxscore < shell(1)) {
			maxscore = shell(1);
		}
		if (maxscore < shell(2)) {
			maxscore = shell(2);
		}
		if (maxscore < shell(3)) {
			maxscore = shell(3);
		}
		PrintWriter pw = new PrintWriter("shell.out");
		System.out.println(maxscore);
		pw.println(maxscore);
		pw.close();
		
	}
	static int shell(int pebble) throws Exception {
		Scanner s = new Scanner(new File("shell.in"));
		int p = pebble;
		int times = s.nextInt();
		int score = 0;
		int s1;
		int s2;
		int guess;
		for (int i = 0; i < times; i++) {
			s1 = s.nextInt();
			s2 = s.nextInt();
			guess = s.nextInt();
			if (s1 == p) {
				p = s2;
			}else if (s2 == p) {
				p = s1;
			}
			if (guess == p) {
				score++;
			}
		}		
		s.close();
		return score;

	}
}
