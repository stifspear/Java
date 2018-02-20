import java.io.*;
import java.util.*;

public class BitMatrix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c;
		long r;
		int[] matrix;
		c = in.nextInt();
		r = in.nextLong();
		matrix = new int[c+1];
		while(--r!=0) {
			for(int i=0;i<c;i++){
				matrix[i]=in.nextInt();
			}
			matrix[c]=matrix[0];
			for(int i=0;i<c;i++) {
				matrix[i]=(int)(matrix[i]^matrix[i+1]);
				/*System.out.print(matrix[i]+" ");*/
			}
			matrix[c]=matrix[0];
			//System.out.println();
		}
		for(int i=0;i<c;i++)
			System.out.print(matrix[i]+" ");
		System.out.println();
	}
}
