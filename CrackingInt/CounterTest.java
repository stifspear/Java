/*
 * Program Description:
 * Date Created: Thu 12 Oct 2017 12:12:29 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class CounterTest
{
	static int max = Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0) {
			int n = in.nextInt();
			int[] arr = new int[n];
			arr[0] = 100000;
			int rem2 = max - (2*arr[0]);
			rem2 = rem2+1;
			int sum = arr[0];
			int rem = (rem2)%(n-1);
			int quo = (rem2)/(n-1);
			int s = rem+quo;
			int i=1;
			System.out.print(arr[0]+" ");
			while(s>100000) {
				System.out.print(100000+" ");
				sum += 100000;
				s -= 100000;
				s = quo+s;
				i++;
			}
			System.out.print(s+" ");
			sum += s;
			i=i+1;
			for(; i<n; i++){
				System.out.print(quo+" ");
				sum += quo;
			}
			System.out.println();
			/*if((sum-1)+100000 == max)
				System.out.println("true");*/
			/*System.out.println(Integer.MAX_VALUE);
			System.out.println(Integer.MAX_VALUE-arr[0]);*/
			/*int rem2 = (Integer.MAX_VALUE-arr[0])%(n-1);
			System.out.println(rem2);*/
			/*System.out.println(rem);
			System.out.println(quo);*/
			/*System.out.println(rem+quo-100000);
			if(sum == Integer.MAX_VALUE)
				System.out.println("True");
			else 
				System.out.println(Integer.MAX_VALUE-sum);*/
		}
	}
}

