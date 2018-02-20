/*
   Program to read a file and reverse it
*/
import java.io.*;
import java.util.*;
class ReverseWordsFile
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			in = new BufferedReader(new FileReader("input.in"));
			out = new BufferedWriter(new FileWriter("Output.txt"));
			Scanner ob = new Scanner(in.readLine());
			int loopCount=ob.nextInt();
			for(int i=1;i<=loopCount;i++){
			//	out.write("Output\n");
				out.write("Case#"+i+":");
				ob = new Scanner(in.readLine());
				String temp = ob.nextLine();
				String str[]=temp.split(" ");
				for(int j=str.length-1;j>=0;j--){
					out.write(str[j]+" ");
				}
				out.write("\n");
			}
			in.close();
			out.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}	
