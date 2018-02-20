import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindTheMonster {

	static long getMaxMonsters(int n, int hit, int t, int[] h){
		Arrays.sort(h);
		int i=0;
		long count=0;
		while(i<h.length&&t>=0){

			t-=h[i];
			if(t>=0)
				count++;
			i++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int hit = in.nextInt();
		int t = in.nextInt();
		int[] h = new int[n];
		for(int h_i=0; h_i < n; h_i++){
			h[h_i] = (int)Math.ceil((double)in.nextInt()/hit);

		}
		long result = getMaxMonsters(n, hit, t, h);
		System.out.println(result);
	}
}

