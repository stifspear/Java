/*
 * Program Description:
 * Date Created: Sat 06 Jan 2018 12:18:40 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class rectangl
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		while(--test>=0) {
			Map<Integer,Integer> set = new HashMap<>();
			for(int i=0; i<4; i++){
				int count = 1;
				int x = in.nextInt();
				if(set.containsKey(x))
					count = count+set.get(x);
				set.put(x,count);
			}
			if(set.size() > 2)
				System.out.println("NO");
			else if(set.size() == 1)
				System.out.println("YES");
			else if(set.size() == 2) {
				boolean flag = false;
				for(Integer ke:set.keySet()) {
					if(set.get(ke) == 1 )
						flag=true;
				}
				if(flag)
					System.out.println("NO");
				else 
					System.out.println("YES");
			}
		}
	}
}

