/*
 * Program Description:
 * Date Created: Mon 15 Jan 2018 10:47:31 AM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class prtition
{
	static HashSet<Integer> set;
	static boolean flag=false;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(--test>=0) {
			int x = in.nextInt();
			int n = in.nextInt();
			flag = false;
			set = new HashSet<>();
			long sum = getSum(n,x);
			//System.out.println(sum);
			if(n == 1) {
				System.out.println("1"); 
			} else { 
				if(sum%2==0 && (n-1) > 1) {
					findSet(1,sum/2,n,x,new HashSet<Integer>());
					//System.out.println(set);
					printSet(set,n,x);
				} else {
					System.out.println("impossible");
				}
			}
		}
	}
	public static void printSet(HashSet<Integer> s,int n, int x) {
		for(int i=1;i<=n; i++) {
			if(i==x)
				System.out.print("2");
			else if(s.contains(i))
				System.out.print("1");
			else
				System.out.print("0");
		}
		System.out.println();
	}
	public static long getSum(int n, int x) {
		long sum = (n*(n+1))/2;
		return (sum-x);
	}
	public static void findSet(int i, long sum, int n, int x,HashSet<Integer> s) {
		//System.out.println(i+" "+sum+" "+s);
		if(flag)
			return;
		if(sum == 0) {
			set = new HashSet<>(s);
			flag = true;
			return;
		}
		if(i>n)
			return;
		if(i==x)
			findSet(i+1,sum,n,x,s);
		else {
			findSet(i+1,sum,n,x,s);
			s.add(i);
			findSet(i+1,sum-i,n,x,s);
			s.remove(i);
		}
	}
}

