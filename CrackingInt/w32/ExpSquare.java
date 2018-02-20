import java.util.*;
class ExpSquare
{
	public long getPower(long x ,long y, int pow){ //cur val,base, power
		if(pow == 0){
			return x;
		}
		if(pow == 1){
			return x*y;
		}
		long val = 0;
		if(pow%2 == 0){
			val = getPower(x,y*y,pow/2);
		} else {
			val = getPower(x*y,y*y,(pow-1)/2);
		}
		return val;
	}
		
	public long getModPower(long cur,long base,long pow,long mod){
		if(pow == 0)
			return cur%mod;
		if(pow == 1)
			return ((base%mod)*(cur%mod))%mod;
		long val = 0;
		if(pow%2 ==0){
			val = getModPower(cur%mod,(base%mod*base%mod)%mod,pow/2,mod);
		} else {
			val = getModPower((cur%mod*base%mod)%mod,(base%mod*base%mod)%mod,(pow-1)/2,mod);
		}
		return val;
	}
	
}
