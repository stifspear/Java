/*
 * Program Description:
 * Date Created: Tue 12 Sep 2017 10:22:33 AM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class Node{
	Node next;
	int data;
	public Node(int data){
		this.data = data;
	}
}
class RemoveDupList
{
	public static Node head;
	public RemoveDupList(){
	}
	public static Node insert(Node node, int n){
		if(node == null){
			return new Node(n);
		}
		while(node.next != null)
			node = node.next;
		node.next = new Node(n);
		return head;
	}
	public static void displayList(Node node){
		if(node == null)
			return;
		System.out.println(node.data);
		displayList(node.next);
	}
	public static Node reverseList(Node node, Node cur){
		if(node.next == null){
			cur = new Node(node.data);
			head = cur;
			return cur;
		}
		cur = reverseList(node.next,cur);
		Node newNode = new Node(node.data);
		cur.next = newNode;
		return newNode;
	}
	public static Node reverseList(Node node){
		if(node.next == null||node == null){
			return node;
		}
		Node cur = reverseList(node.next);
		node.next.next = node;
		node.next = null;
		return cur;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int i=0; i<n; i++)
			head = insert(head,in.nextInt());
		displayList(head);
		Node cur = null;
		head = reverseList(head);
		displayList(head);

	}
}

