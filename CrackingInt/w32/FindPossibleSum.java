/*
 * Program Description:
 * Date Created: Sat 12 Aug 2017 12:05:13 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class FindPossibleSum
{
	public FindPossibleSum(){
	}
	public int findSum(int[] arr,int index,int sum,int runningSum){
		if(sum == runningSum){
			return 1;
		}
		if(index >= arr.length)
			return 0;
		if(runningSum > sum)
			return 0;
		return findSum(arr,index+1,sum,runningSum+arr[index]) + findSum(arr,index+1,sum,runningSum);
	}
}

