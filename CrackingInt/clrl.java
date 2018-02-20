/*
 * Program Description:
 * Date Created: Wed 08 Nov 2017 10:22:21 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class clrl
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0) {
			int n = in.nextInt();
			long rat = in.nextLong();
			long[] arr = new long[n];
			for(int i=0; i<n; i++) 
				arr[i] = in.nextLong();
			long min = Long.MIN_VALUE;
			long max = Long.MAX_VALUE;
			int i = 0;
			String result = "";
			while(i<n) {
				if(arr[i] == rat && i == n-1){
					result = "YES";
					break;
				} else if (arr[i] == rat && i != n-1){
					result = "NO";
					break;
				}
				if(arr[i] > rat) {
					if(max > arr[i]) {
						max = arr[i];
					} else {
						result = "NO";
						break;
					}
				} else {
					if(min < arr[i]) {
						min = arr[i];
					} else {
						result = "NO";
						break;
					}
				}
				i++;
			}
			System.out.println(result);
		}
	}
}

