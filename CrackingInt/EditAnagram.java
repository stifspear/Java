/*
 * Program Description:
 * Date Created: Fri 15 Sep 2017 12:23:48 AM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EditAnagram {

	static int anagram(String s){
		int len = s.length();
		if(len%2 != 0)
			return -1;
		HashMap<Character,Integer> map = new HashMap<>();
		HashMap<Character,Integer> map2 = new HashMap<>();
		for(int i=0; i<len/2; i++){
			char ch = s.charAt(i);
			if(map.containsKey(ch)){
				map.put(ch,map.get(ch)+1);
			} else {
				map.put(ch,1);
			}
		}

		for(int i=len/2; i<len; i++){
			char ch = s.charAt(i);
			if(map2.containsKey(ch)){
				map2.put(ch,map2.get(ch)+1);
			} else {
				map2.put(ch,1);
			}
		}
		int count = 0;
		for(Character key:map.keySet()){
			if(map2.containsKey(key)){
				if(map.get(key)<=map2.get(key)){
					count+=map2.get(key)-map.get(key);
				}
			} else {
				count+=map.get(key);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			String s = in.next();
			int result = anagram(s);
			System.out.println(result);
		}
	}
}


