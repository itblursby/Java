import java.util.*;
public class Zelda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 24; i++) {

		      ArrayList<String> wordst = new ArrayList<String>(0);
		      wordst.add("Wild");
		      wordst.add("Breath");
		      wordst.add("Zelda");
		      wordst.add("Legend");
		      ArrayList<String> out = new ArrayList<String>(0);
		      int t = i;
		      out.add(0, wordst.get(t%4));
		      wordst.remove(t%4);
		      t /= 4;
		      out.add(0, wordst.get(t%3));
		      wordst.remove(t%3);
		      t /= 3;
		      out.add(0, wordst.get(t%2));
		      wordst.remove(t%2);
		      t /= 2;
		      out.add(0, wordst.get(t));
		      wordst.remove(t%1);

		      System.out.println("The "+ out.get(0)+" of " + out.get(1) + ": " +out.get(2) + " of the " + out.get(3));
		    }
	}

}
