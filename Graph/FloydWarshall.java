import java.util.*;
class FloydWarshall
{
	public static final int inf = 100000;
	int[][] path;
	int[][] weight;
	int size;
	public FloydWarshall(int size){
		path = new int[size][size];
		this.size = size;
		weight = new int[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				weight[i][j] = inf;
				path[i][j] = -1;
				if(i==j){
					weight[i][j] = 0;
				}
			}
		}
	}
	public void addEdge(int x,int y,int wt){
		weight[x][y] = wt;
		weight[y][x] = wt;
		path[x][y] = x;
		path[y][x] = y;
	}
	public void addDEdge(int x,int y,int wt){
		weight[x][y] = wt;
		path[x][y] = x;
	}
	public int[][] FW(){
		int[][] sol = new int[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				sol[i][j] = weight[i][j];
			}
		}
		for(int k=0;k<size;k++){
			for(int i=0;i<size;i++){
				for(int j=0;j<size;j++){
					if(sol[i][j]>sol[i][k]+sol[k][j]){
						sol[i][j] = sol[i][k]+sol[k][j];
						path[i][j] = k;
					}
				}
			}
		}
		return sol;
	}
	public void display(int[][] arr){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public void displayPath(int x,int y){
		if(x==y){
			System.out.print(y+" ");
			return;
		} 
		displayPath(x,path[x][y]);
		System.out.print(y+" ");
	}
}
