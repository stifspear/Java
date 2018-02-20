/*
 * Program Description:
 * Date Created: Wed 15 Nov 2017 10:55:45 PM IST
 * Author : Stif Spear Subba
 */
import java.util.*;
class simplestat
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[] arr = new int[n];
			double sum = 0;
			for(int i=0; i<n; i++) {
				arr[i] = in.nextInt();
				sum += arr[i];
			}
			Arrays.sort(arr);
			for(int i=0; i<k; i++) {
				sum -= arr[i];
			}
			for(int i=n-k; i<n; i++){
				sum -= arr[i];
			}
			System.out.println(sum/(n-2*k));
		}
	}

}

