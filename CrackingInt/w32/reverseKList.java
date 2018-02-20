/*
 * Program Description:
 * Date Created: Sun 24 Sep 2017 07:50:55 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class reverseKList
{
	Node head;
	Node newLink;
	public void addNode(int data) {
		Node node = head;
		Node newNode = new Node(data);
		if(node == null) {
			head = newNode;
			return;
		}
		while(node.next != null) {
			node = node.next;
		}
		node.next = newNode;
	}
	public Node reverseList(int k){
		Node node = head;
		Stack<Node> stack = new Stack<>();
		int count = 10;
		while(node != null) {
			for(int i=0; i<k && node!= null; i++) {
				stack.push(node);
				node = node.next;
			}
			while(!stack.isEmpty()) {
				Node newNode = new Node(stack.pop().data);
				if(newLink == null) {
					newLink = newNode;
				} else {
					Node temp = newLink;
					while(temp.next != null) {
						temp = temp.next;
					}
					temp.next = newNode;
				}
			}
			/*if(count > 10)
				return newLink;*/
		}
		return newLink;
	}
	public void display(Node node) {
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}
}

