/*
 * Program Description:
 * Date Created: Mon 13 Nov 2017 12:20:16 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
class testgenerator
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		try
		{
			String filename= "./inp";
			FileWriter fw = new FileWriter(filename,true); //the true will append the new data
			int t = in.nextInt();
			int n = in.nextInt();
			int k = in.nextInt();
			fw.write(t+"\n");
			fw.write(n+" ");//appends the string to the file
			fw.write(k+"\n");
			Random r = new Random();
			//char[] arr = {'1','0'};
			//int ro = 39;
			//int c = 39;
			//long[][] arr = new long[ro][c];
			/*for(int i=0; i<ro; i++) {
				for(int j=0; j<c; j++) {
					int val = ThreadLocalRandom.current().nextInt(1,39+1);
					fw.write(val+" ");
				}
				fw.write("\n");
			}*/
			for(int i=0; i<n; i++) {
				int c = ThreadLocalRandom.current().nextInt(-10,11);
				fw.write(c+" ");
			}
			fw.write("\n");
			fw.close();
		}
		catch(IOException ioe)
		{
			System.err.println("IOException: " + ioe.getMessage());
		}
	}
}

