/*
 * Program Description:
 * Date Created: Sat 12 Aug 2017 12:11:12 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class Test
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		reverseKList ob = new reverseKList();
		int n = in.nextInt();
		for(int i=0; i<n; i++)
			ob.addNode(in.nextInt());
		ob.display(ob.head);
		Node newLink = ob.reverseList(in.nextInt());
		ob.display(newLink);
		
	}
}

