/*
 * Program Description:
 * Date Created: Wed 27 Sep 2017 09:14:50 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class RotateMatrix
{
	int[][] arr;
	int size;
	public RotateMatrix(int[][] arr){
		size = arr.length;
		this.arr = arr;
	}
	public void rotate(){
		int first,last,temp,offset;
		temp = first = last = offset = 0;
		for(int layer=0; layer<size/2; layer++){
			first = layer;
			last = size - layer - 1;
			for(int i=first; i<last; i++) {
				offset = i-first;
				temp = arr[i][first];
			 	arr[i][first] = arr[last][i];
				arr[last][i] = arr[last-offset][last];
				arr[last-offset][last] = arr[first][last-offset];
				arr[first][last-offset] = temp;
			}
		}
		printArray(arr);
	}
	public void printArray(int[][] arr){
		for(int[] ar:arr){
			for(int val:ar)
				System.out.print(val+" ");
			System.out.println();
		}
	}
}

