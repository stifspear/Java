/*
 * Program Description:
 * Date Created: Thu 28 Sep 2017 01:16:07 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class Test
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		XorSum ob = new XorSum(num);
		ob.getCount();
	}
}

