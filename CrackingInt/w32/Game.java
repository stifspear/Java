/*
 * Program Description:
 * Date Created: Fri 08 Sep 2017 09:33:05 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class Game
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int X = in.nextInt();
		int Y = in.nextInt();
		int Z = in.nextInt();
		int y = in.nextInt();
		int z = in.nextInt();
		int toBeatMin = 0;
		int toBeatMax = 0;
		toBeatMax = (Y+y>Z+z)?Y+y:Z+z;
		toBeatMin = (Y-y>Z-z)?Y-y:Z-z;
		int diffM = toBeatMax - X;
		int diffm = X - toBeatMin;
		
	}
}

