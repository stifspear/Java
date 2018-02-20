import java.util.*;
import java.io.*;
class DisjointVertex
{
	public HashMap<String,VNode> map = new HashMap<String,VNode>();
	public void makeSet(String vertex){
		VNode newNode = new VNode();
		newNode.vertex = vertex;
		newNode.rank = 1;
		newNode.parent = newNode;
		map.put(vertex,newNode);
	}
	public VNode findSet(VNode x){
		if(x.parent == x){
			return x;
		} else {
			x = findSet(x.parent);
			x.parent = x;
		}
		//System.out.println("stuck");
		return x.parent;
	}
	public void union(String x,String y){
		VNode nx = map.get(x);
		VNode ny = map.get(y);
		nx = findSet(nx);
		ny = findSet(ny);
		if(nx.vertex == ny.vertex)
			return;
		if(nx.rank>ny.rank){
			ny.parent=nx;
			nx.rank++;
		} else {
			nx.parent = ny;
			ny.rank++;
		}
	}
}

