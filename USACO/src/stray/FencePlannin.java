//http://usaco.org/index.php?page=viewproblem2&cpid=944
//package stray;

import java.util.*;
import java.io.*;

public class FencePlannin {
	private static int minper = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		minper = Integer.MAX_VALUE;
		Scanner s = new Scanner(new File("fenceplan.in"));
		int N = s.nextInt();
		int M = s.nextInt();
//		System.out.println(N);
//		System.out.println(M);

		int[] parent = new int[N];
		int[][] points = new int[N][2];
		int[][] edges = new int[N][4]; //minx maxx miny maxy
		for (int i = 0; i < N; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			parent[i] = i;
			points[i][0] = x;
			points[i][1] = y;
			edges[i][0] = x;
			edges[i][1] = x;
			edges[i][2] = y;
			edges[i][3] = y;
		}
		for (int i = 0; i < M; i++) {
			int a = s.nextInt()-1;
			int b = s.nextInt()-1;
			join(a,b,points,parent,edges);
		}
		s.close();
		for (int i = 0; i < N; i++) {
			int test = edges[i][1]-edges[i][0];
			if (test < 0) {
				continue;
			}
			int per = edges[i][1] - edges[i][0] + edges[i][3] - edges[i][2];
			per *= 2;
			if (per < minper) {
				minper = per;
			}
		}
		System.out.println(minper);
		PrintWriter p = new PrintWriter("fenceplan.out");
		p.println(minper);
		p.close();
	}
	public static void join(int a, int b, int[][] points, int[] parent, int[][] edges) {
		int pa = getParent(a,parent);
		int pb = getParent(b,parent);
		if (pa != pb) {
			parent[pa] = pb;
			edges[pb][0] = Math.min(edges[pa][0],edges[pb][0]);
			edges[pb][1] = Math.max(edges[pa][1],edges[pb][1]);
			edges[pb][2] = Math.min(edges[pa][2],edges[pb][2]);
			edges[pb][3] = Math.max(edges[pa][3],edges[pb][3]);
			edges[pa][0] = 1;
			edges[pa][1] = 0;
			edges[pa][2] = 1;
			edges[pa][3] = 0;
		}

	}
	public static int getParent(int a, int[] parent) {
		if (parent[a] == a) {
			return a;
		}else {
			int result = getParent(parent[a],parent);
			parent[a] = result;
			return result;
		}
	}

}
//class Cow {
//	Cow parent;
//	in
//}