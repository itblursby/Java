//problem 491

package stray;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Piggyback {

	public static void main(String[] args) throws FileNotFoundException {
		String testinput = "4 4 5 8 8\n" + "1 4\n" + "2 3\n" + "3 4\n" + "4 7\n" + "2 5\n" + "5 6\n" + "6 8\n" + "7 8\n"
				+ "";
		Scanner s = new Scanner(new File("piggyback.in"));
		int bEne = s.nextInt();
		int eEne = s.nextInt();
		int pEne = s.nextInt();
		int farms = s.nextInt();
		int roads = s.nextInt();
		NodePiggyback[] world = new NodePiggyback[farms];
		for (int i = 0; i < world.length; i++) {
			world[i] = new NodePiggyback();
		}
		for (int i = 0; i < roads; i++) {
			int A = s.nextInt() - 1;
			int B = s.nextInt() - 1;
			world[A].adj.add(world[B]);
			world[B].adj.add(world[A]);
		}
		LinkedList<NodePiggyback> queue = new LinkedList<>();
		
		// TODO Auto-generated method stub

	}

}

class NodePiggyback {
	int distance = 0;
	int visitid = -1;
	ArrayList<NodePiggyback> adj = new ArrayList<>();

	NodePiggyback() {

	}

}