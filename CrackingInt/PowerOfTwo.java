/*
 * Program Description:
 * Date Created: Tue 10 Oct 2017 09:09:24 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class PowerOfTwo
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if((n&n-1) == 0)
			System.out.println("True");
		else 
			System.out.println("False");
	}
}

