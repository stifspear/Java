import java.util.*;
class RandomNumbers
{
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		//System.out.println("How many numbers to generate?");
		long size = in.nextLong();
		//System.out.println("Enter the last range of the array");
		long last = in.nextLong();
		long[] arr = new long[(int)size];
		for(int i=0;i<size;i++) {
			arr[i]=(long)Math.ceil(Math.random()*last+1);
		}
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
