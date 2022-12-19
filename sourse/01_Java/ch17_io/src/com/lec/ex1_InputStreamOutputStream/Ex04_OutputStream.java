package com.lec.ex1_InputStreamOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex04_OutputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt");
			String msg = "Hello, Java \n ���� ��׿�.";
			byte[] bs = msg.getBytes(); // ��Ʈ���� byte�迭�� �ٲٴ� �Լ�
			os.write(bs);
			System.out.println("���� ��� ����");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null)
					os.close();       //3 
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
