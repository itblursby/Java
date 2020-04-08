package secretsanta;
import java.util.Random;
public class SecretSanta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p = 5;
		Random r = new Random();
		for (int i = 0; i < p; i++) {
			System.out.print("\n");
			System.out.print(i);
			int santa = r.nextInt(p-i);
			if (santa >= i) {
				santa++;
			}
			System.out.print("-"+santa);
		}
	}

}
