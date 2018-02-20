import java.util.*;
public class Maze
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int[][] maze= new int[4][4];
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				maze[i][j]=in.nextInt();
			}
		}
		if(hasPath(maze,0,0)>=1)
			System.out.println("Has path");
		else
			System.out.println("No path");
	}
	public static int hasPath(int[][] maze,int x,int y){
		if(x<0&&x>3||y<0&&y>3)
			return 0;
		else if(maze[x][y]==0)
			return 0;
		else if(maze[x][y]==9)
			return 1;
		return hasPath(maze,x,y+1)+hasPath(maze,x+1,y)+hasPath(maze,x-1,y);
	}
}


