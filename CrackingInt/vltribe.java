/*
 * Program Description:
 * Date Created: Wed 08 Nov 2017 09:47:59 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class vltribe
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		in.nextLine();
		while(test-->0) {
			char[] arr = in.nextLine().toCharArray();
			/*for(char val:arr)
				System.out.print(val);
			System.out.println();*/
			int buf = 0;
			char bufc = '.';
			int i=0;
			while(i<arr.length && arr[i] != 'A' && arr[i] !='B') {
				i++;
			}
			int tota,totb;
			tota=totb=0;
			for(;i<arr.length; i++) {
				if(arr[i] == 'A'){
					tota++;
				}
				else if(arr[i] == 'B'){
					totb++;
				}
				//System.out.println(arr[i]+" "+tota+" "+totb+" index "+buf);
				if(arr[i] == 'A' || arr[i] == 'B'){
					//System.out.println(arr[i]+" "+bufc+" "+buf+" "+i);
					if(bufc == arr[i]) {
						if(bufc == 'A'){
							tota += i-buf-1;
						} else {
							totb += i-buf-1;
						}
					} else {
						bufc = arr[i];
					}
					buf = i;
				}
			}
			System.out.println(tota+" "+totb);
		}
	}
}

