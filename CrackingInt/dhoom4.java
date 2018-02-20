/*
 * Program Description:
 * Date Created: Thu 16 Nov 2017 07:47:50 PM IST
 * Author : Stif Spear Subba
 */
import java.util.*;
class dhoom4 {
	static int mod = 100000;
	public static void main(String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
		int init = in.nextInt();
		int tar = in.nextInt();
		int s = in.nextInt();
		int[] arr = new int[s];
		for(int i=0; i<s; i++){
			arr[i] = in.nextInt();
		}
		int key = findKey(arr,init,tar);
		System.out.println(key);

	}
	public static int findKey(int[] arr,int curk,int target) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(curk);
		int[] ans = new int[100005];
		Arrays.fill(ans,-1);
		ans[curk] = 0;
		int temp = 1;
		int c = 0;
		int v = 0;
		q.add(curk);
		while(!q.isEmpty()) {
			temp = 1;
			v = q.poll();
			if(v == target)
				break;
			for(int j=0; j<arr.length; j++) {
				temp = (int)(((long)v*arr[j])%mod);
				if(ans[temp]==-1)
				{
					ans[temp] = ans[v]+1;
					q.add(temp);
				}
			}
		}
		return ans[target];

	}
}
