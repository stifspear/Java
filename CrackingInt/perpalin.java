/*
 * Program Description:
 * Date Created: Thu 09 Nov 2017 12:52:58 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class perpalin
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0) {
			int len = in.nextInt();
			int p = in.nextInt();
			char[] arr = new char[len];
			Arrays.fill(arr,' ');
			if(len == p && len != 1 && p != 1) {
				arr[0] = 'a';
				arr[len-1] = 'a';
				for(int i=1; i<len-1; i++)
					arr[i] = 'b';
			} else if(len == 1 || p == 1) {
				System.out.println("impossible");
				continue;
			} else if((len%p) != 0)
				System.out.println("impossible");
			else {
				//System.out.println("in");
				for(int i=p; i<=len; i=i+p) {
					if(i>=p) {
						arr[i-1] = 'a';
					}
				}
				//disp(arr);
				for(int i=0; i<len; i++) {
					if(arr[i] == ' ') {
						arr[i] = arr[len-i-1];
					}
				}
				//disp(arr);
				for(int i=0; i<len; i++) {
					if(arr[i] == ' ')
						arr[i] = 'b';
				}
			}
			String s = new String(arr);
			if(isPalindrome(s))
				System.out.println(s);
			else {
				System.out.println("impossible");
			}
		}
	}
	public static void disp(char[] arr) {
		System.out.println("-----");
		int i=0;
		for(char ch:arr)
			System.out.println(i+++" "+ch);
		System.out.println("-----");
	}
	public static boolean isPalindrome(String str) {
		int i=0;
		int len = str.length()-1;
		boolean a,b;
		a=b=false;
		while(i<=len) {
			char ch = str.charAt(i);
			if(ch == 'a')
				a=true;
			if(ch == 'b')
				b=true;
			if(ch != str.charAt(len-i))
				return false;
			i++;
		}
		return true&&a&&b;
	}
}

