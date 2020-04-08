import java.util.*;
import java.io.*;
public class Triangle {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("triangles.in"));
		PrintWriter p = new PrintWriter("triangles.out");
		
		HashMap<Integer, ArrayList<Point>> X = new HashMap<Integer, ArrayList<Point>>();
		HashMap<Integer, ArrayList<Point>> Y = new HashMap<Integer, ArrayList<Point>>();
		int N = s.nextInt();
		Point[] points = new Point[N];
		
		
		for (int i = 0; i < N; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			Point a = new Point(x,y);
			if (X.containsKey(x)) {
				ArrayList<Point> t = X.get(x);
				t.add(a);
				X.put(x,t);
			} else {
				ArrayList<Point> t = new ArrayList<Point>(0);
				t.add(a);
				X.put(x,t);
			}
			if (Y.containsKey(y)) {
				ArrayList<Point> t = Y.get(y);
				t.add(a);
				Y.put(y,t);
			} else {
				ArrayList<Point> t = new ArrayList<Point>(0);
				t.add(a);
				Y.put(y,t);
			}
			points[i] = a;

		}
		long total = 0;
		for (int i = 0; i < N; i++) {
			//points[i].print();
			ArrayList<Point> x1 = X.get(points[i].x);
			
			System.out.println("");
			ArrayList<Point> y1 = Y.get(points[i].y);
			
			for (int j = 0; j < x1.size(); j++) {
				if (!x1.get(j).eq(points[i])) {
				//x1.get(j).print();
					for (int k = 0; k < y1.size(); k++) {
						if (!y1.get(k).eq(points[i])) {
							//y1.get(k).print();
							int x = Math.abs((x1.get(j).y-points[i].y)*(y1.get(k).x-points[i].x));
							total += x;
							System.out.println(x1.get(j).ts()+points[i].ts()+y1.get(k).ts()+x);
							//System.out.println("bruh");
						}
					}
				}
			}
			System.out.println("");
			
		}
		System.out.println(total%1000000007);
		p.println(total);
		s.close();
		p.close();
	}
	

}
class Point {
	public int x;
	public int y;
	Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	void print() {
		System.out.println("("+x+","+y+")");
	}
	String ts() {
		return "("+x+","+y+")";
	}
	boolean eq(Point b) {
		if (x == b.x && y == b.y) {
			return true;
		}
		return false;
	}
	
}
