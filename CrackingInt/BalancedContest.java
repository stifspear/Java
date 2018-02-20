/*
 * Program Description:
 * Date Created: Wed 11 Oct 2017 07:43:16 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class BalancedContest
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			int q = in.nextInt();
			int p = in.nextInt();
			int ck = 0;
			int h = 0;
			for(int i=0;i<q; i++) {
				int sol = in.nextInt();
				if(sol>=p/2)
					ck++;
				if(sol<=p/10)
					h++;
			}
			//System.out.println(ck+" "+h);
			if(ck==1 && h == 2)
				System.out.println("yes");
			else 
				System.out.println("no");
		}

	}
}

