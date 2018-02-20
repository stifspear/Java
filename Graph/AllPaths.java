import java.util.*;
class AllPaths
{
	static LinkedList<Integer> adj[];
	static boolean result;
	static int size;
	static boolean[] visited;
	static int[] path;
	public AllPaths(int se) {
		size=se;
		visited = new boolean[size];
		path = new int[size];
		adj = new LinkedList[size];
		for(int i=0;i<size;i++) {
			adj[i] = new LinkedList<Integer>();
			visited[i]=false;
		}
		//printAllPath(start,dest);
	}
	public void addEdge(int s,int u) {
		adj[s].add(u);
		adj[u].add(s);
	}
	public void printAllPath(int start,int dest,int med) {
		visited = new boolean[size];
		for(int i=0;i<size;i++) 
			visited[i]=false;
		path = new int[size];
		int path_index=0;
		result=false;
		printAllPaths(start,dest,visited,path,path_index,med);
		if(result)
			System.out.println("Yes");
		else
			System.out.println("No");
		
	}
	public boolean checkU(int[] path,int med) {
		boolean res=false;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<path.length;i++) {
			if(map.containsKey(path[i]))
				return false;
			else{
				map.put(path[i],1);
				if(path[i]==med)
					res=true;
			}
		}
		if(res)
			return true;
		return false;
	}
	public void printAllPaths(int s,int d,boolean[] visited,int[] path,int index,int med) {
		visited[s]=true;
		path[index]=s;
		index++;
		if(s==d) {
			if(checkU(path,med))
				result = true;		
		}
		else {
			Iterator<Integer> iter = adj[s].listIterator();
			while(iter.hasNext()){
				int next = iter.next();
				if(!visited[next]) {
					printAllPaths(next,d,visited,path,index,med);
				}
			}
		}
		index--;
		visited[s]=false;
	}
}
