/*
 * Program Description:
 * Date Created: Sun 03 Dec 2017 09:13:22 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.util.*;
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
		byte[] buf = new byte[101]; // line length
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
class decq1
{
	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		int test = in.nextInt();
		String[] arr = new String[101];
		while(test-->0) {
			int row = in.nextInt();
			int col = in.nextInt();
			int cost = 0;
			for(int i=0; i<row; i++){
				arr[i] = in.readLine();
			}
			System.out.println(getCost(arr,row,col));
		}
		
	}
	public static long getCost(String[] arr, int r, int c) {
		//display(arr,r);
		long c1,c2;
		char f1,f2,f11,f22;
		f1=f11='R';
		f2=f22='G';
		c1=c2=0;
		for(int i=0; i<r; i++) {
			f1 = f11;
			f2 = f22;
			for(int j=0; j<c; j++) {
				char ch = arr[i].charAt(j);
				if(ch != f1) {
					c1 += cost(f1);
				}
				f1 = negate(f1);
				if(ch != f2) {
					c2 += cost(f2);
				}
				f2 = negate(f2);
			}
			f11 = negate(f11);
			f22 = negate(f22);
		}
		return Math.min(c1,c2);
	}
	public static void display(String[] arr, int r) {
		for(int i=0; i<r; i++)
			System.out.println(arr[i]);
	}
	public static char negate(char ch){
		if(ch == 'R')
			return 'G';
		return 'R';
	}
	public static int cost(char ch) {
		if(ch == 'R')
			return 3;
		return 5;
	}
}
