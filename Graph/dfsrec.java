import java.util.*;
class dfsrec{
	int count=0;
	LinkedList<Integer>[] array;
	boolean[] visited;
	Stack<Integer> stack= new Stack<Integer>();
	public dfsrec(int n){
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
	public void dfs(int n,int target){
		visited[n]=true;
		//stack.push(n);
		if(n==target)
			return;

		Iterator<Integer> list =array[n].listIterator();
		while(list.hasNext()){
			int current=list.next();
			stack.push(current);
			if(!visited[current]){
				dfs(current,target);
				if(current!=target)
					stack.pop();
				else
					break;
			}
		}
		/*stack.push(n);*/

	}
	/*public void toposort(int n){
	  for(int i=0;i<n;i++){
	  if(!visited[i])
	  dfs(i);
	  }
	  while(!stack.empty())
	  System.out.print(stack.pop()+" ");
	  System.out.println();
	  }*/
	public int count(int start,int target){
		int count=-1;
		if(stack.search(target)==-1)
			return count;
		else
			while(!stack.empty())
			{
				count++;
			}
		return count-1;	
	}


}
