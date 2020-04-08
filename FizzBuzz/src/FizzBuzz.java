import java.io.*;
import java.util.*;
public class FizzBuzz {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("moobuzz.in"));
		PrintWriter p = new PrintWriter("moobuzz.out");
		int[] table = new int[] {1,2,4,7,8,11,13,14};
		int input = s.nextInt();
		//input = 16;
		input -= 1;
		
		int jump = (int) (15*Math.floor((input)/8));
		System.out.println(jump);
		
		int table2 = table[(input)%8];
		System.out.println(table2);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(jump+table2);
		p.print(jump+table2);
		s.close();
		p.close();
		
	}

}
