/*
 * Program Description:
 * Date Created: Sat 09 Sep 2017 08:47:09 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class Pyramid
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//int q = in.nextInt();
		//for(int a0 = 0; a0 < q; a0++){
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			int[][] h = new int[n][m];
			for(int h_i = 0; h_i < n; h_i++){
				for(int h_j = 0; h_j < m; h_j++){
					h[h_i][h_j] = in.nextInt();
				}
			}
		//}
		int s = checkPossible(h,0,2,2);
		if(s!=0) 
			System.out.println("True");
		else 
			System.out.println("False");
		in.close();
	}
	public static int checkPossible(int[][] arr,int x, int y, int size){
		int curHei = 1;
		int maxHei = size;
		int start = x;
		int end = y;
		int temp = 0;
		int k = 0;
		while(true){

			for(int top=start; top<=end; top++){
				if(arr[x][top] > curHei) 
					return 0;
				else 
					k+=curHei-arr[x][top];
			}
			for(int top = start; top<=end; top++){
				if(arr[top][y] > curHei) 
					return 0;
				else 
					k+=curHei-arr[top][y];
			}
			temp = start;
			start =  end;
			end = temp;
			for(int top = start; top>=end; top--){
				if(arr[y][top] > curHei) 
					return 0;
				else 
					k+=curHei-arr[y][top];
			}
			for(int top = start; top>=end; top--){
				if(arr[top][x] > curHei) 
					return 0;
				else 
					k+=curHei-arr[top][x];
			}
			curHei++;	
			size--;
			start = start+1;
			end = end-1;
			x = start;
			y = end;
			if(curHei>size)
				break;
		}
		return k;
	}
}
