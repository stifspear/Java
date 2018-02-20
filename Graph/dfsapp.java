public class dfsapp
{
	public static void main(String args[]){
		dfsrec obj = new dfsrec(6);
		/*obj.addEdge(5,0);
		obj.addEdge(5,2);
		obj.addEdge(2,3);
		obj.addEdge(3,1);
		obj.addEdge(4,1);
		obj.addEdge(4,0);
		obj.toposort(6);*/
		obj.addEdge(1,0);
		obj.addEdge(2,1);
		obj.addEdge(3,1);
		obj.addEdge(4,2);
		obj.addEdge(5,4);
		obj.dfs(5,1);
		System.out.println(obj.count(5,1));
	}
}
