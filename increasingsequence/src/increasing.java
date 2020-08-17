import java.util.Arrays;

public class increasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] sequence = {10,6,5,7,2,4,3,1,8,9};
		int[] front = new int[sequence.length];
		
		int bestind = -1;
		int bestscore = -1;
		for (int i = 0; i < front.length; i++) {
			front[i] = -1;
		}
		int[] lengths = new int[sequence.length];
		for (int i = sequence.length - 1; i >= 0; i--) {
			//System.out.print("\n" + i + ": ");
			int result = -1;
			int index = -1;
			for (int j = i+1; j < sequence.length; j++) {
				
				if (sequence[j] > sequence[i]) {
					//System.out.print(j);
					if (lengths[j] > result) {
						result = lengths[j];
						index = j;
					}
				}
			}
			if (index != -1) {
				front[i] = index;
				//System.out.println("hi"+result);
				lengths[i] = result + 1;
			}
			if (lengths[i] > bestscore) {
				bestind = i;
				bestscore = lengths[i];
			}
			
		}
		System.out.println("\n---");
		System.out.println(Arrays.toString(sequence));
		System.out.println(Arrays.toString(front));
		System.out.println(Arrays.toString(lengths));
		System.out.println(bestind);
		
		int index = bestind;
		for (int i = 0; i < bestscore; i++) {
			
		}


		
	}

}
