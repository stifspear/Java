/* * Program Description:
 * Date Created: Fri 01 Sep 2017 10:57:31 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class MaximizeGcd
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] arr = new int[size];
		for(int i=size-1; i>=0; i--)
			arr[i] = in.nextInt();
		int[] gc = getGcd(arr, size);
		/*for(int val:gc)
			System.out.println(val);*/
		int ans = 0;
		int step = 1;
		for(int i=0; i<gc.length-1; i++){
			if(gc[i]>gc[i+1]){
				ans = i+2;
				step++;
				if(step == 3)
					break;
			}
		}
		System.out.println(size-ans);
	}
	public static int getG(int[] arr, int size){
		int result = arr[0];
		int sol = 0;
		result = gcd(arr[1],result);
		int valpro = 2;
		for(int i=2; i<size-1; i++){
			int temp = result;
			result = gcd(arr[i],result);
			if(temp>=result)
				return size-valpro;
			valpro++;
		}
		return 1;
	}
	public static int[] getGcd(int[] arr, int size){
		int result = arr[0];
		int[] sol = new int[size-1];
		for(int i=1; i<size; i++){
			sol[i-1] = gcd(arr[i],result);
		}
		return sol;
	}
	public static int gcd(int x, int y){
		if (x==0)
			return y;
		return gcd(y%x,x);
	}
}

