/*
 * Program Description:
 * Date Created: Mon 15 Jan 2018 11:47:19 AM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class eqpart
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		while(--n>=0) {
			String i = in.nextLine();
			if(check(i) || i.equals("impossible"))
				System.out.println("True");
			else 
				System.out.println("False");
		}
	}
	public static boolean check(String i) {
		long s = 0;
		int n = i.length();
		s = n*(n+1)/2;
		long a,b;
		//System.out.println(s+" "+n);
		a=b=0;
		long c = 0;
		for(int j=0; j<n; j++) {
			if(i.charAt(j) == '2')
				c = j+1;
			else if(i.charAt(j) == '0')
				a += j+1;
			else 
				b += j+1;
		}
		//System.out.println(c+" "+a+" "+b);
		return (a+b+c) == s;
	}
}

