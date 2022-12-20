package com.lec.ex3_readerWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_Reader {
	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("D:\\JK\\sourse\\01_Java\\ch17_io\\txtFile\\inTest.txt");  //1�ܰ�
			while (true) {  //2�ܰ�  
				int i = reader.read();  //2byte�� ����
				if (i == -1) break;    //file�� ���̸� break
				System.out.print((char)i);  //����ȯ�Ͽ� ���
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}//try-catch-finally
	}//main
}
