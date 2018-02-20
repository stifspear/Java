/*
 * HackerEarth Problem
 */
import java.util.*;
public class Comrades
{
	int size;
	int[] dfsin;
	int[] dfsout;
	int[] curheight;
	int height;
	int dfsnumber;
	LinkedList<Integer>[] list;
	public Comrades(int n){
		size=100001;
		height=0;
		dfsin=new int[n];
		dfsout=new int[n];
		curheight=new int[n];
		dfsnumber=0;
		list = new LinkedList[n];
		for(int i=0;i<n;i++){
			dfsin[i]=0;
			dfsout[i]=0;
			curheight[i]=0;
			list[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int x,int y){
		list[x].add(y);
	}
	void dodfs(int curLevel,int height){
		dfsin[curLevel]=dfsnumber++;
		curheight[curLevel]=height;

		Iterator<Integer> adjlist = list[curLevel].listIterator();
		while(adjlist.hasNext()){
			int nex=adjlist.next();
			dodfs(nex,height+1);
		}
		dfsout[curLevel]=dfsnumber++;
	}
	void calculate(int x,int y){
		dodfs(1,0);
		if(dfsin[x]>dfsin[y]&&dfsout[x]<dfsout[y])
			System.out.println(curheight[x]-curheight[y]-1);
		else
			System.out.println(-1);
	}


	
}
