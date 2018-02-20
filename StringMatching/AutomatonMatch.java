/*
 * Program to implement string matching using finite automaton
 */

class AutomatonMatch
{
	int sizer,sizec;
	String pattern;
	String text;	
	public AutomatonMatch(String pat,String text)
	{
		pattern=pat;
		this.text=text;
		sizer=pattern.length();
	}
	public int[][] makeTrnsMatrix(String str)
	{
	String noDpat=str;
	String visitedState="";
	String nextState="";
	int transitionmat[][]=new int[pattern.length()+1][noDpat.length()];
	for(int i=0;i<=pattern.length();i++)
	{
		if(i==0)
		{
			for(int ii=0;ii<noDpat.length();ii++)
			{
				if(pattern.charAt(i)==noDpat.charAt(ii))
				{
					transitionmat[i][ii]=1;
				}
				else
				{
					transitionmat[i][ii]=0;
				}
			}	
		}
		else 	
		{
			if(i!=pattern.length())
			{
				visitedState=pattern.substring(0,i);	
				nextState=visitedState+pattern.charAt(i);
			}
			else
			{
				visitedState=pattern.substring(0);
				nextState=visitedState+pattern.charAt(0);
			}	
			for(int j=0;j<noDpat.length();j++)
			{
				String nextStatel=nextState;
				String visitedStatel=visitedState;
				String currentStatel="";
				currentStatel=visitedStatel+noDpat.charAt(j);
				int counter=i+1;
				if(currentStatel.equals(nextStatel))
				{
					if(counter%pattern.length()==0)
						transitionmat[i][j]=counter;
					else
						transitionmat[i][j]=counter%pattern.length();		
			}
				else
				{
					while(!currentStatel.equals(nextStatel)&&counter!=0)	
					{
						counter--;
						currentStatel=currentStatel.substring(1);
						nextStatel=nextStatel.substring(0,counter);	
					}
				transitionmat[i][j]=counter;
				}	
			}
		}

	}
	for(int i=0;i<=sizer;i++)
	{
		for(int j=0;j<noDpat.length();j++)
		{
			System.out.print(transitionmat[i][j]+" ");
		}
		System.out.println();
	}
	return transitionmat;
	}
	public void findMatch(String noDpat,int[][] transitionm)
	{
		int tlength=text.length();
		int currentstate=0;
		for(int i=0;i<tlength;i++)
		{
			if(noDpat.indexOf(text.charAt(i))!=-1)
				currentstate=transitionm[currentstate][noDpat.indexOf(text.charAt(i))];
			else
				currentstate=0;
			if(currentstate==pattern.length())
				System.out.println("Pattern found after "+(i-pattern.length()+1)+" shifts");
		}
	}	
}
