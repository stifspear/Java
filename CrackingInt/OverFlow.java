/*
 * Program Description:
 * Date Created: Thu 12 Oct 2017 10:13:33 AM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class OverFlow
{
	public static void main(String[] args){
		int a = Integer.MAX_VALUE;
		Scanner in = new Scanner(System.in);
		/*while(true){
			int b = a/in.nextInt();
			System.out.println(b);
	
		}*/

		//System.out.println(val);
		int val = Integer.MAX_VALUE-100000;

		System.out.println(val/99990);
	}
}

