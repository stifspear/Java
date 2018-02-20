/*
 * Program Description:
 * Date Created: Fri 10 Nov 2017 09:56:53 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class Permute
{
	public static void main(String[] args){
		doit(3);
	}
	public static void doit(int num) {
		num = (int)Math.pow(2,num);
		for(int i=0; i<num; i++) {
			String cur = String.format("%0%d",num,Integer.parseInt(Integer.toBinaryString(i)));
			System.out.println(cur);
		}
	}
}

