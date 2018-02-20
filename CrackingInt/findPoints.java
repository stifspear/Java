class findPoints
{
	public static void main(String args[])
	{
		double count=0.1;
		for(int i=1;i<=10;i++){

			double x,y;
			x=(2*count)+(1-count)*5;
			y=(3*count)+(1-count)*5;
			System.out.println(x+" "+y);
			count=count+.1;
		}
	}

}
