import java.util.*;
class DijkstraTest
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int edges = in.nextInt();
		Dijkstra ob = new Dijkstra(size);
		for(int i=0;i<edges;i++){
			ob.addEdge(in.nextInt()-1,in.nextInt()-1,6);
		}
		int start = in.nextInt();
		ob.findDPath(start-1);

	}
}
