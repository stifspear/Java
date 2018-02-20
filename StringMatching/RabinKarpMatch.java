/*
 * Program to implement RabinKarpMatch Algorithm
 */

class RabinKarpMatch
{
	String text;
	String pattern;
	int prime;
	int rdix;
	public RabinKarpMatch(String t,String p)
	{
		text=t;
		pattern=p;
		prime=3;

	}
	public void doRabinKarp()
	{
		int n,m;
		n=text.length();
		m=pattern.length();
		long phash=0;
		long thash=0;
		for(int i=0;i<m;i++)
		{
			phash=(phash+((int)pattern.charAt(i)*(long)Math.pow(prime,i)));
			thash=(thash+(long)(Math.pow(prime,i))*(int)text.charAt(i));
		}
		int counter=0;
		for(int s=0;s<=n-m;s++)
		{
			if(phash==thash)
			{
				if(check(s))
				{
					System.out.println("String found at index "+s);
					counter=1;
					break;
				}
			}
			if(s<n-m)
			{
				thash=((thash-(int)text.charAt(s))/prime+((int)text.charAt(s+m)*(long)Math.pow(prime,(m-1))));
			}

		}
		if(counter==0)
			System.out.println("No strings found");
	}
	public boolean check(int x)
	{
		for(int i=0;i<pattern.length();i++)
		{
			if(text.charAt(i+x)!=pattern.charAt(i))
				return false;
		}
		return true;
	}
}


