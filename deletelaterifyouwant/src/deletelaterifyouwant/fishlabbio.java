package deletelaterifyouwant;

import java.util.*;

public class fishlabbio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//allele p is true
		//allele q is false
		ArrayList<Boolean> genepool = new ArrayList<Boolean>(0);
		for (int i = 0; i < 20; i++) {
			genepool.add(true);
		}
		for (int i = 0; i < 20; i++) {
			genepool.add(false);
		}
		boolean counter = true;
		int blue;
		int green;
		int yellow;
		//System.out.println(genepool);
		for (int gen = 0; gen < 4; gen++) {
			blue = 0;
			green = 0;
			yellow = 0;
			Collections.shuffle(genepool);
			
			System.out.println("Generation " + (gen+2) + "------------");
			
			
			for (int i = 0; i < genepool.size()/2; i++) {
				if (genepool.get(i*2)&&genepool.get(i*2+1)) {
					//blue fish
					if (counter) {
						genepool.remove(i*2+1);
						genepool.remove(i*2);
					} else {
						blue++;
					}
					counter = !counter;
				} else if(genepool.get(i*2)^genepool.get(i*2+1)) {
					green++;
				} else {
					yellow++;
				}
			}
			System.out.println(genepool);
			System.out.println("\nTotal fish: " + (genepool.size()/2));
			System.out.println("Blue: " + blue);
			System.out.println("Green: " + green);
			System.out.println("Yellow: " + yellow);
			
		}
		
	}

}
