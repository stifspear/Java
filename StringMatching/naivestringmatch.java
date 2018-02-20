/*
 * String matching using naive method
 */

import java.util.*;

class nstringmat
{
	String t;
	String p;
	nstringmat(String text,String pat)
	{
		t=text;
		p=pat;
	}
	public void match()
	{
		int m=t.length();
		int n=p.length();
		boolean res=true;
		int flag=0;
		for(int i=0;i<=m-n;i++)
		{
			for(int j=0;j<n;j++)
			{

				
					if(t.charAt(i+j)!=p.charAt(j))
						res=false;
			
					flag=i;
				
			}
			if(res)
					System.out.println("String found and index "+i);
			res=true;
		}
	
	}
}
public class naivestringmatch
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		/*
		System.out.println("Enter text");
		String t=in.nextLine();
		System.out.println("Enter pattern");
		String p=in.nextLine();*/
		String t="stif spear subba";
		String p="subba";
		nstringmat ob=new nstringmat(t,p);
		ob.match();
	}
}
