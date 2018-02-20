/*
 * Program Description:
 * Date Created: Fri 15 Dec 2017 10:43:58 AM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class Point {
	int x,y,d;
	public Point(int x,int y,int d) {
		this.x = x; 
		this.y = y;
		this.d = d;
	}
}
class redknightshortest
{
	static int[] row = {-2,-2,0,2,2,0};
	static int[] col = {-1,1,2,1,-1,-2};
	static Point[][] back;
	static int[][] dp;
	static boolean[][] vis;
	static int n;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int sx = in.nextInt();
		int sy = in.nextInt();
		int dx = in.nextInt();
		int dy = in.nextInt();
		dp = new int[n][n];
		for(int i=0; i<n; i++)
			Arrays.fill(dp[i],Integer.MAX_VALUE);
		dp[sx][sy] = 0;
		back = new Point[n][n];
		back[sx][sy] = new Point(-1,-1,0);
		vis = new boolean[n][n];
		vis[sx][sy] = true;
		int dist = bfs(sx,sy,dx,dy);
		if(dist == -1) {
			System.out.println("Impossible");
		} else {
			System.out.println(dist);
			print(dx,dy);
		}
	}
	public static void print(int u, int v) {
		Stack<String> s = new Stack<>();
		int x = 0;
		int y = 0;
		while(true) {
			x = back[u][v].x;
			y = back[u][v].y;
			if(x==-1 && y==-1)
				break;
			s.push(getPos(x,y,u,v));
			u=x;
			v=y;
		}
		while(!s.isEmpty()){
			System.out.print(s.pop()+" ");
		}
		System.out.println();

	}
	public static String getPos(int x, int y,int u, int v) {
		//System.out.println(x+" "+y+" "+u+" "+v);
		if((x+row[0]) == u && (y+col[0]) == v)
			return "UL";
		if((x+row[1]) == u && (y+col[1]) == v)
			return "UR";
		if((x+row[2]) == u && (y+col[2]) == v)
			return "R";
		if((x+row[3]) == u && (y+col[3]) == v)
			return "LR";
		if((x+row[4]) == u && (y+col[4]) == v)
			return "LL";
		return "L";
	}
	public static boolean isValid(int x, int y) {
		return (0<=x&&x<n && 0<=y&&y<n);
	}
	public static int bfs(int x, int y, int dx, int dy) {
		if(x==dx && dy == y)
			return 0;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y,0));
		while(!q.isEmpty()) {
			Point cur = q.poll();
			//System.out.println("Cur "+cur.x+" "+cur.y);
			if(cur.x == dx && cur.y == dy) {
				return cur.d;
			}
			for(int i=0; i<6; i++) {
				int r = cur.x+row[i];
				int c = cur.y+col[i];
				if(isValid(r,c) && !vis[r][c]) {
				//System.out.println(r+" "+c);
					Point t =new Point(cur.x,cur.y,cur.d+1);
					back[r][c] = t;
					q.add(new Point(r,c,cur.d+1));
					vis[r][c] = true;
				}
			}
		}
		return -1;

	}
}

