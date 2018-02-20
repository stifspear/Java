/*
 * Program Description:
 * Date Created: Fri 15 Dec 2017 08:34:11 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class breakingstick
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long sum = 0;
		for(int i=0; i<n; i++) {
			sum += greatest(in.nextLong());
			//System.out.println(sum);
		}
		System.out.println(sum);
	}
	public static long greatest(long val) {
		if(val == 1)
			return 1;
		long sum = 1+val;
		long a,b;
		a=b=0;
		for(long i=2; i*i<=val; i++) {
			if(val%i == 0){
				a=i;
				b=val/i;
				long m = Math.min(a,b);
				long M = Math.max(a,b);
				//System.out.println(a+" "+b+" "+m+" "+M);
				double tem = Math.log(M)/Math.log(m);
				if(tem-(int)tem == 0d)
					sum += m+m;
				else if(a%2 == 0 && b%2 == 0)
					sum += Math.max(a,b);
				else if(a%2 != 0 && b%2 != 0) {
					if(prime(a) && prime(b)) {
						sum += Math.max(a,b);
					} else if(prime(a)){
						sum += a;
					} else if(prime(b))
						sum += b;
				}
				if(a%2==0 && b%2!=0) {
					if(prime(b))
						sum += b;
					else 
						sum += Math.max(a,b);
				}
				if(a%2!=0 && b%2==0){
					if(prime(a))
						sum += a;
					else 
						sum += Math.max(a,b);
				}
			}
		}
		return sum;
	}
	public static boolean prime(long v) {
		for(int i=2; i<=v/2; i++){
			if(v%i==0)
				return false;
		}
		return true;
	}
}

