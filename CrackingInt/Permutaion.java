import java.util.*;
class Permutation
{
	public static TreeMap<Integer,Integer> tree = new TreeMap<Integer,Integer>();
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int sz=in.nextInt();
		int k=in.nextInt();
		int[] arr=new int[sz];
		int[] temp=new int[k];
		for(int i=0;i<sz;i++){
			arr[i]=in.nextInt();
		}
		permute(arr,temp,0,k,0,arr.length);
		int val=tree.lastKey();
		System.out.println(val);
		System.out.println(tree.get(val));
	}
	public static void permute(int[] arr,int[] temp,int index,int psize,int size,int arrsize) {
		if(index==psize) {
			for(int i=0;i<psize;i++)
			{
				//display(temp);
				doBitAnd(temp);
				return;
				//doBitAnd(temp);
			}
			//return;
		}	
		if(size>=arrsize)
			return;
		temp[index]=arr[size];
		permute(arr,temp,index+1,psize,size+1,arrsize);
		//temp[index]="";
		permute(arr,temp,index,psize,size+1,arrsize);
	}
	public static void doBitAnd(int[] temp) {
		int sum=(int)((temp[0])%(10e9+7));
		//System.out.println(sum);
		for(int i=1;i<temp.length;i++) {
			sum=(sum&(int)((temp[i])%(10e9+7)));
			/*System.out.println(sum+" "+temp[i]);*/
			//System.out.println(temp[i]+" ");
		}
		//System.out.println(sum);
		if(tree.containsValue(sum)) 
			tree.put(sum,tree.get(sum)+1);
		else
			tree.put(sum,1);
			}
}
