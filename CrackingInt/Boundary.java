/*
 * Program Description:
 * Date Created: Mon 25 Sep 2017 02:18:34 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class GfG
{
	ArrayList<Deque<Integer>> levelOrder = new ArrayList<Deque<Integer>>();
	void printBoundary(Node node)
	{
		makeOrder(node,0);
		//display();
		System.out.println(levelOrder.size());
		int height = levelOrder.size();
		for(int i=0; i<height-1; i++){
			System.out.print(levelOrder.get(i).removeFirst()+" ");
		}
		//System.out.println();
		levelOrder.remove(0);
		height = levelOrder.size();
		Deque<Integer> temp = levelOrder.get(height-1);
		int si = temp.size();
		//System.out.println(temp);
		for(int i=0; i<si; i++){
			System.out.print(temp.removeFirst()+" ");
			//System.out.println(temp);
		}
		levelOrder.remove(height-1);
		for(int i=height-2; i>=0; i--){
			System.out.print(levelOrder.get(i).removeLast()+" ");
		}
		System.out.println();

	}
	public void makeOrder(Node node,int level) {
		if(node == null)
			return;
		if(levelOrder.size() <= level){
			levelOrder.add(new LinkedList<Integer>());
		}
		Deque<Integer> dq = levelOrder.get(level);
		dq.addLast(node.data);
		makeOrder(node.left,level+1);
		makeOrder(node.right,level+1);
	}
	public void display() {
		for(Deque<Integer> que:levelOrder){
			System.out.println(que);
		}
	}
}


class Boundary
{
	int height(Node node)
	{
		if(node==null)
			return 0;
		int l = 1+height(node.left);
		int r = 1+height(node.right);
		if(l>r)
			return l;
		else
			return r;
	}

	public static void main(String args[])
	{

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0)
		{
			HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
			int n = sc.nextInt();

			Node root=null;

			while (n > 0)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);


				Node parent = m.get(n1);
				if (parent == null)
				{
					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}

				Node child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
				n--;
			}

			GfG g = new GfG();
			g.printBoundary(root);
			System.out.println();
			t--;

		}
	}
}
