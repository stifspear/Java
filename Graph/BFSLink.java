/*
 * Program to implement BFS using linked list
 * Date:10/12/16
 * Author: Stif Spear Subba
 */
import java.util.*;

class BFSLink
{
	LinkedList<Integer> adj[];
	int V;					//Stores the no of vertices in a graph
	public BFSLink(int n)
	{
		V=n;
		adj=new LinkedList[n];
		for(int i=0;i<V;i++)
		{
			adj[i]=new LinkedList<Integer>();
		}
	}
	public void add(int u,int v)
	{
		adj[u].add(v);
		adj[v].add(u);
	}
	public void display()
	{
		for(int i=0;i<V;i++)
		{
			Iterator<Integer> ii=adj[i].listIterator();
			while(ii.hasNext())
			{
				int next=ii.next();
				System.out.print(next+" ");
			}
			System.out.println();
		}
	}
	public void BFS(int start)
	{
		int[] visited=new int[V];
		visited[start]=1;
		LinkedList<Integer> queue=new LinkedList<Integer>();
		queue.add(start);
		while(queue.size()!=0)
		{
			int currentVertex=queue.poll();
			System.out.print(currentVertex+" ");
			Iterator<Integer> ii=adj[currentVertex].listIterator();
			while(ii.hasNext())
			{
				int next=ii.next();
				if(visited[next]!=1)
				{
					queue.add(next);
					visited[next]=1;
				}
			}
		}
		System.out.println();
	}
}
