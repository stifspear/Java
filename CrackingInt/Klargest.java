/*
 * Program Description:
 * Date Created: Sun 24 Sep 2017 07:26:51 PM IST
 * Author : Stif Spear Subba
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class Klargest {
	public static void main (String[] args) {

		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			int size = in.nextInt();
			int k = in.nextInt();
			int[] arr = new int[size];
			for(int i=0; i<size; i++)
				arr[i] = in.nextInt();
			Arrays.sort(arr);
			System.out.println(arr[size-k-1]);
		}
	}
}

