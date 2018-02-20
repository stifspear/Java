/*
 * Program Description:
 * Date Created: Sun 19 Nov 2017 01:13:07 PM IST
 * Author : Stif Spear Subba
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Point {
	int x,y,size;
	public Point(int x,int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	public String toString() {
		return x+" "+y+" "+size;
	}
}
public class MatrixLand2 {

	static int matrixLand(int[][] A) {
		Point[][] left = leftSub(A,A.length,A[0].length);
		Point[][] right = rightSub(A,A.length,A[0].length);
		Point[][] m = mergeMatrix(A,left,right);
		/*display(left);
		System.out.println("right");
		display(right);
		System.out.println("Matrix");
		display(m);*/
		int b = 0;
		Point[] row = new Point[A[0].length];
		Point curPoint = null;
		for(;b<A.length-1;b++) {
			for(int t=0; t<A[0].length; t++)
				row[t] = m[b][t];
			for(int j=0; j<A[0].length; j++) {
				curPoint = m[b+1][j];
				m[b+1][j] = new Point(curPoint.x,curPoint.y,curPoint.size+getMax(curPoint.x,curPoint.y,row));
			}
		}
		display(m);
		return 0;
	}
	static int getMax(int i,int j,Point[] arr) {
		int max = Integer.MIN_VALUE;
		for(int l=i; l<=j; l++)
			max = (max>arr[l].size)?max:arr[l].size;
		return max;
	}
	static Point[][] leftSub(int[][] a,int n,int m) {
		Point[][] arr = new Point[n][m];
		for(int i=0; i<n; i++)
			arr[i][0] = new Point(0,0,0);
		for(int i=0; i<n; i++) {
			for(int j=1; j<m; j++) {
				if(a[i][j-1]>(a[i][j-1]+arr[i][j-1].size)) {
					arr[i][j] = new Point(j,j,a[i][j-1]);
				} else {
					arr[i][j] = new Point(arr[i][j-1].x,j,arr[i][j-1].size+a[i][j-1]);
				}
			}
		}
		return arr;
	}
	static Point[][] mergeMatrix(int[][] aa, Point[][] left, Point[][] right) {
		Point[][] arr = new Point[left.length][left[0].length];
		for(int i=0; i<left.length; i++) {
			for(int j=0; j<left[0].length; j++) {
				Point a = left[i][j];
				Point b = right[i][j];
				int size = max(aa[i][j],aa[i][j]+a.size,aa[i][j]+b.size,aa[i][j]+a.size+b.size);
				arr[i][j] = new Point(Math.max(a.x,b.x),Math.max(a.y,b.y),size);
			}
		}
		return arr;
	}
	static int max(int a, int b, int c, int d) {
		int max = Integer.MIN_VALUE;
		if(a>max)
			max = a;
		if(b>max)
			max = b;
		if(c>max)
			max = c;
		if(d>max)
			max = d;
		return max;
	}
	static Point[][] rightSub(int[][] a,int n,int m) {
		Point[][] arr = new Point[n][m];
		for(int i=0; i<n; i++)
			arr[i][m-1] = new Point(0,0,0);
		for(int i=0; i<n; i++) {
			for(int j=m-2; j>=0; j--) {
				if(a[i][j+1]>(a[i][j+1]+arr[i][j+1].size)) {
					arr[i][j] = new Point(j,j,a[i][j+1]);
				} else {
					arr[i][j] = new Point(arr[i][j+1].x,j,arr[i][j+1].size+a[i][j+1]);
				}
			}
		}
		return arr;
	}
	public static void display(Point[][] a) {
		for(Point[] arr:a) {
			for(Point p:arr)
				System.out.print(p+"||");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] A = new int[n][m];
		for(int A_i = 0; A_i < n; A_i++){
			for(int A_j = 0; A_j < m; A_j++){
				A[A_i][A_j] = in.nextInt();
			}
		}
		int result = matrixLand(A);
		System.out.println(result);
		in.close();
	}
}
