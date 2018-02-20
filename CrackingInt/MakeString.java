/*
 * Program Description:
 * Date Created: Mon 23 Oct 2017 11:06:04 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class MakeString
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int len = str.length();
		String out = "";
		for(int i=0; i<len; i++) {
			while(i<len && str.charAt(i) == ' ') {
				i++;out += " ";
			}
			if(i == len )
				break;
			out += Character.toUpperCase(str.charAt(i++))+"";
			if(i == len)
				break;
			while(i<len && str.charAt(i) != ' ') {
				out += str.charAt(i)+"";
				i++;
			}
			if(i == len)
				break;
			i--;
		}	
		System.out.println(out);
	}
}

