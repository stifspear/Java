/*
 * Program Description:
 * Date Created: Thu 17 Aug 2017 10:00:28 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class AVLTree
{
	AVLNode root;
	public AVLTree(){
		root = null;
	}
	public AVLNode rotateLeft(AVLNode node){
		AVLNode y = node.right;
		AVLNode temp = y.left;
		node.right = temp;
		y.left = node;
		/*Updates the height after rotation
		*/
		node.height = Math.max(height(node.left),height(node.right))+1;
		y.height = Math.max(height(y.left),height(y.right))+1;
		return y;
	}
	public AVLNode rotateRight(AVLNode node){
		AVLNode y = node.left;
		AVLNode temp = y.right;
		node.left = temp;
		y.right = node;
		//Same as line 19
		node.height = Math.max(height(node.left),height(node.right))+1;
		y.height = Math.max(height(y.left),height(y.right))+1;
		return y;

	}
	public AVLNode insert(AVLNode node,int data){
		/*
		 * If else block insert data into binary tree
		 */
		if(node == null){
			return new AVLNode(data);
		}
		if(node.data<data){
			node.right = insert(node.right,data);
		} else if(node.data>data){
			node.left = insert(node.left,data);
		} else 
			return node;
		/*
		 * line 51-68 balancing is done. LL,LR,RR or RL
		 * if x is > 1 then right side has more height
		 * else f x < -1 left side has more height
		 */
		node.height = Math.max(height(node.left),height(node.right))+1;
		int balancefactor = isBalanced(node);
		if(balancefactor > 1 && data < node.left.data){
			return rotateRight(node);
		}
		if(balancefactor < -1 && data > node.right.data){
			return rotateLeft(node);
		}
		if(balancefactor > 1 && data > node.left.data){
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		if(balancefactor < -1 && data < node.right.data){
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
	}
	public AVLNode delete(AVLNode node,int data){
		//System.out.println("Delete1");
		if(node == null)
			return node;
		if(data > node.data){
			node.right = delete(node.right,data);
		} else if(data < node.data){
			node.left = delete(node.left,data);
		} else //Match is found
		{
			if(node.left == null || node.right == null){
			//System.out.println("match is found");
				AVLNode temp = null;
				//inOrder(node);
				System.out.println();
				if(temp == node.left){
					temp = node.right;
				} else {
					temp = node.left;
				}
				if(temp == null){
					node = null;
				}
				else {
					node = temp;
				}
				//inOrder(node);
				//System.out.println();

			} else {
				AVLNode toDelete = minValNode(node.right);
				node.data = toDelete.data;
				node.right = delete(node.right,toDelete.data);
			}
		}
		if(node == null)
			return node;
		node.height = 1+Math.max(height(node.left),height(node.right));
		int balancefactor = isBalanced(node);
		inOrder(node);
		System.out.println();
		if(balancefactor > 1 && isBalanced(node.left) >= 0){
			return rotateRight(node);
		}
		if(balancefactor < -1 && isBalanced(node.right) <= 0){
			return rotateLeft(node);
		}
		if(balancefactor > 1 && isBalanced(node.left) < 0){
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		if(balancefactor < -1 && isBalanced(node.right) > 0){
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		inOrder(node);
		System.out.println();
		return node;
	}
	public ArrayList<LinkedList<Integer>> getLevel(AVLNode node){
		ArrayList<LinkedList<Integer>> list= new ArrayList<LinkedList<Integer>>();
		getList(node,list,1);
		return list;
	}
	public void getList(AVLNode node, ArrayList<LinkedList<Integer>> list, int level){
		if(node == null)
			return;
		LinkedList<Integer> newlist = null;
		if(list.size() < level){
			newlist = new LinkedList<>();
			list.add(newlist);
		} else {
			newlist = list.get(level-1);
		}
		newlist.add(node.data);
		getList(node.left,list,level+1);
		getList(node.right,list,level+1);
	}
	public AVLNode minValNode(AVLNode node){
		AVLNode temp = node;
		while(temp.left != null){
			temp = temp.left;
		}
		return temp;
	}
	public int isBalanced(AVLNode node){
		if(node == null)
			return 0;
		return height(node.left) - height(node.right);
	}
	public void inOrder(AVLNode node){
		if(node == null)
			return;
		System.out.print(node.data+" ");
		inOrder(node.left);
		inOrder(node.right);
	}
	public int height(AVLNode node){
		if(node == null)
			return 0;
		return node.getHeight();
	}
}

