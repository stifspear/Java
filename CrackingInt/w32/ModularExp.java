import java.io.*;
import java.util.*;
class ModularExp
{
	public long getModularExp(long a,long b,long mod){
		long result = 1;
		a = a%mod;
		while(b>0){
			if(b%2 == 1){
				result = (result*a)%mod;
			}
			b = b/2;
			a = (a*a)%mod;
		}
		return result;
	}
}
