import java.util.*;
class PrimsMain
{
	public static void main(String[] args){
		PrimsMST ob = new PrimsMST(6);
		ob.addEdge(0,1,3);
		ob.addEdge(0,3,1);
		ob.addEdge(1,3,3);
		ob.addEdge(1,2,1);
		ob.addEdge(2,5,4);
		ob.addEdge(2,3,1);
		ob.addEdge(3,4,6);
		ob.addEdge(4,5,2);
		ob.addEdge(2,4,5);
		Map<Integer,String> out = ob.drive(0);
		for(Integer trav:out.keySet()){
			System.out.println(out.get(trav));
		}
		//ob.display();
	}
}
