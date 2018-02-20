/*
 * Program Description:
 * Date Created: Sat 07 Oct 2017 10:19:15 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class NextLargest
{
	int size;
	int[] arr;
	public NextLargest(int[] arr, int size){
		this.arr = arr;
		this.size = size;
	}
	public int[] getNext() {
		int index = size-1;
		while(index > 0) {
			int nextLargest = getLargest(arr,index-1);
			if(nextLargest != index-1) {
				arr = swap(arr,nextLargest,index-1);
				sort(arr,nextLargest+1,size-1);
				return arr;
			}
			index = index-1;
		}
		return null;
	}
	public int getLargest(int[] arr, int index) {
		int temp = arr[index];
		int max = Integer.MAX_VALUE;
		int ans = index;
		for(int i=index; i<size; i++) {
			if(arr[i] > temp && arr[i] < max){
				max = arr[i];
				ans = i;
			}
		}
		return ans;
	}
	public int[] sort(int[] arr,int x, int y) {
		int[] temp = new int[y-x+1];
		int index = 0;
		for(int i=x; i<=y; i++) {
			temp[index++] = arr[i];
		}
		Arrays.sort(temp);
		index = 0;
		for(int i=x; i<=y; i++) {
			arr[i] = temp[index++];
		}
		return arr;
	}
	public int[] swap(int[] arr, int x, int y){
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
		return arr;
	}
	public void test() {
		int[] ans = getNext();
		PrintClass.printArray(ans);
	}
}

