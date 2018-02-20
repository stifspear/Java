public class findABC
{
	public static void findAbc(String input) {
		int index = input.indexOf("abc");
		while (true) {
			if (index >= input.length()-3 || index ==-1 ) {
				break;
			}
			System.out.println((index+1)+" "+(index+4));
			String found = input.substring(index+1, index+4);
			System.out.println(found);
			index = input.indexOf("abc", index+3);
			System.out.println(index);
		}
	}
	public static void main(String args[]) {
		findAbc("abcabcabcabca");
		//findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");

	}
}
