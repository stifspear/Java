class SortMerge {
	public static void merge(int[] arr, int[] arr2) {
		int[] arr3 = new int[arr.length+arr2.length];
		int i,j;
		i=j=0;
		int k = 0;
		while(i<arr.length && j<arr2.length) {
			if (arr[i] <= arr2[j]) {
				arr3[k++] = arr[i++];
			} else {
				arr3[k++] = arr2[j++];
			}
		}
		if (i < arr.length) {
			for (;i<arr.length; i++) {
				arr3[k++] = arr[i];
			}
		}
		if (j < arr2.length) {
			for (;j<arr2.length; j++) {
				arr3[k++] = arr[j];
			}
		}
		for (int val:arr3) {
			System.out.print(val+" ");
		}
		System.out.println();
	}
}
