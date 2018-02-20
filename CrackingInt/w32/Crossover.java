import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Crossover {
	static int[] p;
	public static void main(String[] args) {
		double[] STMV;
		double[] LTMV;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int s_index=0;
		p = new int[n];
		STMV = new double[n-60+1];
		LTMV = new double[n-300+1];
		for(int p_i=0; p_i < n; p_i++){
			p[p_i] = in.nextInt();
		}
		STMV[0]=(double)calculateMV(299,59);
		LTMV[0]=(double)calculateMV(299,299);
		//System.out.println(STMV[0]/2+" "+LTMV[0]/5);
		int count=1;
		
		for(int i=300;i<n;i++){
			LTMV[count]=LTMV[count-1]-p[count-1]+p[i]; 
			STMV[count]=STMV[count-1]-p[i-60]+p[i];
//			System.out.println(i+" "+LTMV[count]/5);
//			System.out.println(i+" "+STMV[count]/2);
			count++;

		}   

		for(int i=0;i<LTMV.length-1;i++){
			double s_m,l_m,s_m1,l_m1;
			s_m=STMV[i]/60;
			l_m=LTMV[i]/300;
			s_m1=STMV[i+1]/60;
			l_m1=LTMV[i+1]/300;
			if(s_m<l_m&&s_m1>=l_m1)
				System.out.println((300+i+1)+" "+s_m1+" "+l_m1);
			else if(s_m>l_m&&s_m1<=l_m1)
				System.out.println((300+i+1)+" "+s_m1+" "+l_m1);
			else if(s_m==l_m&&s_m1!=l_m1)
				System.out.println((300+i+1)+" "+s_m1+" "+l_m1);

		}
	

	}
public static int calculateMV(int n,int n1){
	int sum=0;
	for(int i=n;i>=n-n1;i--)
		sum+=p[i];
	return sum;
}
}
