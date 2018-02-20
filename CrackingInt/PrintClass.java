/*
 * Program Description:
 * Date Created: Thu 28 Sep 2017 09:25:12 AM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class PrintClass
{
	public static void printArray(int[][] arr){
		for(int[] ar:arr){
			for(int val:ar)
				System.out.print(val+" ");
			System.out.println();
		}
	}
	public static void printArray(int[] arr){
		for(int val:arr){
			System.out.print(val+" ");
		}
		System.out.println();
	}

}

