/*
 * Program Description:
 * Date Created: Wed 13 Dec 2017 08:55:45 PM IST
 */
/* Algorithm
 * Find the largest possible square from given set of points
 */
import java.io.*;
import java.util.*;
class Point {
	int x,y;
	public Point(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
class maxrect
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Point[] arr = new Point[n];
		for(int i=0; i<n; i++) {
			arr[i] = new Point(in.nextInt(),in.nextInt());
		}
		for(int i=0; i<n/2; i++) {
			for(int j=i+1; j<=n/2; j++) {

			}
		}
	}
	public static boolean sameX(Point a, Point b) {
		return a.x == b.x;	
	}
	public static
}

