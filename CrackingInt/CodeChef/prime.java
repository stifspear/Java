import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
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
public class prime{
	static boolean[] a = null;
	static {
		if (a == null) {
			a = new boolean[1000001];
			for (int i = 2; i < a.length; i++) {
				a[i] = true;
			}
			for (int i = 2; i < a.length; i++) {
				int k = i;
				while (true) {
					k += i;
					if (k < a.length) {
						a[k] = false;
					} else {
						break;
					}
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Reader br = new Reader();
		int T = br.nextInt();
		for (int i = 0; i < T; i++) {
			int L = br.nextInt();
			int R = br.nextInt();
			int start = 0;
			int end = 0;
			if (L > R) {
				start = R;
				end = L;
			} else {
				start = L;
				end = R;
			}
			long sum = 0;
			for (int j = start; j <= end; j++) {
				if (a[j]) {
					sum++;
				}
			}
			System.out.println(sum);
		}
	}
}
