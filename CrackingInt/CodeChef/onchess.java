/*
 * Program Description:
 * Date Created: Tue 12 Dec 2017 02:07:08 PM IST
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
class Player {
	int r,minr,maxr,wt,id;
	String ra,co;
	public Player(int id, int r, int minr, int maxr, int wt, String ra, String co) {
		this.id = id;
		this.r = r;
		this.minr = minr;
		this.maxr = maxr;
		this.wt = wt;
		this.ra = ra;
		this.co = co;
	}
	public String toString() {
		return r+" "+minr+" "+maxr+" "+wt+" "+ra+" "+co;
	}
}
class onchess
{
	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		int test = in.nextInt();
		while(--test>=0) {
			int n = in.nextInt();
			List<Player> list = new LinkedList<>();
			int id = 1;
			while(--n>=0) {
				String inp = in.readLine();
				String[] arr = inp.split(" ");
				int r = Integer.parseInt(arr[0]);
				int minr = Integer.parseInt(arr[1]);
				int maxr = Integer.parseInt(arr[2]);
				int wt = Integer.parseInt(arr[3]);
				String ra = arr[4];
				String co = arr[5];
				Player tmp = new Player(id,r,minr,maxr,wt,ra,co);
				//System.out.println(tmp);
				int index = contains(list,tmp);
				if(index != -1) {
					System.out.println(index);
				} else {
					list.add(tmp);
					System.out.println("wait");
				}
				id++;

			}

		}
	}
	public static int contains(List<Player> list, Player p) {
		int ans = -1;
		Player tmp = null;
		for(int i=0; i<list.size(); i++) {
			//System.out.println(list.get(i));
			if(isValid(list.get(i),p)) {
				tmp = list.remove(i);
				//System.out.println(tmp);
				return tmp.id;
			}
		}
		return -1;
	}
	public static boolean isValid(Player x, Player y) {
		//System.out.println(x+"\n"+y);
		if(!(x.minr<=y.r&&y.r<=x.maxr && y.minr<=x.r&&x.r<=y.maxr))
			return false;
		if(!x.ra.equals(y.ra))
			return false;
		if(x.wt != y.wt)
			return false;
		if(x.co.equals(y.co)){
			if(x.co.equals("random"))
				return true;
			return false;
		} else if(x.co.equals("black") && y.co.equals("white"))
			return true;
		else if(x.co.equals("white") && y.co.equals("black"))
			return true;
		return false;
	}
}

