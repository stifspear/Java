import java.util.*;
class KrushkalTest
{
	public static void main(String[] args){
		Krushkal ob = new Krushkal(6);
		ob.addUEdge(0,1,3);
		ob.addUEdge(0,3,1);
		ob.addUEdge(1,3,3);
		ob.addUEdge(1,2,1);
		ob.addUEdge(2,5,4);
		ob.addUEdge(2,3,1);
		ob.addUEdge(3,4,6);
		ob.addUEdge(4,5,2);
		ob.addUEdge(2,4,5);
		ob.makeEdgeList();
		ob.sort();
		ob.makeSetEdge();
		ob.KMST();
		System.out.println("MST");
		ob.displayMst();
	}
}
