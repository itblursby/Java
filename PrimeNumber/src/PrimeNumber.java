
public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -30;
		System.out.println(prime(x));
		System.out.println(Math.sqrt(x));

	}
	static int prime(int v) {
		for (int i = 2; i <= Math.sqrt(v); i++) {
			System.out.println(v + "/" + i);
			if (v % i == 0) {
				
				return i;
			}
		}
		return v;
	}

}
