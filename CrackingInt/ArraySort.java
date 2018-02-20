/*
 * Program Description:
 * Date Created: Thu 30 Nov 2017 11:57:34 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class ArraySort
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Long[] arr = new Long[n];
		for(int i=0; i<n; i++)
			arr[i] = in.nextLong();
		Arrays.sort(arr,Collections.reverseOrder());
		for(Long val:arr)
			System.out.print(val+" ");
		System.out.println();
	}
}

