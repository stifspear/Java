/*
 * Program to implement BFS using linked list
 * Date:10/12/16
 * Author: Stif Spear Subba
 */
import java.util.*;

class BFSTest extends Graph
{
	public BFSTest(int size){
		super(size);
	}
	public void add(int u,int v){
		addEdge(u,v);
	}
	public void BFS(int start)
	{
		int[] visited=new int[getSize()];
		visited[start]=1;
		LinkedList<Integer> queue=new LinkedList<Integer>();
		queue.add(start);
		while(queue.size()!=0)
		{
			int currentVertex=queue.poll();
			System.out.print(currentVertex+" ");
			Iterator<Integer> ii=getAdjList().get(currentVertex).listIterator();
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
	public void display(){
		printAdjList();
	}
}
