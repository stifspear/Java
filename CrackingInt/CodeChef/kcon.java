/*
 * Program Description:
 * Date Created: Sun 07 Jan 2018 02:03:21 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class kcon
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		long t = in.nextInt();
		while(--t>=0) {
			int size = in.nextInt();
			int k = in.nextInt();
			long[] a = new long[size];
			for(int i=0; i<size; i++){
				a[i] = in.nextLong();
			}
			long[] ar2 = new long[size*2];
			for(int i=0; i<size; i++)
				ar2[i] = a[i];
			for(int i=size; i<size*2; i++)
				ar2[i] = a[i-size];
			long init = 0;
			for(long v:a) {
				init += v;
			}
			/*if(args[0].equals("0")) {
				System.out.println(brute(a,size,k));
			} else {*/
			
				if(k>=2) {
					init = init*(k-2);
					long ms1 = maxSub(ar2,size*2);
					long ms2 = maxSub(a,size);
					/*System.out.println(init);
					System.out.println(ms1+" "+ms2);*/
					System.out.println(Math.max(max(init+ms1,init+ms2,ms2),ms1));
				} else {
					System.out.println(Math.max(init,maxSub(a,size)));
				}
			//}
			
		}
	}
	public static long max(long a, long b, long c) {
		long m = Long.MIN_VALUE;
		m = Math.max(a,m);
		m = Math.max(b,m);
		m = Math.max(c,m);
		//System.out.println("max"+m+" "+a+" "+b+" "+c);
		return m;
	}
	public static long maxSub(long[] a, long n) {
		/*for(long v:a)
			System.out.print(v+" ");
		System.out.println();*/
		long max_so = a[0];
		long max = a[0];
		for(int i=1; i<n; i++) {
			max_so = Math.max(a[i],a[i]+max_so);
			max = Math.max(max_so,max);
		}
		//System.out.println("maxSub"+max);
		return max;
	}
	public static long brute(long[] a, int size, int k) {
		int newS = k*size;
		int i=0;
		long[] newA = new long[newS];
		for(int j=0; j<newS; j++) {
			newA[j] = a[i++];
			if(i==size)
				i=0;
		}
		return maxSub(newA,newS);
	}
}
