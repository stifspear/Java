/*
 * Porgram to check the total number of calculation to be done to
 * make two string anagrams of each other
 */
import java.util.*;
class MakeAnagram
{
	String text;
	String text2;
	int l1,l2;
	int[] chars=new int[26];
	int[] chars2=new int[26];
	public MakeAnagram(String t,String t2)
	{
		text=t;
		text2=t2;
		l1=t.length();
		l2=t2.length();
		for(int i=0;i<26;i++){
			chars[i]=0;
			chars2[i]=0;
		}
	}
	public int findDist()
	{
		for(int i=0;i<l1;i++)
		{
			chars[((int)text.charAt(i))-97]+=1;
		}
		for(int i=0;i<l2;i++)
		{
			chars2[((int)text2.charAt(i))-97]+=1;
		}
		int toDelete=0;
		for(int i=0;i<26;i++)
		{
			if(chars[i]>=1&&chars2[i]>=1)
			{
				toDelete+=(chars[i]>chars2[i])?2*chars2[i]:2*chars[i];
			}
		}
		System.out.println(l1+" "+l2+" "+toDelete);
		return l1+l2-toDelete;
	}
	public void display()
	{
		for(int i=0;i<26;i++)
			System.out.print(chars[i]+" ");
		System.out.println();
		for(int i=0;i<26;i++)
			System.out.print(chars2[i]+" ");
		System.out.println();
	}
}
class MakingAnagrams
{
	public static void main(String args[])
	{
		MakeAnagram ob=new MakeAnagram("algorithm","arithmetic");
		System.out.println(ob.findDist());
		ob.display();
	}

}



