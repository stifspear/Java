/*
 * Program Description:
 * Date Created: Mon 25 Sep 2017 08:03:07 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class LinkedListToBst
{
	LinkNode head;
	public LinkedListToBst(){}
	public LinkedListToBst(LinkNode head){
		this.head = head;
	}
	public void insert(int x){
		LinkNode node = head;
		if(node == null){
			head = new LinkNode(x);
			return;
		}
		while(node.next != null){
			node = node.next;
		}
		node.next = new LinkNode(x);
	}
	public void display() {
		LinkNode temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public void display(LinkNode head) {
		LinkNode temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public void InOrder(Node node) {
		Stack<Node> stack = new Stack<>();
		/* 
		 * Step 1:Create stack and push head to the stack
		 */
		stack.push(node);
		Node temp = node.left;
		while(temp != null){
			stack.push(temp);
			temp = temp.left;
		}
		while(!stack.isEmpty()){
			temp = stack.pop();
			System.out.print(temp.data+" ");
			if(temp.right != null) {
				temp = temp.right;
				while(temp != null){
					stack.push(temp);
					temp = temp.left;
				}
			}
		}
	}
	public Node linkToBst(LinkNode tempHead) {
		LinkNode mid = getMid(tempHead);
		if(tempHead == null)
			return null;
		if(mid == tempHead){
			System.out.println("*********");
			display(tempHead);
			System.out.println("*******");
			return new Node(mid.data);
		}
		Node newNode = new Node(mid.next.data);
		LinkNode newHead = mid.next.next;
		mid.next = null;
		System.out.println("-----------");
		display(tempHead);
		display(newHead);
		System.out.println("-----------");
		newNode.left = linkToBst(tempHead);
		newNode.right = linkToBst(newHead);
		return newNode;
	}
	public LinkNode getMid(LinkNode node) {
		LinkNode temp = node.next;
		LinkNode ans = node;
		if(temp != null){
			while(temp != null && temp.next != null){
				temp = temp.next.next;
				ans = node;
				node = node.next;
			}
		}
		return ans;
	}
}

