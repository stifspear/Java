import java.util.*;
class CycleDetapp
{
	public static void main(String args[]){
		CycleDetection obj = new CycleDetection(5);
		LinkedList<Integer> stack = new LinkedList<Integer>();
		obj.addEdge(0,1);
		obj.addEdge(1,2);
		obj.addEdge(2,4);
		obj.addEdge(3,4);
		obj.addEdge(4,3);
		stack=obj.DFS(0);
		if(stack==null)
			System.out.println("No Cycle found");
		else{
			while(!stack.isEmpty()){
				System.out.println(stack.pop());
			}
		}
	}
}
