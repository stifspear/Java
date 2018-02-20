/*
 * Program Description:
 * Date Created: Fri 29 Sep 2017 10:43:11 AM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class LowestCommonAncestor
{
	Node root;
	boolean isLeft;
	boolean isRight;
	public LowestCommonAncestor(Node root){
		this.root = root;
		isLeft = false;
		isRight = false;
	}
	public Node get(int x,int y,Node node) {
		if(node == null)
			return null;
		if(node.data == x ){
			isLeft = true;
			return node;
		}
		if(node.data == y){
			isRight = true;
			return node;
		}
		Node left = get(x,y,node.left);
		Node right = get(x,y,node.right);
		if(left != null && right != null)
			return node;
		return (left == null)?right:left;
	}
	public void getAncestor(int x,int y){
		isLeft = false;
		isRight = false;
		Node ans = get(x,y,root);
		if(ans == null||!(isLeft && isRight))
			System.out.println("No ancestor");
		else 
			System.out.println(ans.data);
	}
	public void traverse() {
		Node temp = root;
		Stack<Node> stack = new Stack<Node>();
		while(temp != null){
			stack.push(temp);
			temp = temp.left;
		}
		while(!stack.isEmpty()){
			Node cur = stack.pop();
			System.out.println(cur.data);
			cur = cur.right;
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
		}
	}
}

