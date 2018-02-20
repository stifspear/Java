import java.util.*;
class driver
{
	public static void main(String[] args){
		FloydWarshall ob = new FloydWarshall(4);
		ob.addDEdge(0,3,15);
		ob.addDEdge(0,1,3);
		ob.addDEdge(0,2,6);
		ob.addDEdge(1,2,-2);
		ob.addDEdge(2,3,2);
		ob.addDEdge(3,0,1);
		int[][] out = ob.FW();
		ob.display(out);
		/*ob.displayPath(0,3);
		System.out.println("\nWeight="+out[0][3]);*/
		
	}
}
