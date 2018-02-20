/*
 * Program Description:
 * Date Created: Thu 28 Sep 2017 09:16:31 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class PrintPost
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] ino = new int[size];
		int[] pre = new int[size];
		for(int i=0; i<size; i++)
			ino[i] = in.nextInt();
		for(int i=0; i<size; i++)
			pre[i] = in.nextInt();
		printPreOrder(ino,pre,size);
	}
	public static int getIndex(int[] arr, int val){
		int i;
		for(i=0; i<arr.length; i++){
			if(arr[i] == val)
				return i;
		}
		return 0;
	}
	public static void printPreOrder(int[] ino,int[] pre,int n){
		int root = getIndex(ino,pre[0]);
		if(root != 0){
			int[] temppre = Arrays.copyOfRange(pre,1,pre.length);
			printPreOrder(ino,temppre,root);
		}
		if(root != n-1){
			int[] tempin = Arrays.copyOfRange(ino,root+1,ino.length);
			int[] temppre = Arrays.copyOfRange(pre,root+1,pre.length);
			printPreOrder(tempin,temppre,n-root-1);
		}
		System.out.println(pre[0]);
	}
}

