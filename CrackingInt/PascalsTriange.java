import java.util.*;
class PascalsTriangle
{
	public static void main(String args[]) 
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] pas = new int[n][n+1];
		for( int i=0;i<n;i++ ) {
			for(int j=0;j<=i;j++) {
				if(j==0||j==n)
					pas[i][j]=1;
				else {
					pas[i][j]=pas[i-1][j]+pas[i-1][j-1];
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n+1;j++) {
				if(pas[i][j]!=0)
					System.out.print(pas[i][j]+" ");
			}
			System.out.println();
		}
	}
}
