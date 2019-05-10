class MinSwaps {
	static int minimumSwaps(int[] arr) {
		int count = 0;
		int temp = 0;
		int index = 0;
		for (int i=0; i<arr.length; i++) {
			index = 0;
			if (arr[i] != i+1) {
				count++;
				temp = arr[i];
				index = findN(arr, i+1);
				arr[i] = i+1;
				arr[index] = temp;
				print(arr);
				System.out.println(index);
			}
		}
		if (count == 0) return 0;
		return count-1;
	}
	static int findN(int[] arr, int n) {
		//System.out.println("n"+n);
		for(int i=0; i<arr.length; i++) {
			if (arr[i] == n) {
				//System.out.println(i+" "+arr[i]);
				return i;
			}
		}
		return 0;
	}
	static void print(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
