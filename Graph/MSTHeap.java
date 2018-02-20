import java.util.*;

class MSTHeap
{
	public int size;
	public ArrayList<Node> minheap;		//Stores the mean heap
	public Map<Integer,Integer> map; 	//Stores the mapping of every key to index in the mean heap array
	public MSTHeap(){
		minheap = new ArrayList<Node>();
		map = new HashMap<Integer,Integer>();
	}	
	public void removeVertex(int index){	//Removes the vertex at index
		map.remove(index);
	}
	public boolean containsIndex(int index){
		return map.containsKey(index);
	}
	public int readMin(){
		return minheap.get(0).index;	//Extracts the minimum element from mean heap. minimum element is minimum weight
	}
	public void addE(int x,int wtg){	//Add an edge to a head
		Node newNode = new Node(x,wtg);
		minheap.add(newNode);
		int current=minheap.size()-1;
		int parent=(current-1)/2;
		map.put(x,current);
		Node par;
		while(parent>=0){
			par=minheap.get(parent);
			if(newNode.weight<par.weight){
				swap(newNode,par);
				updateMap(newNode.index,par.index,current,parent);
				current=parent;
				parent=(parent-1)/2;
			} else {
				break;
			}
		}
	}
	public void decrease(int x,int newWtg){
		Integer pos = map.get(x);
		minheap.get(pos).weight=newWtg;
		int parent = (pos-1)/2;
		while(parent>=0){
			if(minheap.get(parent).weight>minheap.get(pos).weight){
				swap(minheap.get(parent),minheap.get(pos));
				updateMap(minheap.get(parent).index,minheap.get(pos).index,parent,pos);
				pos=parent;
				parent=(pos-1)/2;

			}
			else {
				break;
			}
		}
	}
	public Node getMin(){
		Node min = minheap.get(0);
		int last = minheap.size()-1;
		Node lastNode = minheap.get(last);
		minheap.set(0,lastNode);
		minheap.remove(last);
		map.remove(lastNode.index);
		map.remove(min.index);
		if(min.index!=lastNode.index)
			map.put(lastNode.index,0);
		int parent=0;
		int current=0;
		while(true){
			parent=current;
			int l=current*2+1;
			int r = current*2+2;
			if(l<minheap.size()&&minheap.get(current).weight>minheap.get(l).weight){
				current=l;
			}
			if(r<minheap.size()&&minheap.get(current).weight>minheap.get(r).weight){
				current=r;
			}
			if(current!=parent){
				swap(minheap.get(parent),minheap.get(current));
				updateMap(minheap.get(parent).index,minheap.get(current).index,parent,current);
			} else {
				break;
			}


		}
		return min;
	}
	public void swap(Node n1,Node n2){
		int index=n1.index;
		int wtg=n1.weight;
		n1.index=n2.index;
		n1.weight=n2.weight;
		n2.index=index;
		n2.weight=wtg;
	}
	public void updateMap(int old,int newi,int cur,int par){
		map.remove(old);
		map.remove(newi);
		map.put(old,cur);
		map.put(newi,par);
	}
	public void display(){
		System.out.println("Array List");
		for(Node trav:minheap){
			System.out.println(trav.index+" "+trav.weight);
		}
		System.out.println("----Mapdisplay-----");
		for(Integer trav:map.keySet()){
			System.out.println(trav+" "+map.get(trav));
		}
	}
}
