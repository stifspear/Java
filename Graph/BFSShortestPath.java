import java.io.*;
import java.util.*;
class BFSShortestPath
{
	ArrayList<LinkedList<Integer>> adj;
	int size;
	int[][] weight;
	boolean[] visited;
	public BFSShortestPath(int size){
		this.size = size;
		weight = new int[size][size];
		visited = new boolean[size];
		weight = new int[size][size];
		adj = new ArrayList<LinkedList<Integer>>();
		for(int i=0; i<size; i++)
			adj.add(new LinkedList<Integer>());
	}
	public void addEdge(int x,int y, int weight){
		adj.get(x).add(y);
		adj.get(y).add(x);
		this.weight[x][y] = weight;
		this.weight[y][x] = weight;
	}
	public int findShortestPath(int start,int end){
		Queue<Integer> queue = new LinkedList<Integer>();
		int[][] distance = new int[size][size];
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if(i == j)
					distance[i][j] = 0;
				else
					distance[i][j] = Integer.MAX_VALUE;
			}
		}
		HashSet<Integer> visitedPath = new HashSet<Integer>();
		queue.add(start);
		while(!queue.isEmpty()){
			int u = queue.poll();
			Iterator<Integer> list = adj.get(u).iterator();
			while(list.hasNext()){
				int v = list.next();
				if(distance[start][u]+weight[u][v] < distance[start][v]){
					distance[start][v] = distance[start][u]+weight[u][v];
					queue.add(v);
				}
			}
		}
		return distance[start][end];
	}
}
