/*
 * Program Description:
 * Date Created: Thu 28 Sep 2017 09:21:09 AM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class MakeZero
{
	int M;
	int N;
	int[][] arr;
	public MakeZero(int M, int N, int[][] arr){
		this.M = M;
		this.N = N;
		this.arr = arr;
	}
	public void transform(){
		boolean isColumnZero = false;
		boolean isRowZero = false;
		for(int i=0; i<N; i++){
			if(arr[0][i] == 0)
				isColumnZero = true;
		}
		for(int i=0; i<M; i++){
			if(arr[i][0] == 0)
				isRowZero = true;
		}
		for(int i=1; i<M; i++){
			for(int j=1; j<N; j++){
				if(arr[i][j] == 0){
					arr[i][0] = 0;
					arr[0][j] = 0;
				}
			}
		}	
		for(int i=1; i<N; i++){
			if(arr[0][i] == 0) {
				for(int j=1; j<M; j++)
					arr[j][i] = 0;
			}
		}
		for(int i=1; i<M; i++){
			if(arr[i][0] == 0) {
				for(int j=1; j<N; j++)
					arr[i][j] = 0;
			}
		}
		if(isColumnZero){
			for(int i=0; i<N; i++)
				arr[0][i] = 0;
		}
		if(isRowZero){
			for(int i=0; i<M; i++)
				arr[i][0] = 0;
		}
		PrintClass.printArray(arr);
	}
}

