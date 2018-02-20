/*
 * Program Description: Program for implementing graph class. Vetex starts form index 0. All vertex points are integers.
 * Date Created: Fri 15 Sep 2017 09:54:04 AM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
public abstract class Graph
{
	private int size;
	private int[][] weight;
	private ArrayList<LinkedList<Integer>> adj;
	public Graph(){
		size = 0;
		weight = new int[size][size];
		initialize();
	}
	public Graph(int size){
		this.size = size;
		weight = new int[size][size];
		initialize();
	}
	private void initialize(){
		adj = new ArrayList<>();
		for(int i=0; i<size; i++){
			adj.add(new LinkedList<>());
		}
	}
	public int getSize(){
		return size;
	}
	/*Functions to add directed or undirected edge
	 */
	public void addDEdge(int x, int y){
		adj.get(x).add(y);
	}
	public void addEdge(int x,int y){
		adj.get(x).add(y);
		adj.get(y).add(x);
	}
	/*
	 * Function to add weight on directed or undirected graph
	 */
	public void addWeight(int x,int y,int w){
		weight[x][y] = w;
	}
	public void addDWeight(int x,int y,int w){
		weight[x][y] = w;
		weight[y][x] = w;
	}
	public ArrayList<LinkedList<Integer>> getAdjList(){
		return adj;
	}
	public void printAdjList(){
		int head = 0;
		for(LinkedList<Integer> list:adj){
			System.out.print(head+"-->");
			for(Integer vertex:list){
				System.out.print(vertex+" ");
			}
			head++;
			System.out.println();
		}
	}
}

