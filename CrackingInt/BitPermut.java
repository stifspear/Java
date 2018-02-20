import java.util.*;
class BitPermut
{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int inp = in.nextInt();
		int[] arr= new int[inp];
		int size = in.nextInt();
		for(int i=0;i<inp;i++){
			arr[i]=in.nextInt();
		}
		int smallest,largest;
		smallest=1;largest=11;
		for(int i=0;i<inp-2;i++){

			smallest+=(1<<1);
			largest+=(1<<1);
		}
		int[] temp=new int[size];
		int loop=0;
		int count=inp-1;
		System.out.println(smallest+" "+largest);
		for(int i=smallest;i<=largest-1;i++){
			loop=0;
			count=inp-1;
			for(int j=0;j<size;j++){
				if((i&(i<<j))==1){
					display(temp);
				}
			}
		}
	}
	public static void display(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
}
