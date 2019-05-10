import java.util.*;
class FindMin {
	public static int searchVarCount(int[] arr, int k) {
		int valCount = 0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i] < k) {
				valCount++;
			}
		}
		return valCount;
	}
}
