import java.util.*;
class toposort{
	int count=0;
	LinkedList<Integer>[] array;
	boolean[] visited;
	Stack<Integer> stack= new Stack<Integer>();
	public toposort(int n){
		array = new LinkedList[n];
		visited = new boolean[n];
		for(int i=0;i<n;i++){
			visited[i]=false;
			array[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int u,int v){
		array[u].add(v);
	}
	public void dfs(int n){
		visited[n]=true;
		//stack.push(n);


		Iterator<Integer> list =array[n].listIterator();
		while(list.hasNext()){
			int current=list.next();
			//stack.push(current);
			if(!visited[current]){
				dfs(current);

			}
		}
		System.out.println("Topo "+n);
		stack.push(n);
	}
	public void topos(int n){
		for(int i=n-1;i>=0;i--){
			System.out.println(i);
			if(!visited[i])
				dfs(i);
		}
		while(!stack.empty())
			System.out.print(stack.pop()+" ");
		System.out.println();
	}
	public void test() {
		this.addEdge(5,2);
		this.addEdge(5,0);
		this.addEdge(4,0);
		this.addEdge(4,1);
		this.addEdge(3,1);
		this.addEdge(2,3);
		topos(6);
	}
	/*public int count(int start,int target){
		int count=-1;
		if(stack.search(target)==-1)
			return count;
		else
			while(!stack.empty())
			{
				count++;
			}
		return count-1;	
	}*/


}
