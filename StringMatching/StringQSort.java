/*
 * Program to implement quick sort for strings
 */

public class StringQSort
{
	String strToSort;
	char strarr[];
	int length;
	public StringQSort(String str)
	{
		strToSort=str;
		length=strToSort.length();
		strarr=new char[length];
		for(int i=0;i<length;i++)
		{
			strarr[i]=strToSort.charAt(i);
		}
	}
	public void doPartition()
	{
		qSort(strarr,0,length-1);
	}

	public void qSort(char arr[],int starti,int endi)
	{
		if (starti<endi)
		{
			int pivot=HPartition(arr,starti,endi);
			qSort(arr,starti,pivot-1);
			qSort(arr,pivot+1,endi);
		}
	}
	public int HPartition(char arr[],int starti,int endi)
	{
		int i,j;
		char pivot=arr[endi];
		i=starti-1;
		for(j=starti;j<endi;j++)
		{
			if((int)arr[j]<=(int)pivot)
			{
				i=i+1;
				swap(arr,i,j);
			}
			
		}
		swap(arr,i+1,endi);
		return i+1;

		
	}
	public void swap(char[] arr,int x,int y)
	{
	
		char temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	public String removeDups()
	{
		char noDups[]=new char[length];
		int flag=0;
		noDups[flag]=strarr[flag];
		for(int i=1;i<length;i++)
		{
			if(noDups[flag]!=strarr[i])
			{
				noDups[++flag]=strarr[i];
			}
		
		}
		String noDup="";
		for(int i=0;i<=flag;i++)
			noDup+=noDups[i];
		return noDup;
	}

	public void display()
	{
		String sortedstring="";
		for(int i=0;i<length;i++)
		{
			sortedstring+=strarr[i];
		}
		System.out.println("sortedstring:"+sortedstring);
	}
		
	
}
