package coincount;

import java.util.*;
import java.io.*;

public class coin {
	
	
	public static void main(String[] args) throws IOException {
		int total = 249;
		Integer[] coins = {1,2,4,8,16,32,64};
		
//		System.out.println(coins.length);
		Queue<Integer> q = new LinkedList<Integer>();
		HashMap<Integer,Integer> table = new HashMap<Integer, Integer>(total/2);
		q.add(0);
		boolean done = false;
		while(q.size() > 0 && !done) {
			int current = q.remove();
				for (int i = 0; i < coins.length && !done; i++) {
					Integer key = new Integer(current + coins[i]);
					if (!(key.intValue() > total)) {
						if (!table.containsKey(key)) {
							table.put(key,current);
//							System.out.println("added " + Integer.toString(key) + "," + current);
							q.add(key);
							if (key.intValue() == total) {
								done = true;
							}
							
						}
					}
				}
			
		}
		
		if (done) {
			System.out.println("possible");
			int current = total;
			while (current > 0) {
				System.out.print(current - table.get(current)+" ");
				current = table.get(current);
			}
		} else {
			System.out.println("impossible");
		}
		
		
		
		
	}

}
