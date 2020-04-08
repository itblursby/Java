import java.util.*;
import java.io.*;
public class WhereAmI {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("whereami.in"));
		PrintWriter p = new PrintWriter("whereami.out");
		int mailboxes = s.nextInt();
		String colors = s.next();
		System.out.println(colors);
		
		int i;
		boolean K = true;

		for (i = 1; i < mailboxes+1; i++) {
			K = true;
			for (int m = 0; m < mailboxes - i + 1; m++) {
				for (int n = m+1; n < mailboxes - i + 1; n++) {
					System.out.println("compare " + 
				colors.substring(m,m+i) + " " + colors.substring(n,n+i));
					if (colors.substring(m,m+i).equals(colors.substring(n,n+i))) {
						K = false;
					}
					
				}
			}
			if (K == true) {
				System.out.println(i);
				break;
			}
			
		}
		System.out.println(i);

		/*for (int f = 0; f < colors.length()+1; f++) {
			System.out.println(colors.substring(0,f));
		}*/
		p.println(i);
		s.close();
		p.close();
		
	}

}
