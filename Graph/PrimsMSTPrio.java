import java.util.*;
class PrimsMSTPrio
{
	ArrayList<LinkedList<Integer>> adj;
	int[][] weight;
	int size;
	PriorityQueue heap;
	public PrimsMSTPrio(int size){
		adj = new ArrayList<LinkedList<Integer>>();
		heap = new PriorityQueue(size);
		for(int i=0;i<size;i++){
			adj.add(new LinkedList<Integer>());
		}
		weight = new int[size][size];
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				weight[i][j] = Integer.MAX_VALUE;
			}
		}
		this.size=size;
	}
	public void addEdge(int x,int y, int wt) {
		if(weight[x][y] > wt){
			adj.get(x).add(y);
			adj.get(y).add(x);
			weight[y][x] = wt;
			weight[x][y] = wt;
		}
	}
	public Map<Integer,String> drive(int start){
		Map<Integer,String> out = new HashMap<Integer,String>();
		heap.decrease(0,0);
		int outwtg = 0;
		while(heap.heap.size()>0){
			Node cur = heap.getMin();
			outwtg+=cur.weight;
			int curInd = cur.index;
			Iterator<Integer> iter = adj.get(curInd).iterator();
			while(iter.hasNext()){
				int nex = iter.next();
				if(heap.containsIndex(nex)){
					int weighttemp = weight[curInd][nex];
					if(heap.heap.get(heap.map.get(nex)).weight>weighttemp){
						heap.decrease(nex,weighttemp);
						out.put(nex,""+curInd+nex);

					}
				}
			}
		}
		System.out.println(outwtg);
		return out;
	}
	public void display(){
		System.out.println("Linked List");
		for(LinkedList<Integer> trav:adj){
			Object[] out = trav.toArray();
			for(int i=0;i<out.length;i++){
				System.out.print(out[i]+" ");
			}
			System.out.println();
		}
		System.out.println("Weight list");
		for(int i=0;i<weight.length;i++){
			for(int j=0;j<weight.length;j++){
				System.out.print(weight[i][j]+" ");
			}
			System.out.println();
		}
	}
}
