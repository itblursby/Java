package apcs.wordcount;

public class Tester {
	static int[] arr = {1,2,4};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = findInsert(arr,3);
		System.out.println(x);
		System.out.println(arr[x]);
		
	}
	public static int findInsert(int[] arr, int subject) {
		if (arr.length == 0) {
			return 0;
		}
		
		if (arr[arr.length-1]<=subject) {
			return arr.length-1;
		}
		if (arr[0]>=subject) {
			return 0;
		}
		return findInsert2(arr, subject,1,arr.length-1);
	}
	public static int findInsert2(int[] arr, int subject, int begin, int end) {
		int tester = (begin+end)/2;
		//System.out.println("b"+arr[begin]+" t"+arr[tester]+" e"+arr[end]+" s"+subject);
		if (arr[tester]>=subject&&arr[tester-1]<subject) {
			return tester;
		}else if (arr[tester]>=subject&&arr[tester-1]>=subject) {
			return findInsert2(arr, subject, begin, tester);
		}else {
			return findInsert2(arr, subject, tester, end);
		}
	}

}
