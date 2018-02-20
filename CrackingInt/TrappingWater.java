/*
 * Program Description:
 * Date Created: Fri 29 Sep 2017 07:26:32 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class TrappingWater
{
	int size;
	int[] arr;
	public TrappingWater(int[] arr, int size){
		this.size = size;
		this.arr = arr;
	}
	public int getTrap() {
		int start = 0;
		int count = 0;
		int inbetween = 0;
		int[] left = new int[size];
		int[] right = new int[size];
		left[0] = arr[0];
		for(int i=1; i<size; i++) {
			left[i] = Math.max(arr[i],left[i-1]);
		}
		right[size-1] = arr[size-1];
		for(int i=size-2; i>=0; i--) {
			right[i] = Math.max(arr[i],right[i+1]);
		}
		for(int i=0; i<size; i++)
			count += Math.min(left[i],right[i]) - arr[i];
		return count;
	}
}

