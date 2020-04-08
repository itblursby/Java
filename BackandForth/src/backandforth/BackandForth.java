package backandforth;
import java.io.*;
import java.util.*;

public class BackandForth {
	static ArrayList<Integer> results = new ArrayList<Integer>(0);
	public static void main(String[] args) throws Exception{
		
		File f = new File("backforth.in");
		Scanner s = new Scanner(f);
		PrintWriter pw = new PrintWriter(new File("backforth.out"));
		ArrayList<Integer> barn1 = new ArrayList<Integer>(0);
		ArrayList<Integer> barn2 = new ArrayList<Integer>(0);
		
		for (int i = 0; i < 10; i++) {
			barn1.add(s.nextInt());
		}
		for (int a = 0; a < 10; a++) {
			barn2.add(s.nextInt());
		}
		System.out.println(barn2);
		int milkbarn1;
		int milkbarn2;
		
		s.close();
		pw.close();
	}
	
	static void movefrombarn1(int bucket, int barn1, int day) {
		
		if (day < 4) {
			
		}
		if (day == 4) {
			results.add(barn1 - bucket);
		}
	}
	static void movefrombarn2(int bucket, int barn1, int day) {
		if (day < 4) {
			
		}
		if (day == 4) {
			results.add(barn1 + bucket);
		}
	}

}
