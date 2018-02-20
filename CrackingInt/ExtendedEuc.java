import java.util.*;
class ExtendedEuc
{
	public String findBezout(long a,long b){
		long temp = a; 
		long rem = b;
		long oldrem = a;
		long s = 0;
		long olds = 1;
		long t = 1;
		long oldt = 0;
		long m0 = b;
		while(rem > 0){
			System.out.println(oldrem+" "+rem+" "+s+" "+t);
			long quo = oldrem / rem;
			temp = rem;
			rem = oldrem % rem;
			oldrem = temp;
			temp = s;
			s = t - (s*quo);
			t = temp;
			System.out.println(oldrem+" "+rem+" "+s+" "+t);
		}
		if(t<0)
			t+=m0;
		return t+" "+s+" "+rem;
	}
}
