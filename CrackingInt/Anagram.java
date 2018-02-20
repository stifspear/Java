/*
 * Program Description:
 * Date Created: Sun 01 Oct 2017 11:46:57 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
class Anagram
{
	String str;
	public Anagram(){
		str = "";
	}
	public Anagram(String str) {
		this.str = str;
	}
	public void makeAnagram(String str,int index) {
		if(str.length() == index){
			System.out.println(str);
			return;
		}
		for(int i=index; i<str.length(); i++){
			str = swap(str,i,index);
			makeAnagram(str,index+1);
			str = swap(str,i,index);
		}
	}
	public String swap(String str, int i, int j) {
		StringBuilder st = new StringBuilder(str);
		char ch = st.charAt(i);
		st.setCharAt(i,st.charAt(j));
		st.setCharAt(j,ch);
		return st.toString();
	}

	public void test() {
		makeAnagram("abc",0);
	}
}

