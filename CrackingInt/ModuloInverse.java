import java.util.*;
class ModuloInverse
{
	public long modEuc(long a,long mod){
		ExtendedEuc ob = new ExtendedEuc();
		String out = ob.findBezout(a,mod);
		return Long.parseLong(out.split(" ")[0]);
	}
	public long fermatsMod(long a,long mod){
		long out = 0;
		ExpSquare ob = new ExpSquare();	
		return ob.getModPower(1,a,mod-2,mod);
	}
}
