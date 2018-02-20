/* * Program to implement DFS using linked list */
import java.util.*;

class DFSLink
{
	LinkedList<Integer> adj[];
	int size;
	boolean visited[];
	public DFSLink(int s)
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
		adj[v].add(u);
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
	public int DFS(int pos)
	{
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(pos);
		int count=0;
		while(stack.size()!=0)
		{
			int num=stack.pop();
			count++;
			//System.out.println(num+" ");
			visited[num]=true;
			Iterator<Integer> ii=adj[num].listIterator();
			while(ii.hasNext())
			{
				int nuu=ii.next();
				if(!visited[nuu])
				{
					visited[nuu]=true;
					stack.push(nuu);
				}
			}
		}
		return count;
	}
}
