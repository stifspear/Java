class CommonChild {
	public static int commonChildCount(String str1, String str2) {
		int count1 = 0;
		int index = 0;
		char temp = 'a';
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for (int i=0; i<str1.length(); i++) {
			for (int j=0; j<str2.length(); j++) {
				if (i==0 && j==0) {
					dp[i+1][j+1] = 0;
				}
				if (str1.charAt(i) == str2.charAt(j)) {
					dp[i+1][j+1] = 1 + dp[i][j];
				} else {
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}
		}
		return dp[str1.length()][str2.length()];
	}
}
