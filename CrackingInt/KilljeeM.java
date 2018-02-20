/*
 * Program Description:
 * Date Created: Tue 21 Nov 2017 03:22:22 PM IST
 * Author : Stif Spear Subba
 */
import java.io.*;
import java.math.*;
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


public class KilljeeM
{
	static int mod = 1000000007;
	static BigInteger[] fib = new BigInteger[2000002];
	static BigInteger[] fact = new BigInteger[2000002];
	static BigInteger[] sum = new BigInteger[2000002];
	public static void main(String[] args) throws IOException
	{
		Reader ob = new Reader();
		init();
		for(int i=0; i<10; i++)
			System.out.println(fib[i].toString());
		int t = ob.nextInt();
		while(t-->0) {
			int n = ob.nextInt();
			int m = ob.nextInt();
			int k = ob.nextInt();
			System.out.println("end");
			long p = 0;

		}
	}
	public static void init(){
		fib[0] = new BigInteger("1");
		fib[1] = new BigInteger("1");
		fib[2] = new BigInteger("2");
		fact[0] = new BigInteger("1");
		fact[1] = new BigInteger("1");
		fact[2] = new BigInteger("2");
		sum[0] = new BigInteger("1");
		sum[1] = new BigInteger("2");
		sum[2] = new BigInteger("6");
		for(int i=3; i<=2000000; i++) {
			fib[i] = fib[i-1].add(fib[i-2]);
			fact[i] = fact[i-1].multiply(new BigInteger(i+""));
			sum[i] = sum[i-1].add(fib[i].multiply(fact[i]));
		}
		/*for(int i=0; i<100; i++) {
			System.out.println(fib[i]+" "+fact[i]+" "+sum[i]);
		}*/
		

	}
}

