/* Read input from STDIN. Print your output to STDOUT*/
import java.util.*;
import java.text.DecimalFormat;
public class CandidateCode {
	public static void main(String args[] ) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(--T>=0)
		{
			int L = sc.nextInt();
			int coordinates[][] = new int[L][2];
			for(int i=0;i<L;i++)
			{
				for(int j=0;j<2;j++){
					coordinates[i][j]=sc.nextInt();
				}
			}

			calcRadiusAndEffectiveSet(coordinates,L);
		}
		sc.close();
	}
	/*Calculation of the radius and effective set*/
	public static void calcRadiusAndEffectiveSet(int coordMat[][],int row)
	{
		int curX;
		int curY;
		double x=0.00;
		double y=0.00;
		double rad=0.00;
		double minRad=-1.0;
		double minRadArr[]=new double[row];
		int curRows=0,k=0,ctr=0;
		while(curRows<row){

			curX=coordMat[curRows][0];
			curY=coordMat[curRows][1];

			for(int i=0;i<row;i++)
			{
				if(i!=curRows){
					x=Math.pow(curX-coordMat[i][0],2);
					y=Math.pow(curY-coordMat[i][1],2);
					rad=Math.sqrt(x+y);

					if(minRad== -1.0)
						minRad=rad;

					if(minRad>rad)
					{
						minRad=rad;
					}

					minRadArr[k++]=rad;
				}
			}

			//check counter for points in effective set 
			for(int i=0;i<row-1;i++)
			{

				if(minRadArr[i]<=minRad*2)
				{
					ctr++;
				}
			}

			DecimalFormat df = new DecimalFormat("0.00");
			System.out.println(df.format(minRad)+","+ctr);
			//Resetting the counters and indexes
			curRows+=1;
			minRad= -1.0;
			ctr=0;
			k=0;

		}


	}
}
