import java.io.*;
import java.util.*;
public class Game {
	public static void main(String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(--t>=0) {
			int size = in.nextInt();
			int[] villians = new int[size];
			int[] heroes = new int[size];
			for (int i=0; i<size; i++) villians[i] = in.nextInt();
			for (int j=0; j<size; j++) heroes[j] = in.nextInt();
			if (canWin(villians, heroes)) System.out.println("WIN");
			else System.out.println("LOSE");
		}
		//Write code here

	}

	public static boolean canWin(int[] villians, int[] heroes) {
		Arrays.sort(villians);
		Arrays.sort(heroes);
		for (int i=0; i<villians.length; i++) {
			if (villians[i] > heroes[i]) return false;
		}
		return true;
	}

}

