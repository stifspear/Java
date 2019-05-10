/*Problem Statement : Find a 2D peak in a given matrix.
 * 		matrix(i,j) is 2D peak iff {matrix(i-1,j),matrix(i+1,j),matrix(i,j+1),matrix(i,j-1)} <= matrix(i,j)
 * 		if matrix(i,j) is in the edge then the adjacent place numbers should be less than matrix(i,j)
 *  	Example : matrix = 1 2 3
 *  			  		   4 6 5   
 *  			  Peak = 6*/
import java.util.Scanner;
public class peakFinder2D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row, col;
		row = sc.nextInt();
		col = sc.nextInt();
		int matrix[][] = new int[row][col];
		 for( int i=0;i<row;i++)
		 {
			 for(int j=0;j<col;j++)
			 {
				 matrix[i][j]=sc.nextInt();
			 }
		 }
		 
		 int midCol= col/2;
		 int big = matrix[0][midCol];
		 int rowi = 0;
		 int peak=-1;
		 /*finding the global max in the mid column*/
		 for(int j=1;j<row;j++)
		 {
			 if(matrix[j][midCol] > big) 
			 {
				 big = matrix[j][midCol];
				 rowi = j;
			 }
			 
		 }
		 peak = peakFinder1d(rowi,midCol,matrix,col);

			if(peak != -1)
				System.out.println(peak);
			else
				System.out.println("doesn't exist");
			sc.close();

	}
	/*method to find the peak across the row similar to finding 1D peak*/
	public static int peakFinder1d(int i,int j,int matrix[][],int last)
	{
	    	int peak = -1;
	      
			while (j != last-1 && j != 0){
    			if(matrix[i][j] < matrix[i][j-1])
    			{
    				j = j-1;
    			}
    			else if(matrix[i][j] < matrix [i][j+1] )
    			{
    				j = j+1;
    			}
    			else
    			 {
    			     peak = matrix[i][j];
    			 }
			}
			peak = matrix[i][j];
			return peak;
	}

}
