/*
 * Program Description:
 * Date Created: Wed 20 Sep 2017 07:43:31 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class PriorityQueue
{
	private int size;
	Map<Integer,Integer> map; 			//Stores node to index in heap mapping
	ArrayList<Node> heap;				//Array used to implement minheap
	public PriorityQueue(int size){
		this.size = size;
		heap = new ArrayList<>();
		map = new HashMap<>();
		for(int i=0; i<size; i++){
			heap.add(new Node(i,Integer.MAX_VALUE));
			map.put(i,i);
		}
	}
	/* 
	 * Function to check if a priority queue contains an element
	 */
	public boolean contains(int key) {
		return map.containsKey(key);
	}
	/*
	 * Function to swap to nodes in a heap
	 */
	public void swap(int x, int y){
		/* swapping heap objects*/
		//System.out.println(x+" swap "+y);
		map.put(heap.get(x).index,y);
		map.put(heap.get(y).index,x);
		Node tempNode = heap.get(x);
		heap.set(x,heap.get(y));
		heap.set(y,tempNode);
		/* Updating mapping for new index */
		/*int temp = map.get(heap.get(x).index);
		map.put(x,map.get(heap.get(y).index));
		map.put(y,temp);*/
	}
	/*
	 * Function to return the parent of current node in the headp;
	 */
	public int getParent(int index) {
		int parent = (index-1)/2;
		if(parent>=0)
			return parent;
		return -1;
	}
	/*
	 * Function to return index of the left child
	 */
	public int getLeftChild(int index) {
		int child = 2*index+1;
		if(child < size)
			return child;
		return -1;
	}
	/*
	 * Function to return index of the right child
	 */
	public int getRightChild(int index) {
		int child = 2*index+2;
		if(child < size)
			return child;
		return -1;
	}
	/*
	 * Function to check if heap contains current index
	 */

	public boolean containsIndex(int index){
		return map.containsKey(index);
	}
	/*
	 * Function to decrease a value in the heap
	 */
	public void decrease(int node_number, int value) {
		int index = map.get(node_number);
		heap.get(index).weight = value;
		int parent = getParent(index);
		//System.out.println(parent);
		//System.out.println("Node"+node_number+" "+value+" "+index);
		while(parent != -1){
			//System.out.println(parent+" "+index+" "+heap.get(parent).weight+" "+heap.get(index).weight);
			if(heap.get(parent).weight > heap.get(index).weight) {
				swap(parent,index);
			} else {
				break;
			}
			index = parent;
			parent = getParent(parent);
		}
	}
	/*
	 * Function to retrieve the minimum element in the heap
	 */
	public Node getMin() {
		//display();
		//System.out.println(size);
		Node min = heap.get(0);
		swap(0,size-1);
		//System.out.println("**********");
		//display();
		heap.remove(size-1);
		map.remove(min.index);
		//display();
		//System.out.println("**********");
		size = size-1;
		int left = getLeftChild(0);
		int right = getRightChild(0);
		int smallest = 0;
		int parent = 0;
		//display();
		while(true) {
			/*display();
			System.out.println("getmin"+smallest+" "+left+" "+right+" "+heap.size());*/
			if(left != -1 && heap.get(left).weight < heap.get(smallest).weight){
				smallest = left;
			}
			if(right != -1 && heap.get(right).weight < heap.get(smallest).weight) {
				smallest = right;
			}
			if(smallest !=  parent) {
				swap(parent,smallest);
				parent = smallest;
				left = getLeftChild(parent);
				right = getRightChild(parent);
			} else {
				break;
			}
		}
		//display();
		//System.out.println(size);
		return min;
	}
	public void display() {
		for(Node node:heap){
			System.out.print(node.weight+" ");
		}
		System.out.println();
		for(Integer key:map.keySet()) {
			System.out.println(key+" "+map.get(key));
		}
		System.out.println("------------------");
	}
}

