import java.util.Queue;
class FraudulentActivity {	
	public static int[] getCount(int[] arr, int d) {
		int[] res = new int[202];
		for (int i=0; i<d; i++) {
			res[arr[i]]++;
		}
		return res;
	}
	public static double getMedian(int[] arr, Queue<Integer> q) {
		int[] temp = new int[202];
		temp[0] = arr[0];
		for (int i=1; i<202; i++) {
			temp[i] = temp[i-1] + arr[i];
		}
		for (int i=201; i>=0; i--) {
			temp[i] = temp[i-1];
		}
		temp[0] = 0;
		int[] sort = new int[q.size()];
		int j = 0;
		for (Integer val : q) {
			sort[temp[val]] = val;
			j++;
		}
		return 0;
	}
	public static void print(int[] arr) {
		for (int val : arr) {
			System.out.print(val+" ");
		}
		System.out.println();
	}
}
