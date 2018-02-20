import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Node {
	int index,value;
	Node next,prev;
	public Node(int index,int value) {
		this.index=index;
		this.value=value;
	}
}

public class Circular {

	static Node start;
	static Node last;
	public static void addNode(int index,int data) {
		Node newNode = new Node(index,data);
		if(start == null){
			start=newNode;
			newNode.prev=start;
			last=newNode;
		} else {
			newNode.prev=last;
			newNode.next=last.next;
			last.next=newNode;
			last=newNode;
		}

	}

	static int circularWalk(int n, int s, int t, int r_0, int g, int seed, int p){
		int count=0;
		addNode(0,r_0);
		for(int i=1;i<n;i++)
			addNode(i,(last.value*g+seed)%p);
		Node cur=start;
		for(int i=0;i<n;i++)
		{
			System.out.println(cur.value+" "+cur.index);
			cur=cur.next;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int s = in.nextInt();
		int t = in.nextInt();
		int r_0 = in.nextInt();
		int g = in.nextInt();
		int seed = in.nextInt();
		int p = in.nextInt();
		int result = circularWalk(n, s, t, r_0, g, seed, p);
		System.out.println(result);
	}
}

