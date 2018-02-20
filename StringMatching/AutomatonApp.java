public class AutomatonApp
{
	public static void main(String args[])
	{
		AutomatonMatch ob=new AutomatonMatch("aabadc","adcdasaabadcsdfd");
		ob.findMatch("abcd",ob.makeTrnsMatrix("abcd"));
	}
}
