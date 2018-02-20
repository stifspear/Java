import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Node{
	int weight;
	String key;
}

public class BinaryMinHeap {

	public static List<Node> allNodes = new ArrayList<>();
	public static Map<String,Integer> nodePosition = new HashMap<>();
	/**
	 *      * Checks where the key exists in heap or not
	 *           */
	public static boolean containsData(String key){
		return nodePosition.containsKey(key);
	}
	/**
	 *      * Add key and its weight to they heap
	 *           */
	public static void add(int weight,String key) {
		Node node = new Node();
		node.weight = weight;
		node.key = key;
		allNodes.add(node);
		int size = allNodes.size();
		int current = size - 1;
		int parentIndex = (current - 1) / 2;
		System.out.println(current+" v "+parentIndex+" size "+size);
		nodePosition.put(node.key, current);

		while (parentIndex >= 0) {
			Node parentNode = allNodes.get(parentIndex);
			Node currentNode = allNodes.get(current);
			if (parentNode.weight > currentNode.weight) {
				swap(parentNode,currentNode);
				updatePositionMap(parentNode.key,currentNode.key,parentIndex,current);
				current = parentIndex;
				parentIndex = (parentIndex - 1) / 2;
			} else {
				break;
			}
		}
	}

	/**
	 *      * Get the heap min without extracting the key
	 *           */
	public static String min(){
		return allNodes.get(0).key;
	}

	/**
	 *      * Checks with heap is empty or not
	 *           */
	public static boolean empty(){
		return allNodes.size() == 0;
	}

	/**
	 *      * Decreases the weight of given key to newWeight
	 *           */
	public static void decrease(String data, int newWeight){
		Integer position = nodePosition.get(data);
		allNodes.get(position).weight = newWeight;
		int parent = (position -1 )/2;
		while(parent >= 0){
			if(allNodes.get(parent).weight > allNodes.get(position).weight){
				swap(allNodes.get(parent), allNodes.get(position));
				updatePositionMap(allNodes.get(parent).key,allNodes.get(position).key,parent,position);
				position = parent;
				parent = (parent-1)/2;
			}else{
				break;
			}
		}
	}

	/**
	 *      * Get the weight of given key
	 *           */
	public static Integer getWeight(String key) {
		Integer position = nodePosition.get(key);
		if( position == null ) {
			return null;
		} else {
			return allNodes.get(position).weight;
		}
	}

	/**
	 *      * Returns the min node of the heap
	 *           */
	public static Node extractMinNode() {
		int size = allNodes.size() -1;
		Node minNode = new Node();
		minNode.key = allNodes.get(0).key;
		minNode.weight = allNodes.get(0).weight;

		int lastNodeWeight = allNodes.get(size).weight;
		allNodes.get(0).weight = lastNodeWeight;
		allNodes.get(0).key = allNodes.get(size).key;
		nodePosition.remove(minNode.key);
		nodePosition.remove(allNodes.get(0));
		nodePosition.put(allNodes.get(0).key, 0);
		allNodes.remove(size);

		int currentIndex = 0;
		size--;
		while(true){
			int left = 2*currentIndex + 1;
			int right = 2*currentIndex + 2;
			if(left > size){
				break;
			}
			if(right > size){
				right = left;
			}
			int smallerIndex = allNodes.get(left).weight <= allNodes.get(right).weight ? left : right;
			if(allNodes.get(currentIndex).weight > allNodes.get(smallerIndex).weight){
				swap(allNodes.get(currentIndex), allNodes.get(smallerIndex));
				updatePositionMap(allNodes.get(currentIndex).key,allNodes.get(smallerIndex).key,currentIndex,smallerIndex);
				currentIndex = smallerIndex;
			}else{
				break;
			}
		}
		return minNode;
	}
	/**
	 *      * Extract min value key from the heap
	 *           */
	public static String extractMin(){
		Node node = extractMinNode();
		return node.key;
	}

	public static void printPositionMap(){
		System.out.println(nodePosition);
	}

	public static void swap(Node node1,Node node2){
		int weight = node1.weight;
		String data = node1.key;

		node1.key = node2.key;
		node1.weight = node2.weight;

		node2.key = data;
		node2.weight = weight;
	}

	public static void updatePositionMap(String data1, String data2, int pos1, int pos2){
		nodePosition.remove(data1);
		nodePosition.remove(data2);
		nodePosition.put(data1, pos1);
		nodePosition.put(data2, pos2);
	}

	public static void printHeap(){
		for(Node n : allNodes){
			System.out.println(n.weight + " " + n.key);
		}
		System.out.println("___________");
		for(String key : nodePosition.keySet()){
			System.out.println(key+" "+nodePosition.get(key));
		}
	}
}

