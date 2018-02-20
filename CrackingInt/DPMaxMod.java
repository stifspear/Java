import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Value {
	long sum,mod;
	public Value(long sum,long mod) {
		this.sum=sum;
		this.mod=mod;
	}
}
public class DPMaxMod {
	static long count=0;
	static long[] sum = new long[1048576];
	static long[] mod = new long[1048576];
	static Value getMaxScore(long[] a){
		// Complete this function
		long runningsum=0;
		long mod=0;
		for(int i=0;i<a.length;i++){


			//System.out.println((runningsum%a[i])+"j"+max+" "+a[i]);
			mod+=runningsum%a[i];
			runningsum+=a[i];
			//System.out.println(maxmod);
		}

		//System.out.println(runningsum+" i"+mod);

		return new Value(runningsum,mod);
	}
	static void subset(long[] arr) {
		int index=0;
		long[] ar = new long[arr.length];
		int len = arr.length;
		//System.out.println(len);
		for(int i=0;i<(1<<len);i++) {
			for(int j=0;j<len;j++) {
				if((i&(1<<j))>0){
					ar[j]=arr[j];
					index=i;
					/*for(int ii=0;ii<len;ii++)
						System.out.print(ar[ii]+" ");
					System.out.println();*/
				}
			}
			if(i!=0&&sum[i<<1]==0){
				Value temp=getMaxScore(arr);
				sum[i]=temp.sum;
				mod[i]=temp.mod;
			} else {
				sum[i]=sum[i^1]+arr[index];
				mod[i]=mod[i^1]+(sum[(i^1)]%arr[index]);
			}	
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] a = new long[n];
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextLong();
		}
		//long maxScore = permute(a);
		//doAnagram(a,0,a.length-1);
		subset(a);
		System.out.println(mod[n-1]);
	}
}


