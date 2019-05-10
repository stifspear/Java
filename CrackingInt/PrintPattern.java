class PrintPattern {
	public static void printPattern(int n) {
		for (int i=0; i<n; i++) {
			if (i%2 == 0) {
				for (int j=0; j<6; j++) {
					System.out.print(i+1);
				}
				System.out.print(i+2);
			} else {
				System.out.print(i+2);
				for (int j=0; j<6; j++) {
					System.out.print(i+1);
				}
			}
			System.out.println();
		}
	}
}
