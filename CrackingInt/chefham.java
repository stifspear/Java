/*
 * Program Description:
 * Date Created: Thu 07 Dec 2017 07:45:44 PM IST
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
class chefham
{
	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		int test = in.nextInt();
		boolean repeat = true;
		while(test-->0) {
			int n = in.nextInt();
			int[] arr = new int[n];
			HashSet<Integer> set = new HashSet<Integer>();
			repeat = false;
			for(int i=0; i<n; i++) {
				arr[i] = in.nextInt();
				if(set.contains(arr[i]))
						repeat = true;
				set.add(arr[i]);
			}
			if(repeat) {
				//System.out.println("Repeat");
				process(arr,n);
			} else {
				if(n==1)
					System.out.println(0);
				else
					System.out.println(n);
				for(int i=1; i<n; i++)
					System.out.print(arr[i]+" ");
				System.out.println(arr[0]);
			}
		}
	}
	public static void process(int[] arr, int n) {
		ArrayList<Integer> f = new ArrayList<>();
		ArrayList<Integer> s = new ArrayList<>();
		boolean[] visited = new boolean[n];
		HashSet<Integer> set = new HashSet<Integer>();
		int count = 0;
		for(int i=0; i<n; i++) {
			if(set.contains(arr[i]))
				continue;
			set.add(arr[i]);
			f.add(i);
			visited[i] = true;
		}
		//System.out.println(f);
		if(f.size() > 1)
			count += f.size();
		for(int i=0; i<n; i++) {
			if(visited[i])
				continue;
			s.add(i);
		}
		//System.out.println(s);
		if(s.size() > 1)
			count += s.size();
		int[] ans = new int[n];
		int temp = arr[f.get(0)];
		int i=0;
		for(; i<f.size()-1; i++) {
			ans[f.get(i)] = arr[f.get(i+1)];
		}
		ans[f.get(i)] = temp;
		if(s.size() > 1) {
			temp = arr[s.get(0)];
			i=0;
			for(;i<s.size()-1; i++) {
				ans[s.get(i)] = arr[s.get(i+1)];
			}
			ans[s.get(i)] = temp;
		} else {
			int ind = s.get(0);
			ans[ind] = arr[ind];
			for(i=0; i<n; i++) {
				if(ans[i] != arr[ind] && arr[i] != arr[ind]) {
					ans[ind] = ans[i];
					ans[i] = arr[ind];
					count=count+1;
					break;
				}
			}
		}
		System.out.println(count);
		for(i=0; i<n; i++)
			System.out.print(ans[i]+" ");
		System.out.println();
	}
}
