/*
 * Program Description:
 * Date Created: Fri 01 Sep 2017 10:13:05 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class MaxSum
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<size; i++)
			list.add(in.nextInt());
		int sum = 0;
		int lastind = size-1;
		while(list.size()>0){
			int start = 0;
			if(list.get(start) == 1){
				list.remove(start);
				sum+=1;
			}
			int end = list.size()-1;
			if(list.get(end) == 1){
				list.remove(end);
				sum+=1;
			}
			int sz = 0;
			int pro1 = 0;
			int pro2 = 0;
			if(list.size()>=2){
				pro1 = list.get(0)*list.get(1);
			
			sz = list.size()-1;
			pro2 = list.get(sz)*list.get(sz-1);
			} else if(list.size() == 1){
				pro1 = list.get(0);
			} else {
				break;
			}
			if(pro1>pro2){
				list.remove(0);
				list.remove(1);
				sum+=pro1;
			}else {
				list.remove(sz);
				list.remove(sz-1);
				sum+=pro2;
			}
		}
		System.out.println(sum);
	}
}

