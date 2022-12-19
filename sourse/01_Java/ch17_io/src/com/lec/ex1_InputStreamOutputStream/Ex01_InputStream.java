package com.lec.ex1_InputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1 ��Ʈ����ü����(������ ����) 2 �������д´�(read�޼ҵ� ���) 3 ������ �ݴ´�(close)
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt");
			// 2 �����͸� �д´�(���� ������ 1byte�� �ݺ������� �д´�)
			while (true) {
				int i = is.read(); // 1byte�� �б�
				if (i == -1)
					break; // ������ ���̸� break;
				System.out.print((char) i);
			}
			System.out.println("\nDONE");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("���ܸ޼��� : ���� �� ã�� " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("���ܸ޼��� : �� ����" + e.getMessage());
		} finally {
			// 3 ������ �ݴ´�
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
	}
}