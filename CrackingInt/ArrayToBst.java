/*
 * Program Description:
 * Date Created: Mon 25 Sep 2017 07:19:00 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class ArrayToBst
{
	Node head;
	int[] arr;
	public ArrayToBst(int[] arr){
		head = null;
		this.arr = arr;
	}
	public void makeBinaryTree() {
		head = makeBinaryUtil(arr,0,arr.length-1);
	}
	public Node makeBinaryUtil(int[] arr,int start,int end){
		if(start>end)
			return null;
		int mid = (start+end)/2;
		Node node = new Node(arr[mid]);
		if(head == null){
			head = node;
			System.out.println("Head"+head.data+" "+start+" "+end);
		}
		node.left = makeBinaryUtil(arr,start,mid-1);
		node.right = makeBinaryUtil(arr,mid+1,end);
		return node;
	}
	public void inOrder(Node node){
		if(node == null)
			return;
		System.out.print(node.data+" ");
		inOrder(node.left);
		inOrder(node.right);
	}
}

