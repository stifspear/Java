import java.util.*;
import java.io.File;
import java.io.*;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
class Compress {
	public static void main(String[] args) throws IOException{
		File toCompress = new File("testdir");
		FileOutputStream fout = new FileOutputStream("compressed.zip");
		ZipOutputStream zout = new ZipOutputStream(fout);
		for(File file : toCompress.listFiles()) {
			System.out.println("testdir"+File.separator+file.getName());
			zipFile(zout, file);
		}
		zout.finish();
		zout.close();
		fout.close();
	}
	public static void zipFile(ZipOutputStream zout, File file) throws IOException{
		FileInputStream fin = new FileInputStream("testdir"+ File.separator + file.getName());
		ZipEntry nextEntry = new ZipEntry("testdir"+ File.separator + file.getName());
		byte[] bytes = new byte[1024];
		int len = 0;
		zout.putNextEntry(nextEntry);
		while ((len = fin.read(bytes)) >= 0) {
			zout.write(bytes, 0, len);
		}
		fin.close();
	}
}
