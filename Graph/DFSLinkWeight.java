/* * Program to implement DFS using linked list */
import java.util.*;

class DFSLink
{
	class Edge{
		int src,dest;
		int wt;
		public Edge(int src,int dest,int wt){
			this.src=src;
			this.dest=dest;
			this.wt=wt;
		}
	}
	LinkedList<Edge> adj[];
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
			adj[i]=new LinkedList<Edge>();
		}
	}

	public void addEdge(Edge u)
	{
		adj[u.src].add(u);
		//adj[v].add(u);
	}
	public void display()
	{
		for(int i=0;i<size;i++)
		{
			System.out.print(i+" ");
			Iterator<Edge> ii=adj[i].listIterator();
			while(ii.hasNext())
			{
				System.out.print(ii.next()+" ");
			}
			System.out.println();
		}
	}
	public void DFS(int pos)
	{
		LinkedList<Integer> stack=new LinkedList<Integer>();
		stack.push(pos);
		while(stack.size()!=0)
		{
			int num=stack.pop();
			System.out.print(num+" ");
			visited[num]=true;
			Iterator<Edge> ii=adj[num].listIterator();
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
	}
}	
