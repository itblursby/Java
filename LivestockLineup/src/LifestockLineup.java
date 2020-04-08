import java.io.*;
import java.util.*;
public class LifestockLineup {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("lineup.in"));
		PrintWriter p = new PrintWriter("lineup.out");
		String[] cownames = new String[] {"Beatrice","Belinda","Bella","Bessie","Betsy","Blue","Buttercup","Sue"};
		int hmc = s.nextInt();
		int[][] constraints = new int[hmc][2];

		for (int i = 0; i < hmc; i++) {
			constraints[i][0] = findString(cownames,s.next());
			s.next();s.next();s.next();s.next();
			constraints[i][1] = findString(cownames,s.next());
		}
		
		s.close();
		//System.out.println(constraints[0][0]);
		ArrayList<String> cows2 = new ArrayList<String>(0);

		for (int i = 0; i < 8; i++) {
			cows2.add("" + i);
		}
		
		for (int i = 0; i < hmc; i++) {
			String newchunk = "bruh";
			int cow1 = constraints[i][0];
			int cow2 = constraints[i][1];
			int index1 = findInt(cows2,cow1);
			int index2 = findInt(cows2,cow2);
			String bruh1 = cows2.get(index1);
			String bruh2 = cows2.get(index2);
			cows2.remove(bruh1);
			cows2.remove(bruh2);
			if (bruh1.length() == 1 && bruh2.length() == 1) {
				if (Integer.parseInt(bruh1)>Integer.parseInt(bruh2)) {
					newchunk = bruh2 + bruh1;
				}else {
					newchunk = bruh1 + bruh2;
				}
			} else {
				int back1 = -1;
				int back2 = -1;
				if (bruh1.substring(0,1).equals(cow1 + "")) {
					back1 = Integer.parseInt(bruh1.substring(bruh1.length()-1));
				}else {
					back1 = Integer.parseInt(bruh1.substring(0,1));

				}
				if (bruh2.substring(0,1).equals(cow2 + "")) {
					back2 = Integer.parseInt(bruh2.substring(bruh2.length()-1));
				} else {
					back2 = Integer.parseInt(bruh2.substring(0,1));

				}
				if (back2 < back1) {
					if (bruh1.substring(bruh1.length()-1).equals(cow1+"")) {
						bruh1 = new StringBuilder(bruh1).reverse().toString();
					}
					if (bruh2.substring(0,1).equals(cow2+"")) {
						bruh2 = new StringBuilder(bruh2).reverse().toString();
					}
					newchunk = bruh2 + bruh1;
					/*
					if (bruh1.substring(0,1).equals(cow1 + "")) {
						
						if (bruh2.substring(bruh2.length()-1) != cow2 + "") {
							System.out.println("a"+bruh2);
							bruh2 = new StringBuilder(bruh2).reverse().toString();
							System.out.println("a"+bruh2);
						}
						newchunk = bruh2+bruh1;
					}else {
						if (bruh2.substring(0,1) != cow2 + "") {
							System.out.println("a"+bruh2);
							bruh2 = new StringBuilder(bruh2).reverse().toString();
							System.out.println("a"+bruh2);
						}
						newchunk = bruh1+bruh2;
						
					}*/
				} else {
					if (bruh1.substring(0,1).equals(cow1+"")) {
						bruh1 = new StringBuilder(bruh1).reverse().toString();
					}
					if (bruh2.substring(bruh2.length()-1).equals(cow2+"")) {
						bruh2 = new StringBuilder(bruh2).reverse().toString();
					}
					newchunk = bruh1 + bruh2;
					/*
					if (bruh2.substring(0,1).equals(cow2+ "")) {
						
						if (bruh1.substring(bruh1.length()-1) != cow1 + "") {
							System.out.println("a"+bruh1);
							bruh1 = new StringBuilder(bruh1).reverse().toString();
							System.out.println("a"+bruh1);
						}
						newchunk = bruh1+bruh2;
					}else {
						if (bruh1.substring(0,1) != cow2 + "") {
							System.out.println("a"+bruh2);
							bruh1 = new StringBuilder(bruh1).reverse().toString();
							System.out.println("a"+bruh2);
						}
						newchunk = bruh2+bruh1;
					}*/
				}
				
			}
			
			
			int one = Integer.parseInt(newchunk.substring(0,1));
			//System.out.println("test" + newchunk.substring(0,1));
			for (int h = 0; h < cows2.size(); h++) {
				if (Integer.parseInt(cows2.get(h).substring(0,1)) > one) {
					cows2.add(h,newchunk);
					break;
				}
			}
		}
		
		String end = "";
		for (int test = 0; test < cows2.size(); test++) {
			end = end + cows2.get(test);
		}
		for (int w = 0; w < cows2.size(); w++) {
			System.out.print(cows2.get(w));
		}
		System.out.print("\n");
		for (int w = 0; w < 8; w++) {
			p.println(cownames[Integer.parseInt(end.substring(w,w+1))]);
			System.out.println(cownames[Integer.parseInt(end.substring(w,w+1))]);
		}
		
		
		
		/*
		ArrayList<Integer> twobinds = new ArrayList(0);
		for (int i = 0; i < 8; i++) {
			int binds = 0;
			ArrayList<Integer> bindedwith = new ArrayList(0);
			for (int j = 0; j < hmc; j++) {
				if (constraints[j][0] == i) {
					binds++;
					bindedwith.add(constraints[j][1]);
				}
				if (constraints[j][1] == i) {
					binds++;
					bindedwith.add(constraints[j][0]);
				}
			}
			if (binds == 2) {
				twobinds.add(i);
				twobinds.add(bindedwith.get(0));
				twobinds.add(bindedwith.get(1));
			}
		}
		ArrayList<Integer> cows2 = cows;

		ArrayList<String> chunks = new ArrayList(0);
		for (int i = 0; i < twobinds.size()/3; i += 3) {
			if (twobinds.get(1) > twobinds.get(2)) {
				chunks.add("" + twobinds.get(2) + twobinds.get(0) + twobinds.get(1));
				
			}
		}
		
		System.out.println(chunks.get(0));
		p.close();*/
		p.close();
		s.close();
	}
	static int findInt(ArrayList<String> k, int j) {
		for (int i = 0; i < k.size(); i++) {
			if (k.get(i).substring(0,1).equals(j+"")) {
				return i;
			}
			if (k.get(i).substring(k.get(i).length()-1).equals(j+"")) {
				return i;
			}
		}
		return -1;
	}
	static int findString(String[] bruh, String bruh2) {
		for (int i = 0; i < bruh.length; i++) {
			if (bruh[i].equals(bruh2)) {
				return i;
			}
		}
		return -1;
	}
	

}
