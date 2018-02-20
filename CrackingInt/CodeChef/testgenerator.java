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
			fw.write(t+"\n");
			Random r = new Random();
			for(int i=0; i<t; i++) {
				int n = ThreadLocalRandom.current().nextInt(1,51);
				int x = ThreadLocalRandom.current().nextInt(1,n+1);
				fw.write(x+" "+n);
				fw.write("\n");
			}
			/*//Array generation
			for(int i=0; i<t; i++){
				int n = ThreadLocalRandom.current().nextInt(1,10);
				int k = ThreadLocalRandom.current().nextInt(1,10);
				fw.write(n+" ");//appends the string to the file
				fw.write(k+"\n");
				for(int j=0; j<n; j++) {
					int c = ThreadLocalRandom.current().nextInt(-10,10);
					fw.write(c+" ");
				}
				fw.write("\n");
			}*/
			fw.close();
		}
		catch(IOException ioe)
		{
			System.err.println("IOException: " + ioe.getMessage());
		}
	}
}

