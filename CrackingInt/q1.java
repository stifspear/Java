/*
 * Program Description:
 * Date Created: Sat 02 Sep 2017 08:52:14 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static String uglyOrBeautiful(int[] a) {
		int count = 0;
		boolean flag = false;
		for(int i=0; i<a.length-1; i++){
			if(a[i]<=a[i+1]){
				count++;

			}
			if(!(isValid(a[i],a.length)&&isValid(a[i+1],a.length)))
				flag = true;


		}
		if(count==a.length-1||flag)
			return "Ugly";
		return "Beautiful";

	}
	public static boolean isValid(int x,int len){
		return x>=1 && x<=len;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			int n = in.nextInt();
			int[] a = new int[n];
			for(int a_i = 0; a_i < n; a_i++){
				a[a_i] = in.nextInt();

			}
			String result = uglyOrBeautiful(a);
			System.out.println(result);

		}
		in.close();

	}

}

