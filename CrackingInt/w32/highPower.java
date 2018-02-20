import java.util.*;
import java.math.*;
class highPower
{
	public static void main(String args[]) {
		BigInteger num = new BigInteger("9");
		int exp = 1500000;
		BigInteger po = num.pow(exp);
		System.out.println(po);
	}
}
