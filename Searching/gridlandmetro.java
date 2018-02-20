import java.util.*;
class Path
{
	long start,end;
	public Path(long start,long end){
		this.start=start;
		this.end=end;
	}
}
class gridlandmetro
{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		HashMap<Long,ArrayList<Path>> paths = new HashMap<Long,ArrayList<Path>>();
		ArrayList<Path> list;
		long row=in.nextInt();
		long colum=in.nextInt();
		long trails=in.nextInt();
		for(long i=1;i<=trails;i++){
			long rowno=in.nextInt();
			long columnstart=in.nextInt();
			long columnend=in.nextInt();
			Path newPath = new Path(columnstart,columnend);
			//System.out.prlongln("I");
			if(paths.containsKey(rowno)){
				//System.out.prlongln("True");
				paths.get(rowno).add(newPath);
			} else {
			//	System.out.prlongln("False");
				list = new ArrayList<Path>();
				list.add(newPath);
				paths.put(rowno,list);
			}
			long count=0;
		}
		long post=0;
		for(Long e:paths.keySet()){
			//System.out.prlongln("i");
			//System.out.prlongln(e);
			ArrayList<Path> tracks = paths.get(e);
			tracks.sort(new Comparator<Path>(){	
			public int compare(Path a,Path b){
				return (int)(a.start-b.start);
			}
		});
			//tracks=doOverlapping(tracks);
			post+=doOverlapping(tracks);
		}	
		System.out.println(row*colum-post);
	}
	public static long doOverlapping(ArrayList<Path> trail){	
		long index=0;
		/*System.out.println("--");
		display(trail,trail.size());
		System.out.println("--");*/
		for(int i=1;i<trail.size();i++){
			/*index=1;*/
			Path one,two;
			one=trail.get((int)index);
			//System.out.println(one.start+"i"+one.end);

			two=trail.get(i);
			//System.out.println(two.start+"j"+two.end);

			if(one.end>=two.start){
				one.start=(one.start<=two.start)?one.start:two.start;
				one.end=(one.end>=two.end)?one.end:two.end;
				trail.set((int)index,one);
				//System.out.println(one.start+"i"+one.end);
				trail.remove(i);
				i=i-1;
				
			}else {
				index=i;
			}
			/*System.out.println("-");
		display(trail,trail.size());*/
			

		}
		//display(trail,(int)index);
		return countTracks(trail,trail.size());
	}
	public static long countTracks(ArrayList<Path> trail,long index){
		long sum=0;
		for(long i=0;i<index;i++){
			Path cur=trail.get((int)i);
			sum+=(cur.end==cur.start)?1:cur.end-cur.start+1;
		}
		return sum;
	}
	public static void display(ArrayList<Path> list,int size){
		for(int i=0;i<size;i++){
			Path cur=list.get(i);
			//System.out.println(cur.start+" "+cur.end);
		}
	}
}
