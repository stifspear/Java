/*
 * Program Description:
 * Date Created: Tue 12 Dec 2017 03:17:57 PM IST
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
class Point {
	int x,y,h;
	public Point(int x,int y, int h) {
		this.x = x;
		this.y = y;
		this.h = h;
	}
	public String toString(){
		return x+" "+y+" "+h;
	}
}
class skiing
{
	static int n,m;
	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		int test = in.nextInt();
		while(--test>=0) {
			n = in.nextInt();
			m = in.nextInt();
			boolean[][] vis = new boolean[n+1][m+1];
			int[][] arr = new int[n+1][m+1];
			ArrayList<Point> point = new ArrayList<>();
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					arr[i][j] = in.nextInt();
					point.add(new Point(i,j,arr[i][j]));
				}
			}
			Collections.sort(point,(a,b)->(b.h-a.h));
			int count = 0;
			for(Point p:point) {
				//System.out.println(p);
				if(vis[p.x][p.y])
					continue;
				else {
					count++;
					traverse(arr,vis,p.x,p.y);
				}
			}
			System.out.println(count);
		}
	}
	public static void traverse(int[][] arr, boolean[][] v, int x, int y) {
		v[x][y] = true;
		int up = x-1;
		int d = x+1;
		int l = y-1;
		int r = y+1;
		if(isValid(up,y) && arr[up][y] <= arr[x][y]){
			if(!v[up][y]){
				traverse(arr,v,up,y);
			}
		}
		if(isValid(d,y) && arr[d][y] <= arr[x][y]){
			if(!v[d][y]) {
				traverse(arr,v,d,y);
			}
		}
		if(isValid(x,l) && arr[x][l] <= arr[x][y]) {
			if(!v[x][l]) {
				traverse(arr,v,x,l);
			}
		}
		if(isValid(x,r) && arr[x][r] <= arr[x][y]) {
			if(!v[x][r]) {
				traverse(arr,v,x,r);
			}
		}

	}
	public static boolean isValid(int x, int y) {
		if(1<=x&&x<=n&&1<=y&&y<=m)
			return true;
		return false;
	}
}

