import java.util.*;
class Krushkal
{
	ArrayList<LinkedList<Integer>> adj;
	DisjointVertex disjoint = new DisjointVertex();
	ArrayList<Edge> edges;
	int[][] weight;
	int size;
	ArrayList<Edge> out;
	public Krushkal(int size){
		this.size = size;
		out = new ArrayList<Edge>();
		adj = new ArrayList<LinkedList<Integer>>();
		for(int i=0;i<size;i++)
			adj.add(new LinkedList<Integer>());
		weight = new int[size][size];
		edges = new ArrayList<Edge>();
	}
	public void addUEdge(int x,int y,int wt){
		adj.get(x).add(y);
		adj.get(y).add(x);
		weight[x][y]=wt;
		weight[y][x]=wt;
	}
	public void sort(){
		Collections.sort(edges,(a,b) -> {
			String[] vertex = a.edge.split(" ");
			String[] vertex2 = b.edge.split(" ");
			return (Integer.parseInt(vertex[0])+a.weight+Integer.parseInt(vertex[1]) - Integer.parseInt(vertex2[0])+b.weight+Integer.parseInt(vertex2[1]));
		});
		Collections.sort(edges,(a,b) -> a.weight-b.weight);
	}
	/*public void sort(){
		Collections.sort(edges,(a,b) -> a.weight-b.weight);
	}*/
	public void makeEdgeList(){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(LinkedList<Integer> list:adj){
			int curInd = adj.indexOf(list);
			Iterator<Integer> iter = list.iterator();
			while(iter.hasNext()){
				int ind = iter.next();
				String curEdge = curInd+" "+ind;
				String op = ind+" "+curInd;
				if(!map.containsKey(curEdge)&&!map.containsKey(op)){
					map.put(curEdge,weight[curInd][ind]);
				}
			}
		}
		for(String key:map.keySet())
			edges.add(new Edge(key,map.get(key)));
	}
	public void makeSetEdge(){
		for(int i=0;i<size;i++)
			disjoint.makeSet(""+i);
	}
	public ArrayList<Edge> KMST(){
		//out = new ArrayList<Edge>();
		for(Edge edge:edges){
			String[] vertex = edge.edge.split(" ");
			String fVertex = vertex[0];
			String lVertex = vertex[1];
			VNode fver = disjoint.findSet(disjoint.map.get(fVertex));
			VNode lver = disjoint.findSet(disjoint.map.get(lVertex));
			if(!(fver.vertex.equals(lver.vertex))){
				out.add(edge);
				disjoint.union(fVertex,lVertex);
			} 
		}
	
		return out;
	}
	public void displayMst(){
		int size = 0;
		for(Edge edge : out){
			size += edge.weight;
		}
		System.out.println(size);
	}
	public void displayEdges(){
		for(Edge edge : edges){
			System.out.println(edge.edge+" "+edge.weight);
		}
	}
	public void displayAdj(){
		for(LinkedList<Integer> list:adj){
			int curInd = adj.indexOf(list);
			System.out.print(curInd+"-->");
			Iterator<Integer> iter = list.iterator();
			while(iter.hasNext()){
				int ind = iter.next();
				System.out.print(ind);
			}
			System.out.println();
		}
	}
}
