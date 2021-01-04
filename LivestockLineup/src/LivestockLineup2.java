import java.util.*;
import java.io.*;
public class LivestockLineup2 {
	static int[][] constraints;
	static PrintWriter p;
	static String[] cownames;
	static boolean done = false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("lineup.in"));
		p = new PrintWriter("lineup.out");
		//p.print('\n');
		cownames = new String[] {"Beatrice","Belinda","Bella","Bessie","Betsy","Blue","Buttercup","Sue"};
		int numcons = s.nextInt();
		constraints = new int[numcons][2];
		for (int i = 0; i < numcons; i++) {
			constraints[i][0] = findString(cownames,s.next());
			s.next();s.next();s.next();s.next();
			constraints[i][1] = findString(cownames,s.next());
		}
		generate(8);
		s.close();
		p.close();
		
		
	}
	static int findString(String[] bruh, String bruh2) {
		for (int i = 0; i < bruh.length; i++) {
			if (bruh[i].equals(bruh2)) {
				return i;
			}
		}
		return -1;
	}
	public static void generate(int length){
        ArrayList<Integer> nums = new ArrayList<Integer>(length);
        for (int i = 0; i < length; i++){
            nums.add(i);
        }
        generateHelper(new int[length],0,nums);
    }
	public static void generateHelper(int[] positions, int index, List<Integer> numsleft){
        if (index == positions.length){
        	boolean good = true;
            //System.out.print(Arrays.toString(positions));
        	for (int i = 0; i < constraints.length; i++) {
        		if (!(positions[constraints[i][0]]-positions[constraints[i][1]]==1)) {
        			if (!(positions[constraints[i][0]]-positions[constraints[i][1]]==-1)) {
        				good = false;
            			break;
            		}
        		}
        	}
        	if (good) {
        		int[] readable = new int[positions.length];
                for (int i = 0; i < positions.length; i++){
                    readable[positions[i]] = i;
                }
                for (int i = 0; i < 8; i++) {
                	p.println(cownames[readable[i]]);
                	System.out.println(cownames[readable[i]]);
                }
                done = true;
        	}
            return;
        }
        if (!done) {
        for (int i = 0; i < positions.length - index; i++){
            int numremoved = numsleft.remove(i);
            positions[numremoved] = index;
            //positions[index] = numremoved;
            
            generateHelper(positions, index + 1, numsleft);
            numsleft.add(i,numremoved);
        }}
        
    }

}
