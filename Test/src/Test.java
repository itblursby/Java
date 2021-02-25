
public class Test {
	static String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	public static void main(String[] args) {
		int levels = 0;
		String[] primitives = {"int","double","float","long","boolean","byte","class"};
		
		
		for (int i = 0; i < 200; i++) {
			System.out.print(randomAChar());
		}
	}
	public static String randomString(int length) {
		String s = "";
		return s;
		
	}
	public static char randomAChar() {
		return (char)('A'+((int)Math.random()*95)+Math.random()>0.5?32:0);
	}

}

