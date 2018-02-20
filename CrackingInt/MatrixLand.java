/*
 * Program Description:
 * Date Created: Sat 18 Nov 2017 12:06:40 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Point {
	int sc,x,y;
	public Point(int sc, int x,int y) {
		this.sc =sc;
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return sc+" "+"("+x+","+y+")";
	}
}
public class MatrixLand {
	static boolean fina=false;
	static int finalS = 0;
	static int matrixLand(int[][] A) {
		Point[][] land = new Point[A.length][A[0].length];
		int i=0;
		for(int[] arr:A) {
			for(int l=1; l<=A[0].length; l++) {
				land[i][A[0].length-l] = subArraySum(arr,l);
			}
			i=i+1;
		}
		for(Point[] arr:land)
			Arrays.sort(arr,(a,b)->b.sc-a.sc);
		display(land);
		Point[] visited = new Point[A.length];
		//System.out.println(getScore(land,visited,0,0));
		System.out.println(finalS);
		return getScore(land,visited,0,0);
	}
	static int getScore(Point[][] land,Point[] visited,int curScore,int level) {
		if(level == land.length){
			finalS = Math.max(curScore,finalS);
			return curScore;
		}
		boolean isTrue = false;
		int temp = curScore;
		for(int i=0; i<land[0].length; i++) {
			isTrue = false;
			visited[level] = land[level][i];
			for(int j=0; j< level; j++) {
				if(isOverlapping(land[level][i],visited[j])) {
					visited[level] = land[level][i];
					isTrue = true;
					break;
				}
			}
			if(isTrue||level==0) {
				temp =  Math.max(temp,getScore(land,visited,curScore+visited[level].sc,level+1));
			}
		}
		return temp;

	}
	static boolean isOverlapping(Point x, Point y) {
		return (x.x>=y.x&&x.x<=y.y)||(x.y>=y.x&&x.y<=y.y)||(y.x>=x.x&&y.y<=x.y)||(x.x>=y.x&&x.y<=y.y);
	}
	static void display(Point[][] p) {
		for(Point[] arr:p) {
			for(Point v:arr)
				System.out.print(v+"||");
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
	static Point subArraySum(int[] arr, int len) {
		/*for(int val:arr)
		  System.out.print(val+" ");*/
		int max = 0;
		int sum = 0;
		for(int i=0; i<len; i++)
			sum+=arr[i];
		max = sum;
		int init = 0;
		int x = 0;
		int y = len-1;
		for(int i=1;i<=arr.length-len;i++) {
			sum = sum-arr[init++]+arr[i+len-1];
			if(sum>max) {
				x=i;
				y=i+len-1;
				max = sum;
			}
		}
		return new Point(max,x,y);
	}
}
