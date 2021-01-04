package dec2020;

import java.util.*;

public class StuckInRut {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println("test");
		// System.out.println(first(new CowSIR()));
		String testinput = "6\n" + "E 3 5\n" + "N 5 3\n" + "E 4 6\n" + "E 10 4\n" + "N 11 1\n" + "E 9 2\n";
		Scanner s = new Scanner(testinput);
		int N = s.nextInt();
		CowSIR[] cows = new CowSIR[N];
		CowSIR[] cows2 = new CowSIR[N];
		for (int i = 0; i < N; i++) {
			boolean dir = false;
			int x;
			int y;
			String d = s.next();
			if (d.equals("N")) {
				dir = true;
			} else if (d.equals("E")) {
				dir = false;
			}
			x = s.nextInt();
			y = s.nextInt();
			CowSIR cow = new CowSIR(x, y, dir);
			cow.id = i;
			cows[i] = cow;
			cows2[i] = cow;
		}
		s.close();
		Arrays.sort(cows2);
		System.out.println(Arrays.deepToString(cows2));
		ArrayList<CowSIR> iup = new ArrayList<CowSIR>();
		for (int i = 0; i < N; i++) {
			CowSIR current = cows2[i];
			if (current.dir) {
				iup.add(current);
			} else {
				//CowSIR[] stop = new CowSIR[iup.size()];
				for (int j = 0; j < iup.size(); j++) {
					int state = first(iup.get(j), current);
					stop[j] = iup.get(j);
					stop[j].hold = state;
				}

				for (int j = 0; j < stop.length; j++) {
					// System.out.println("yes");
					if (stop[j].hold > 0) {
						System.out.println("new stop " + stop[j].id + " " + current.id);
						stop[j].stop(current);
						break;
					} else if (stop[j].hold < 0) {
						System.out.println("new stop " + current.id + " " + stop[j].id);
						current.stop(stop[j]);

					}
				}
			}
		}
		for (int i = 0; i < cows.length; i++) {
			System.out.println(cows[i].blame);
			// System.out.println(cows[i].stopper == null);
		}
		// System.out.println("done");
	}

	public static int first(CowSIR a, CowSIR b) {
		// time until collision
		// -: b stops a
		// +: a stops b
		// 0: no collision

		// cow a is N
		// cow b is E
		if (b.x > a.x) {
			return 0;
		}
		int x = a.x;
		int y = b.y;
		if ((x - b.x) > (y - a.y)) {
			return (y - a.y);
		} else if ((x - b.x) < (y - a.y)) {
			return -(x - b.x);
		}
		return 0;
	}
}

class CowSIR2 implements Comparator<CowSIR> {
	public int compare(CowSIR a, CowSIR b) {
		return Math.abs(a.hold) - Math.abs(b.hold);
	}
}

class CowSIR implements Comparable<CowSIR> {
	int hold;
	int id;
	CowSIR stopper = null;
	int x;
	int y;
	boolean dir;
	int blame = 0;

	CowSIR(int x, int y, boolean dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public void stop(CowSIR other) {
		other.stopper = this;
		// stopper = other;
		this.blame();
	}

	public void blame() {
		this.blame = this.blame + 1;
		if (stopper != null) {
			stopper.blame();
		}
	}

	@Override
	public int compareTo(CowSIR other) {
		return this.y - other.y;
	}

	@Override
	public String toString() {
		return "cow " + (dir ? "north" : "east") + "(" + x + "," + y + ")";
	}
}