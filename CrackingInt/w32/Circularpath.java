import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class Circularpath {

	static int[] arr;
	static int mintime=Integer.MAX_VALUE;
	static int circularWalk(int n, int s, int t, int r_0, int g, int seed, int p){
		int[] r = new int[n];
		int i,c=0,k,flag=1,j,max=0,b=1;
		r[0]=r_0;
		for(i=1;i<n;i++)
			r[i]=(r[i-1]*g+seed)%p;
		i=s;
		while(i!=t){
			max=0;
			for(j=i-r[i];j<=i+r[i];j++) {
				k=j;
				if(k!=0)
				{
					if(k<0)
						k=Math.abs(n+k);
					k=k%n;
					if(k==t)
					{ 
						i=k;
						flag=0;
						break;
					} 
					else
					{ 
						if(max<r[k]||(max==r[k]&&(t-k)>0))
						{ 
							flag=2;
							b=k;
							max=r[k]; 
						}
					}
				}
			}
			c++;
			if(flag!=0)
			{
				i=b;
				i=i%n;
				if(c>=n)
				{
					c=-1;
					break;
				}
			}
		}
		return c;


	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int s = in.nextInt();
		int t = in.nextInt();
		int r_0 = in.nextInt();
		int g = in.nextInt();
		int seed = in.nextInt();
		int p = in.nextInt();
		int result = circularWalk(n, s, t, r_0, g, seed, p);
		System.out.println(result);
	}
}

