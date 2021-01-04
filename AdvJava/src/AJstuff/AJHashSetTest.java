package AJstuff;

public class AJHashSetTest {
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

	public static void main(String[] args) {
		AJHashSet<Integer> toTest = new AJHashSet<Integer>();
		assertEquals(toTest.size(), 0);
		//System.out.println("bruh1");
		boolean result1 = toTest.add(1);
		assertEquals(result1, true);
		assertEquals(toTest.size(), 1);
		assertEquals(toTest.contains(1), true);
		assertEquals(toTest.contains(2), false);
		//System.out.println("bruh2");

		boolean result2 = toTest.add(2);
		assertEquals(result2, true);
		assertEquals(toTest.size(), 2);
		assertEquals(toTest.contains(1), true);
		assertEquals(toTest.contains(2), true);
		//System.out.println("bruh3");

		boolean result3 = toTest.add(1);
		assertEquals(result3, false);
		assertEquals(toTest.size(), 2);
		assertEquals(toTest.contains(1), true);
		assertEquals(toTest.contains(2), true);
		//System.out.println("bruh4");
		boolean result4 = toTest.remove(1);
		assertEquals(result4, true);
		assertEquals(toTest.size(), 1);
		assertEquals(toTest.contains(1), false);
		assertEquals(toTest.contains(2), true);
		//System.out.println("bruh5");
		assertEquals(toTest.contains(30), false);
		boolean result5 = toTest.remove(30);
		assertEquals(result5, false);
		assertEquals(toTest.size(), 1);
		assertEquals(toTest.contains(1), false);
		assertEquals(toTest.contains(2), true);
		//System.out.println("bruh6");
		toTest.clear();
		assertEquals(toTest.size(), 0);
		assertEquals(toTest.contains(1), false);
		assertEquals(toTest.contains(2), false);

		for(int j = 0; j < 10; j+=1) {
			for(int i = 0; i < 100; i+=1) {
				toTest.add(i);
			}
			assertEquals(toTest.size(), 100);
			assertEquals(toTest.contains(50), true);
			toTest.clear();
			assertEquals(toTest.size(), 0);
		}

		System.err.println("ALL TESTS PASSED!");
	}
}
