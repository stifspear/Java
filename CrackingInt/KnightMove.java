/*
 * Program Description:
 * Date Created: Tue 10 Oct 2017 07:38:52 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class Point {
	int x,y,cost;
	Point(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
class KnightMove
{
	//static int count = 0;
	static int size;
	static Queue<Point> queue;
	static boolean[][] visited;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		size = in.nextInt();
		for(int i=1; i<size; i++){
			for(int j=1; j<size; j++) {
				queue = new LinkedList<>();
				visited = new boolean[size][size];
				System.out.print(makeMove(0,0,i,j)+" ");
			}
			System.out.println();
		}
	}
	public static boolean isValid(int x,int y) {
		//System.out.println(x+" "+y);
		if(!(x>=0 && x<size))
			return false;
		if(!(y>=0 && y<size))
			return false;
		return true;
	}
	public static int makeMove(int x, int y, int a, int b) {
		/*if(x == size-1 && y == size-1)
			return count;
		if(!isValid(x,y))
			return -1;*/
		queue.add(new Point(x,y,0));
		//System.out.println("Start "+x+" "+y);
		while(!queue.isEmpty()){
			Point cur = queue.poll();
			int tx = cur.x;
			int ty = cur.y;
			int count = cur.cost;
			if(tx == size-1 && ty == size-1)
				return cur.cost;
			visited[tx][ty] = true;
			if(isValid(tx+a,ty+b)&&!visited[tx+a][ty+b]){
				queue.add(new Point(tx+a,ty+b,count+1));
			}
			if(isValid(tx+a,ty-b)&&!visited[tx+a][ty-b]){
				queue.add(new Point(tx+a,ty-b,count+1));
			}
			//System.out.println("63->"+(tx-a)+" "+(ty+b));
			if(isValid(tx-a,ty+b)&&!visited[tx-a][ty+b]){
				queue.add(new Point(tx-a,ty+b,count+1));
			}
			if(isValid(tx-a,ty-b)&&!visited[tx-a][ty-b]){
				queue.add(new Point(tx-a,ty-b,count+1));
			}
			if(isValid(tx+b,ty+a)&&!visited[tx+b][ty+a]){
				queue.add(new Point(tx+b,ty+a,count+1));
			}
			if(isValid(tx+b,ty-a)&&!visited[tx+b][ty-a]){
				queue.add(new Point(tx+b,ty-a,count+1));
			}
			if(isValid(tx-b,ty+a)&&!visited[tx-b][ty+a]){
				queue.add(new Point(tx-b,ty+a,count+1));
			}
			if(isValid(tx-b,ty-a)&&!visited[tx-b][ty-a]){
				queue.add(new Point(tx-b,ty-a,count+1));
			}
		}
		return -1;
	}
}

