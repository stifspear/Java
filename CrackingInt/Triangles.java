/*
 * Program Description:
 * Date Created: Mon 20 Nov 2017 09:03:54 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class Triangles
{
	static int mod = 1000000007;
	static long[] sum = new long[1000010];
	static long[] pow_arr = new long[1000010];
	public static void main(String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
		int temp = 0;
		init();
		int test = in.nextInt();
		while(test-->0) {
			int inp = in.nextInt();
			long ans = 0;
			int i=0;
			ans = ((2*sum[inp])%mod+pow_arr[inp+1])%mod;
			System.out.println(ans);
		}

	}
	public static void init() {
		pow_arr[1] = 1;
		sum[1]=1;
		for(int i=2; i<=1000009; i++){
			pow_arr[i] = ((pow_arr[i-1]%mod)*3)%mod;
			sum[i] = (sum[i-1]+pow_arr[i])%mod;
		}
	}
}

