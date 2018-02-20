import java.util.*;
class allpathDriver
{
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int q = in.nextInt();
		AllPaths g = new AllPaths(n);
		for(int i=0;i<m;i++) {
			int u = in.nextInt()-1;
			int v = in.nextInt()-1;
			g.addEdge(u,v);
		}
		for(int i=0;i<q;i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			int med = in.nextInt()-1;
			g.printAllPath(x,y,med);
		}
		
	}
}
