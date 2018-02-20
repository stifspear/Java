/*
 * Program Description:
 * Date Created: Sat 06 Jan 2018 12:48:50 PM IST
 * Author : Stif Spear Subba */
import java.io.*;
import java.util.*;
class maxsc
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(--test>=0) {
			int n = in.nextInt();
			long[][] a = new long[n][n];
			boolean[][] vis = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					a[i][j] = in.nextLong();
				}
			}
			int k,i,j;
			/*for(k=0; k< n; k++) {
				for (i = 0; i < n; i++) {
					for (j = i +1; j < n; ++j) {
						if (a[k][i] > a[k][j])  {
							long swap = a[k][i];
							a[k][i] = a[k][j];
							a[k][j] = swap;
						}
					}
				}
			}*/
			long sum = findMax(a,n);
			System.out.println(sum);
		}
	}
	public static long findMax(long[][] a, int n) {
		long sum = 0;
		long val = getMax(a[n-1]);
		sum += val;
		for(int i=n-2; i>=0; i--) {
			boolean flag = true;
			long l1;
			l1=0;
			for(int j=0; j<n; j++) {
				if(a[i][j] < val) {
					if(a[i][j] > l1) {
						l1 = a[i][j];
						flag = false;
					}
				}
			}
			if(flag)
				return -1;
			sum += l1;
			val = l1;
		}
		return sum;
	}
	public static long getMax(long[] a) {
		long max = -1;
		for(long val:a) {
			if(val>max)
				max = val;
		}
		return max;
	}
	public static void display(long[][] a) {
		for(long[] ar:a) {
			for(long val:ar) 
				System.out.print(val+" ");
			System.out.println();
		}
	}
}

