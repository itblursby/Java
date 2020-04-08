package shell;
import java.io.*;
import java.util.*;
public class ShellGame {

	int[] inline = new int[3];
	static Scanner s;
	public static void main(String[] args) throws Exception {
		
		PrintWriter p = new PrintWriter("shell.out");
		int maxscore = -1;
		if (shell(1)>maxscore) {
			maxscore = shell(1);
		}
		if (shell(2)>maxscore) {
			maxscore = shell(2);
		}
		if (shell(3)>maxscore) {
			maxscore = shell(3);
		}
		/*System.out.println(shell(1));
		System.out.println(shell(2));
		System.out.println(shell(3));*/
		//System.out.println(maxscore);
		s.close();
		p.println(maxscore);
		p.close();
	}
	static int shell(int pl) throws Exception {
		int score = 0;
		s = new Scanner(new File("shell.in"));
		int swaps = s.nextInt();
		int pebble = pl;
		for (int i = 0; i < swaps; i ++) {
			int swap = s.nextInt();
			int swap2 = s.nextInt();
			int guess = s.nextInt();
			if (pebble == swap) {
				pebble = swap2;
			}else if (pebble == swap2){
				pebble = swap;
			}
			if (guess == pebble) {
				score++;
			}
		}
		return score;
	}
}