/*
 * Program Description:
 * Date Created: Wed 11 Oct 2017 07:59:09 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class MaxMex
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0) {
			int size = in.nextInt();
			int k = in.nextInt();
			boolean[] set = new boolean[200002];
			for(int i=0; i<size; i++) {
				set[in.nextInt()] = true;
			}
			int count = 0;
			for(int i=0; i<200002; i++) {
				if(!set[i]){
					if(count == k){
						System.out.println(i);
						break;
					}
					count++;
				}
			}
		}
	}
}

