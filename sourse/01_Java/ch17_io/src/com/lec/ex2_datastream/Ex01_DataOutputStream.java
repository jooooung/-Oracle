package com.lec.ex2_datastream;
//�ڹٿ����� ���� �� �ִ� ���� �����
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//outputStream�� ����(���� ������ ��Ʈ��)
public class Ex01_DataOutputStream {
	public static void main(String[] args) {
		OutputStream fos = null;		//�⺻ ��Ʈ��
		DataOutputStream dos = null;	//���� ��Ʈ��
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat"/* , true */);   //true�� �߰�, ������ �����
			dos = new DataOutputStream(fos);
		    dos.writeUTF("ȫ�浿");   //��Ʈ�� ����
		    dos.writeInt(2);
		    dos.writeDouble(95.5);
		    
		    dos.writeUTF("���浿");   //��Ʈ�� ����
		    dos.writeInt(6);		//int ����
		    dos.writeDouble(96.6);	//double ����
		    System.out.println("���� ���� �Ϸ�");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}//try-catch-finally
	}//main
}
