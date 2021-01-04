package AJstuff;
public class AJArrayListTest {

	private static void _assert(boolean value) {
		if (value != true) {
			throw new RuntimeException("Failed Assert");
		} 
	}
	
	public static void assertEquals(Object a, Object b) {
		_assert(a.equals(b));
	}
	
	public static void assertEquals(boolean a, boolean b) {
		_assert(a==b);
	}
	
	public static void assertEquals(int i, int j) {
		_assert(i==j);
	}
//	public static void main(String[] args) {
//		AJArrayList<String> toTest = new AJArrayList<String>();
//		toTest.add("bruh");
//		toTest.add("bruh2");
//		for (String str : toTest) {
//			System.out.println(str);
//		}
//	}
	public static void main(String[] args) {
		AJArrayList<String> toTest = new AJArrayList<String>();
		assertEquals(toTest.size(), 0);
		
		boolean result1 = toTest.add("Java");
		assertEquals(result1, true);
		assertEquals(toTest.size(), 1);
		assertEquals(toTest.contains("Java"), true);
		assertEquals(toTest.contains("Class"), false);
		
		boolean result2 = toTest.add("Class");
		assertEquals(result2, true);
		assertEquals(toTest.size(), 2);
		assertEquals(toTest.contains("Java"), true);
		assertEquals(toTest.contains("Class"), true);

		boolean result3 = toTest.remove("Java");
		assertEquals(result3, true);
		assertEquals(toTest.size(), 1);
		assertEquals(toTest.contains("Java"), false);
		assertEquals(toTest.contains("Class"), true);
		
		assertEquals(toTest.contains("C++"), false);
		boolean result4 = toTest.remove("C++");
		assertEquals(result4, false);
		assertEquals(toTest.size(), 1);
		assertEquals(toTest.contains("Java"), false);
		assertEquals(toTest.contains("Class"), true);
		
		toTest.clear();
		assertEquals(toTest.size(), 0);
		assertEquals(toTest.contains("Java"), false);
		assertEquals(toTest.contains("Class"), false);
		
		for(int j = 0; j < 10; j+=1) {
			for(int i = 0; i < 100; i+=1) {
				toTest.add(""+i);
			}
			assertEquals(toTest.size(), 100);
			assertEquals(toTest.contains("50"), true);
			toTest.clear();
			assertEquals(toTest.size(), 0);
		}
		
		System.err.println("ALL TESTS PASSED!");
	}
}
