import java.io.*;
import java.util.*;
class BFSMinimum
{
	ArrayList<HashSet<Integer>> adj;
	int size;
	int[] distance;
	int weight;
	boolean[] visited;
	BFSMinimum(int size,int weight){
		this.size = size;
		this.distance = new int[size];
		this.weight = weight;
		Arrays.fill(this.distance,-1);
		visited = new boolean[size];
		adj = new ArrayList<HashSet<Integer>>();
		for(int i=0;i<size;i++){
			adj.add(new HashSet<Integer>());
		}
	}
	public void addEdge(int x,int y){
		adj.get(x).add(y);
		adj.get(y).add(x);
	}
	public void findShortest(int start){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;
		distance[start] = 0;
		while(!queue.isEmpty()){
			int cur = queue.poll();
			for(int v:adj.get(cur)){
				if(!visited[v]){
					queue.add(v);
					distance[v] = distance[cur] + weight;
					visited[v] = true;
				}
			}
		}
		for(int dist:distance){
			if(dist!=0){
				System.out.print(dist+" ");
			}
		}
		System.out.println();
		Arrays.fill(distance,-1);
		Arrays.fill(visited,false);
	}
}
