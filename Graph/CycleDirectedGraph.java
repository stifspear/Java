import java.util.*;
import java.io.*;
class CycleDirectedGraph
{
	HashSet<Integer> white;
	HashSet<Integer> grey;
	HashSet<Integer> black;
	int size;
	ArrayList<LinkedList<Integer>> adj;
	HashMap<Integer,Integer> backEdge;
	public CycleDirectedGraph(int size){
		this.size = size;
		white = new HashSet<Integer>();
		grey = new HashSet<Integer>();
		black = new HashSet<Integer>();
		backEdge = new HashMap<Integer,Integer>();
		adj = new ArrayList<LinkedList<Integer>>();
		for(int i= 0;i<size;i++){
			adj.add(new LinkedList<Integer>());
		}

	}
	public void addEdge(int x,int y){
		adj.get(x).add(y);
		white.add(x);
		white.add(y);
	}
	public void findCycle(){
		while(white.size()>0){
			int ver = white.iterator().next();
			backEdge.put(ver,null);
			if(dfs(ver,new ArrayList<Integer>())){
				printMap();
				backEdge = new HashMap<Integer,Integer>();
			}

		}
	}
	public void printMap(){
		System.out.println("Cyclefound");
		for(Integer key:backEdge.keySet()){
			if(backEdge.get(key)==null){
				System.out.println(key+" null");
			} else {
				System.out.println(key+" "+backEdge.get(key));
			}
		}
	}
	public boolean dfs(int start,ArrayList<Integer> marked){
		marked.add(start);
		moveVertex(start,white,grey);
		for(Integer curVer:adj.get(start)){
			backEdge.put(curVer,start);
			if(black.contains(curVer)){
				continue;
			}
			if(grey.contains(curVer)){
				return true;
			}
			if(dfs(curVer,marked)){
				return true;
			}

		}
		moveVertex(start,grey,black);
		for(Integer all:marked){
			if(backEdge.containsKey(all)){
				backEdge.remove(all);
			}
		}
		return false;
	}
	public void moveVertex(int x,HashSet<Integer> first,HashSet<Integer> second){
		first.remove(x);
		second.add(x);
	}
}
