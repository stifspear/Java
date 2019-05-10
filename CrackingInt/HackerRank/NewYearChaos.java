import java.util.*;
class NewYearChaos {
	public int minimumBribe(int[] a) {
		HashMap<Integer, Integer> bribeCounts = new HashMap<Integer, Integer>();
		int swaps = 0;
		boolean swap = false;
		int temp = 0;
		int bribeCount = 0;
		while(true) {
			swap = false;
			for (int i=0; i<a.length-1; i++) {
				if(a[i]>a[i+1]) {
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					swaps++;
					swap = true;
					bribeCount = (bribeCounts.get(temp)==null)?1:bribeCounts.get(temp)+1;
					bribeCounts.put(temp, bribeCount);
					System.out.println(temp+"---"+bribeCount);
					if(bribeCount > 2) {
						return -1;
					}
				}
			}
			if (!swap) break;
		}
		return swaps;
	}
}
