public class SQsortApp
{
	public static void main(String[] args)
	{
		String str="aabadc";
		StringQSort ob=new StringQSort(str);
		ob.doPartition();
		ob.display();
		System.out.println(ob.removeDups());
	}
}
