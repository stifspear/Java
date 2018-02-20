import java.util.*;
class ReverseWords
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n;
		String str[];
		n=in.nextInt();
		str=new String[n];
		in.nextLine();
		for(int i=0;i<n;i++){
			str[i]=in.nextLine();
		}
		for(int i=0;i<n;i++) {	
			String temp=str[i];
			int lastWhite=temp.length();
			System.out.print("Case #"+(i+1)+": ");
			for(int j=temp.length()-1;j>=0;j--) {
				if(temp.charAt(j)==' '){
				System.out.print(temp.substring(j+1,lastWhite)+" ");
							lastWhite=j;
				}
				
			}
			System.out.print(temp.substring(0,lastWhite));
		System.out.println();}
	}
}
