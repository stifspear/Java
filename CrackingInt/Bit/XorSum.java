/*
 * Program Description:
 * Date Created: Thu 28 Sep 2017 12:51:24 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class XorSum
{
	int num;
	public XorSum(int num){
		this.num = num;
	}
	public void getCount() {
		int bitCount = 0;
		while(num > 0){
			if((num&1) == 0)
				bitCount++;
			//System.out.println(Integer.toBinaryString(num)+" "+bitCount);
			num=num>>1;
		}
		System.out.println((int)Math.pow(2,bitCount));
	}
}

