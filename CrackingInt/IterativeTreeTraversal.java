/*
 * Program Description:
 * Date Created: Thu 05 Oct 2017 10:22:29 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class IterativeTreeTraversal
{
	Node root;
	public IterativeTreeTraversal(){
	}
	public void inOrder() {
		Node temp = root;
		Stack<Node> stack = new Stack<Node>();
		while(temp != null) {
			stack.push(temp);
			temp = temp.left;
		}
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.data);
			cur = cur.right;
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
		}
	}
	public void preOrder() {
		Node temp = root;
		Stack<Node> stack = new Stack<Node>();
		stack.push(temp);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.data);
			if(cur.right != null) {
				stack.push(cur.right);
			}
			if(cur.left != null) {
				stack.push(cur.left);
			}
		}
	}
	public void postOrder2Stack() {
		Node temp = root;
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack.push(temp);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			stack2.push(cur);
			if(cur.left != null) {
				stack.push(cur.left);
			}
			if(cur.right != null) {
				stack.push(cur.right);
			}
		}
		while(!stack2.isEmpty()) {
			System.out.println(stack2.pop().data);
		}
	}
	public void postOrder() {
		Node temp = root;
		Stack<Node> stack = new Stack<Node>();
		while(temp != null) {
			stack.push(temp);
			temp = temp.left;
		}
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			if(cur.right == null) {
				System.out.println(cur.data);
			} else {
				stack.push(cur);
				cur = cur.right;
				//cur.right = null;
				while(cur != null) {
					stack.push(cur);
					cur = cur.left;
				}
			}
		}
	}
	public void test() {
		root = new Node(10);
		root.left = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right = new Node(20);
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		this.inOrder();
		this.preOrder();
		this.postOrder2Stack();
		this.postOrder();
	}
}
