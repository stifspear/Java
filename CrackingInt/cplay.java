/*
 * Program Description:
 * Date Created: Tue 05 Dec 2017 09:58:53 AM IST
 * Author : Stif Spear Subba
 */
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Reader
{
	final private int BUFFER_SIZE = 1 << 16;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public Reader()
	{
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public Reader(String file_name) throws IOException
	{
		din = new DataInputStream(new FileInputStream(file_name));
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public String readLine() throws IOException
	{
		byte[] buf = new byte[64]; // line length
		int cnt = 0, c;
		while ((c = read()) != -1)
		{
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}

	public int nextInt() throws IOException
	{
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do
		{
			ret = ret * 10 + c - '0';
		}  while ((c = read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}

	public long nextLong() throws IOException
	{
		long ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		}
		while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public double nextDouble() throws IOException
	{
		double ret = 0, div = 1;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();

		do {
			ret = ret * 10 + c - '0';
		}
		while ((c = read()) >= '0' && c <= '9');

		if (c == '.')
		{
			while ((c = read()) >= '0' && c <= '9')
			{
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	private void fillBuffer() throws IOException
	{
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private byte read() throws IOException
	{
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException
	{
		if (din == null)
			return;
		din.close();
	}
}
class cplay {
	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		int[] p = new int[20];
		String t;
		ArrayList<String> an = new ArrayList<String>();
		while(true) {
			t = in.readLine();
			if(t.length() == 0)
				break;
			for(int i=0; i<20; i++) {
				p[i] = Character.getNumericValue(t.charAt(i));
			}
			/*for(int i=0; i<20; i++) {
			  System.out.println(p[i]);
			  }*/
			System.out.println(getResult(p));

		}
	}
	public static String getResult(int[] a) {
		String A = "TEAM-A";
		String B = "TEAM-B";	
		int f,s;
		f=s=0;
		int[] o = new int[10];
		int[] b = new int[10];
		o[0] = a[0];
		b[0] = a[1];
		for(int i=1; i<10; i++) {
			f=2*i;
			s=f+1;
			o[i] = o[i-1]+a[f];
			b[i] = b[i-1]+a[s];
		}
		int tot = 2;
		String ans = "TIE";
		int count = 1; 
		for(int i=1; i<10; i++) {
			tot += 2;
			if(++count < 6) {
				if(o[i]>b[i-1] && o[i]-b[i-1]>(5-(count-1))) {
					ans = A;
					tot = tot-1;
					return ans+" "+tot;

				} 
				if(o[i]<b[i-1] && b[i-1]-o[i]>(5-count)){
					ans = B;
					tot = tot-1;
					return ans+" "+tot;
				}
				if(b[i]>o[i] && b[i]-o[i]>(5-count)){
					ans = B;
					return ans+" "+tot;
				}
				if(o[i]>b[i] && o[i]-b[i]>(5-count)){
					ans = A;
					return ans+" "+tot;
				}
			} else {
				if(o[i]>b[i]){
					ans = A;
					return ans+" "+tot;
				}else if(b[i]>o[i]){
					ans = B;
					return ans+" "+tot;
				}
			}
		}
		return "TIE";
	}
}
