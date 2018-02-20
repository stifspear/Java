import java.util.*;
class Emp
{
	int sup,status,id;
	public Emp(int id,int sup,int status) {
		this.sup=sup;
		this.status=status;
		this.id=id;
	}
}
class Supervisor
{
	Stack<Emp> em = new Stack<Emp>();
	boolean visited[];
	LinkedList<Emp> adj[];int size;
	public Supervisor(int size){
		this.size=size;
		visited = new boolean[size];
		adj = new LinkedList[size];
	}
	void create(){
		for(int i=0;i<size;i++)
		{
			visited[i]=false;
			adj[i]=new LinkedList<Emp>();
		}
	}
	public void addEmp(int id,int sup,int stat) {
		adj[sup].add(new Emp(id,sup,stat));
		//adj[id].add(new Emp(id,sup,stat));
	}
	public void display() {
		for(int i=0;i<size;i++) {
			Iterator<Emp> tra = adj[i].listIterator();
			while(tra.hasNext()) {
				Emp temp=tra.next();
				System.out.print(temp.id+" ");
			}
			System.out.println();
			//System.out.println(i);
		}
	}
	public void count() {
		int count=0;
		int step=0;
	}
	public void BFS(int start)
	{
		visited[start]=true;
		Queue<Emp> queue=new LinkedList<Emp>();
		queue.add(adj[0].peek());
		while(queue.size()!=0)
		{
			Emp currentVertex=queue.poll();
			System.out.println(currentVertex.id);
			Iterator<Emp> ii=adj[currentVertex.id].listIterator();
			while(ii.hasNext()&&!visited[currentVertex.id])
			{
				Emp next=ii.next();
				queue.add(next);
				visited[currentVertex.id]=true;
			}
		}
	}
}

