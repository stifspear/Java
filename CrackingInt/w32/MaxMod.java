import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxMod {
	static long runnin=0;
	static long mo=0;
	static long getMaxScore(long[] a){
		// Complete this function
		long runningsum=0;
		long mod=0;
		int maxind=0;
		long maxmod=0;
		long max;
		long temp=0;
		long[] sa=new long[a.length];
		
		Arrays.sort(a);
		runningsum=a[a.length-1];
		long tmod=0;
		for(int j=0;j<a.length;j++){
			max=0;
			maxmod=0;
			maxind=0;
			System.out.println(runningsum);
			for(int i=a.length-2;i>=0;i--){

				if(a[i]!=0 && runningsum%a[i]>maxmod)
				{
					System.out.println(runningsum+"j"+" "+a[i]+" "+runningsum%a[i]+" "+i);
					maxind=i;
					maxmod=runningsum%a[i];
					//System.out.println(maxmod);
				}
			}
			System.out.println(a[maxind]);
			runningsum+=a[maxind];
			a[maxind]=0;
			tmod+=maxmod;
			//System.out.println(runningsum+" i"+tmod);
		}
		mod=(tmod>mod)?tmod:mod;
		return mod;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] a = new long[n];
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextLong();
		}
		long maxScore = getMaxScore(a);
		System.out.println(maxScore);
	}
}

