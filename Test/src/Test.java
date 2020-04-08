
public class Test {

	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void reheapDown(int heap[], int i, int N) {
		if(2*i >= N) {
			return;
		}

		int j = i;

		// Check left child
		if (heap[2*i] < heap[i]) {
			j = 2*i;
		}
		
		// Check right child - maybe
		if (2*i+1 < N) {
			if (heap[2*i+1] < heap[j]) {
				j = 2*i+1;
			}
		}
		
		// Reheap Down
		if (i != j) {
			swap(heap, i, j);
			reheapDown(heap, j, N);
		}
	}
	
	public static void reheapUp(int heap[], int i) {		
		if (i > 1 && heap[i] < heap[i/2]) {
			swap(heap, i, i/2);
			reheapUp(heap, i/2);
		}
	}
	
	public static void sort(int[] array) {
		int heap[] = new int[array.length+1];
		for(int i = 0; i < array.length; i+=1) {
			heap[i+1] = array[i];
			reheapUp(heap, i+1);
		}
		//this is what i changed
		for (int i = 0; i < array.length; i++) {
			array[i] = heap[1];
			heap[1] = Integer.MAX_VALUE;
			reheapDown(heap,  1,array.length);
		}
		//changes end here
		 // FINISH THIS FUNCTION so that array is sorted, by using heap[].
	}
	
	public static void main(String[] args) {
		int nums[] = new int[] {33, 7, 5, 9, 3, 6, 2, 9, 1, 0};
		sort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
