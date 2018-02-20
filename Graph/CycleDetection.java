/* * Program to implement DFS using linked list */
import java.util.*;

class CycleDetection
{
	LinkedList<Integer> adj[];
	int size;
	boolean visited[];
	public CycleDetection(int s)
	{
		size=s;
		visited=new boolean[s];
		adj=new LinkedList[size];
		for(int i=0;i<size;i++)
		{
			visited[i]=false;
			adj[i]=new LinkedList<Integer>();
		}
	}

	public void addEdge(int u,int v)
	{
		adj[u].add(v);
		//adj[v].add(u);
	}
	public void display()
	{
		for(int i=0;i<size;i++)
		{
			System.out.print(i+" ");
			Iterator<Integer> ii=adj[i].listIterator();
			while(ii.hasNext())
			{
				System.out.print(ii.next()+" ");
			}
			System.out.println();
		}
	}
	public LinkedList<Integer> DFS(int pos)
	{
		LinkedList<Integer> stack=new LinkedList<Integer>();
		LinkedList<Integer> cycle=new LinkedList<Integer>();
		stack.push(pos);
		cycle.push(pos);
		while(stack.size()!=0)
		{
			int num=stack.pop();
			//System.out.print(num+" ");
			visited[num]=true;
			Iterator<Integer> ii=adj[num].listIterator();
			while(ii.hasNext())
			{
				int nuu=ii.next();
				if(!visited[nuu])
				{
					visited[nuu]=true;
					stack.push(nuu);
					cycle.push(nuu);
				}
				else{

					cycle.push(nuu);

					return cycle;
				}
			}
		}
		return null;
	}
}	
