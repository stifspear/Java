/*
 * Program Description:
 * Date Created: Thu 09 Nov 2017 02:53:11 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class chefhpal
{
	public static void main(String[] args){
		String out = "abcdefghijklmnopqrstuvwxyz";
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0) {
			int l = in.nextInt();
			int c = in.nextInt();
			//System.out.println(test+" "+l+" "+c);
			if(c == 2) {
				get(l);
			} else {
				String init = "";
				if(c < l)
					init = out.substring(0,c);
				else {
					System.out.println("1 "+out.substring(0,l));
					continue;
				}
				int rem = l%c;
				String res = "";
				int quo = l/c;
				for(int i=0; i<quo; i++) {
					res += init;
				}
				res += init.substring(0,rem);
				if(c == 1)
					System.out.println(l+" "+res);
				else 
					System.out.println("1 "+res);
			}
		}
	}
	public static void get(int len) {
		if(len == 1) {
			System.out.println("1 a");
			return;
		}
		if(len ==2 ) {
			System.out.println("1 ab");
			return;
		}
		if(len == 3){
			System.out.println("2 aab");
			return;
		}
		if(len == 4) {
			System.out.println("2 abab");
			return;
		}
		String out = "";
		int j=0;
		String[] arr = {"aa","ab","ab","ba"};
		for(int i=1; i<len; i=i+2) {
			out += arr[j++];
			if(j==4)
				j=1;
		}
		int ol = 4;
		if(len <= 7)
			ol = 3;
		if(len%2==0)
			System.out.println(ol+" "+out);
		else 
			System.out.println(ol+" "+(out+(""+arr[j].charAt(0))));
	}
}

