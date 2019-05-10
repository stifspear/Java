import java.util.HashMap;
class SpecialPalindromeAgain {
	public static int getAllPalidromeSubstring(String string, int len) {
		int count = 0;
		System.out.println(string+" "+len);
		for (int i=0; i<len; i++) {
			for (int j=1; j<=len-i; j++) {
				if (isSPalindrome(string.substring(i,i+j))) {
					count++;
					System.out.print(string.substring(i,i+j)+" ");
				}
			}
		}
		System.out.println();
		return count;
	}
	public static boolean isSPalindrome(String str) {
		int len = str.length();
		HashMap<Character, Integer> set = new HashMap<>();
		int count = 0;
		//System.out.println(str);
		for (int i=0; i<len; i++) {
			char ch = str.charAt(i);
			count = set.get(ch) == null ? 1 : set.get(ch) + 1;
			set.put(ch, count);
		}
		//System.out.println(set.entrySet());
		if ((set.size() == 2 && set.get(str.charAt(len/2)) == 1 && len % 2 != 0) || set.size() == 1)
			return true;
		return false;
	}
}
