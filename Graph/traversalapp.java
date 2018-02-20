/*
 * Main program to run DFS or BFS
 */
import java.util.*;
class traversalapp
{
	public static void main(String args[])
	{
		Scanner in =new Scanner(System.in);
		int ed = in.nextInt();
		Supervisor ob = new Supervisor(ed);
		int size = in.nextInt();
		ob.create();
		//ob.addEmp(0,0,0);
		for(int i=0;i<size;i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			ob.addEmp(x,y,0);
			//System.out.println(i);
		}
		ob.display();
		//ob.DFS(0);
		//System.out.println(max);
	}
}
