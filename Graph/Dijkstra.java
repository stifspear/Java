import java.util.*;
import java.io.*;
class Dijkstra
{
	private ArrayList<LinkedList<Integer>> adj;
	private int[][] weight;
	private int size;
	private MSTHeap heap_map = new MSTHeap();
	public Dijkstra(int size){
		this.size = size;
		weight = new int[size][size];
		adj = new ArrayList<LinkedList<Integer>>();
		for(int i=0;i<size;i++){
			adj.add(new LinkedList<Integer>());
		}
	}
	/*
	 * Add edge for directed graph
	 */
	public void addDEdge(int x ,int y, int wt){
		adj.get(x).add(y);
		weight[x][y]=wt;
	}
	/*
	 * Add edge for undirected graph
	 */
	public void addEdge(int x, int y, int wt){
		adj.get(x).add(y);
		adj.get(y).add(x);
		weight[x][y]=wt;
		weight[y][x]=wt;
	}
	/*
	 * Find all point shortest path
	 */
	public Map<Integer,Integer> findDPath(int start){
		Map<Integer,Integer> path = new HashMap<Integer,Integer>();
		Map<Integer,Integer> distance = new HashMap<Integer,Integer>();
		for(int i=0;i<size;i++){
			heap_map.addE(i,Integer.MAX_VALUE);
		}
		heap_map.decrease(start,0);
		path.put(start,-1);
		distance.put(start,0);
		while(!heap_map.map.isEmpty()){
			//heap_map.display();
			Node cur = heap_map.getMin();
			Iterator<Integer> iter = adj.get(cur.index).iterator();
			while(iter.hasNext()){
				int curVertex = iter.next();
				if(heap_map.map.containsKey(curVertex)){
					/*
					 * Index of current vertex int the arraylist minheap will be returned 
					 * Next three lines retrives the weight associated with the current vertex
					 */
					int curMap = heap_map.map.get(curVertex);
					Node tempVer = heap_map.minheap.get(curMap);
					int curwtg = tempVer.weight;
					/*
					 * Weight for current vertex using new path
					 */
					int dywtg = 0;
					if(distance.get(cur.index) != null){
						dywtg = distance.get(cur.index)+weight[cur.index][curVertex];
					}
					if(dywtg<curwtg){
						heap_map.decrease(curVertex,dywtg);
						path.put(curVertex,cur.index);
						distance.put(curVertex,dywtg);
					}
				}
			}
		}
		displayAllWeight(distance,start);
		//displayPath(path);
		return distance;

	}
	public void displayAllWeight(Map<Integer,Integer> map,int start){
		System.out.println("Enter");
		/*for(Integer key:map.keySet()){
			System.out.println(key+" "+map.get(key));
		}*/
		for(int i=0;i<size;i++){
			if(map.containsKey(i)&&i!=start){
				System.out.print(i+" "+map.get(i));
			} else if(i != start ){
				System.out.print(i+" -1");
			}
		}
		System.out.println();
	}
	public void displayPath(Map<Integer,Integer> map){
		for(Integer key:map.keySet()){
			int cur = key;
			System.out.print(cur+"===>");
			 while(map.get(cur)!=-1){
				 System.out.print(map.get(cur)+" ");
				 cur = map.get(cur);
			 }
			 System.out.println();
		}
	}
	
}
