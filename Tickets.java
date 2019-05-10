import java.io.*;
import java.util.*;
class Tickets {


	public static void main(String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(--t>=0) {
			int size = in.nextInt();
			int[] nei = new int[size];
			for (int i=0; i<size; i++) nei[i] = in.nextInt();
			System.out.println(getTickets(size, nei));
		}
		//Write code here


	}

	public static String getTickets(int size, int[] arr) {
		int isAllNegative = allNegative(arr);
		int[] sum = new int[size];
		List<Integer> eList = new ArrayList<>();
		List<Integer> oList = new ArrayList<>();
		if (isAllNegative < 0) return isAllNegative+"";
		sum[0] = (arr[0] > 0) ? arr[0] : 0;
		sum[1] = (arr[1] > 0) ? arr[1] : 0;
		if (sum[0] > 0) eList.add(arr[0]);
		if(sum[1] > 0) oList.add(arr[1]);
		for (int i=2; i<arr.length; i++) {
			if (arr[i] == 0) continue;
			if (arr[i] > 0) {
				sum[i] = sum[i-2] + arr[i];
				if (i%2 == 0) eList.add(arr[i]);
				else oList.add(arr[i]);
			} else if(arr[i] < 0){
				sum[i] = sum[i-2];
			}
		}
		if (size % 2 ==0) {
			return reverseStr(sum[size-2] >= sum[size-1] ? eList : oList);
		}
		return reverseStr(sum[size-2] >= sum[size-1] ? oList : eList);

	}
	public static int allNegative(int[] arr) {
		int min = 1000;
		int negC = 0;
		for (int val:arr) {
			if (val <= 0) {
				min = (val < min) ? val : min;
				negC++;
			}
		}
		return (negC == arr.length) ? min : 0;
	}
	public static String reverseStr(List<Integer> li) {
		String out = "";
		for (Integer val:li) {
			out = val+out;
		}
		return out;
	}
}

/*
   4 5 4 3
   sum[0] = 4 eList = 4
   sum[1] = 5 oList = 5
   sum[2] = 8 eList = 4 4
   sum[3] = 3 oList = 5 3

   -1 7 8 -5 4

   848

   5 10 4 -1


*/
