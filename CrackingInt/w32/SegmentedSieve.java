import java.util.*;
class SegmentedSieve
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(test-->0){
			//int l = in.nextInt();
			int n=in.nextInt();
			//long t1 = System.currentTimeMillis();
			ArrayList<Integer> out = getPrime(n);
			//System.out.println(System.currentTimeMillis()-t1);
			//t1 = System.currentTimeMillis();
			//ArrayList<Integer> out1 = getPrime(n);
			//System.out.println(System.currentTimeMillis()-t1);
			for(Integer key:out){
				//if(key>=l)
					System.out.println(key+" ");
			}
			//System.out.println();
			//for(Integer key:out1){
			//System.out.print(key+" ");
			//}
		}
	}
	public static ArrayList<Integer> getSPrime(int n){
		ArrayList<Integer> out = new ArrayList<Integer>();
		ArrayList<Integer> out2 = new ArrayList<Integer>();
		int limit =(int) Math.sqrt(n);
		out = getPrime(limit);
		for(Integer key:out)
			out2.add(key);
		//System.out.println(out2);
		boolean[] prime = new boolean[limit];
		int low = limit+1;
		int high = limit*2;
		while(low<=n){
			//System.out.println(low+" "+high);
			for(int tempi = 0;tempi<limit&&tempi+low<=n;tempi++)
				prime[tempi]=true;
			for(Integer value:out){
				int curlow = (low/value)*value;
				if(curlow<low)
					curlow+=value;
				for(int tc = curlow;tc<=high&&(tc-low)<limit;tc=tc+value){
					prime[tc-low]=false;
				}
			}
			for(int tc=low;tc<=high;tc++){
				if(prime[tc-low]&&!out2.contains(tc))
					out2.add(tc);
			}
			low=low+limit;
			high = high+limit;
			if(high>n){
				high = n;
			}
		}
		return out2;
	}
	public static ArrayList<Integer> getPrime(int n){
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean[] prime = new boolean[n+1];
		for(int i=0;i<=n;i++)
			prime[i]=true;
		for(int i=2;i<=n;i++){
			if(prime[i]&&isPrime(i)){
				list.add(i);
				//int con = i;
				for(int j=i;j<=n;j=j+i){
					prime[j]=false;
				}
			}
		}
		return list;

	}
	public static boolean isPrime(int x){
		for(int i=2;i<=Math.sqrt(x);i++){
			if(x%i==0)
				return false;
		}
		return true;
	}
}
