class billioncount
{
	public static void main(String args[]) {
		long count=0;
		long start=System.currentTimeMillis();
		for(long i=0;i<1e9;i++)
		{
			for(int j=0;j<10000;j++)
				count++;
		}
		System.out.println((System.currentTimeMillis()-start)/1000);
		System.out.println(count);
	}
}
