

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;



public class NIOFileCopy {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String infile = "C:\\hello.txt";
		String outfile = "C:\\hellocopy.txt";
		// ��ȡԴ�ļ���Ŀ���ļ������������
		FileInputStream fin = null;
		try{
			fin = new FileInputStream(infile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			NewFile();
			AddIntoFile();
			fin = new FileInputStream(infile);
		}
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(outfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ��ȡ�������ͨ��
		FileChannel fcin = fin.getChannel();
		FileChannel fcout = fout.getChannel();
		// ����������
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (true) {
			// clear�������軺������ʹ�����Խ��ܶ��������
			buffer.clear();
			// ������ͨ���н����ݶ���������
			int r = fcin.read(buffer);
			// read�������ض�ȡ���ֽ���������Ϊ�㣬�����ͨ���ѵ�������ĩβ���򷵻�-1
			if (r == -1) {
				break;
			}
			// flip�����û��������Խ��¶��������д����һ��ͨ��
			buffer.flip();
			// �����ͨ���н�����д�뻺����
			fcout.write(buffer);
		}

	}
	public static void NewFile(){
		File f=new File("c:\\hello.txt");
        try{
            f.createNewFile();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("could not create the file.");
        }
        finally
        {
        	f = null;
        }
		
	}
	
	public static void AddIntoFile() throws FileNotFoundException{
		String fileName = "c:" + File.separator + "hello.txt";
		File f = new File(fileName);
		OutputStream out = new FileOutputStream(f);
		String str = "���";
		byte[] b = str.getBytes();
		try {
			out.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
