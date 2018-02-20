/*
 * Program Description:
 * Date Created: Mon 04 Sep 2017 07:53:53 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BugGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();
		for(int a0 = 0; a0 < Q; a0++){
			int n = in.nextInt();
			String b = in.next();
			if(checkIsHapp(b)){
				System.out.println("YES");

			} else {
				HashMap<Character,Integer> map = new HashMap<Character,Integer>();
				for(int i=0; i<n; i++){
					char ch = b.charAt(i);
					if(map.containsKey(ch)){
						map.put(ch,map.get(ch)+1);

					} else {
						map.put(ch,1);

					}

				}
				boolean result = false;
				if(map.containsKey('_')){
					result = true;
					for(Character key : map.keySet()){
						// System.out.println(key+" "+map.get(key));
						if(key=='_' || map.get(key)>=2){}
						else result = false;

					}

				}
				if(result)
					System.out.println("YES");
				else 
					System.out.println("NO");

			}

		}

	}
	public static boolean checkIsHapp(String str){
		if(str.length()==1)
			return false;
		char curChar = str.charAt(0);
		int i=1;
		int count = 1;
		while(i<str.length()){

			char tempch = str.charAt(i);
			if(tempch==curChar){
				count++;

			} else {
				if(count>=2){
					count=1;
					curChar = tempch;

				} else {
					return false;

				}

			}
			i=i+1;

		}
		return true;

	}

}


