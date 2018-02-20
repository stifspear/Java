/*
 * Program Description:
 * Date Created: Fri 29 Sep 2017 01:13:40 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class MaxSumOfNodes
{
	Node root;
	HashMap<Node,Integer> map;
	public MaxSumOfNodes(Node root){
		this.root = root;
		map = new HashMap<Node,Integer>();
	}
	/*public int sumOfChildren(Node node) {
		if(node == null)
			return 0;
		int sum = 0;
		if(node.left != null)
			sum+=sumOfChildren(node.left);
		if(node.right != null)
			sum+=sumOfChildren(node.right);
		return sum+node.data;
	}*/
	public int sumOfGrandChildren(Node node) {
		if(node == null)
			return 0;
		Node left = node.left;
		Node right = node.right;
		int sum = 0;
		if(left != null){
			sum += getSum(left.left) + getSum(left.right);
		}
		if(right != null) {
			sum += getSum(right.left) + getSum(right.right);
		}
		return sum;
	}
	public int getSum(Node node) {
		if(node == null)
			return 0;
		if(map.containsKey(node))
			return map.get(node);
		int sum1 = node.data + sumOfGrandChildren(node);
		int sum2 = getSum(node.left) + getSum(node.right);
		map.put(node,Math.max(sum1,sum2));
		return Math.max(sum1,sum2);
	}

}

