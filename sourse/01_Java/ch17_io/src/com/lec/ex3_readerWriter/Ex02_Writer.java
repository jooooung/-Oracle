package com.lec.ex3_readerWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt");
			String msg = "�ȳ��ϼ��� �ڹ�\n�߿� ���� ���� ����\n";
			writer.write(msg);
			String msg1 = "�̹� �ܿ�\n�ʹ� �߿�";
			writer.write(msg1);
		} catch (IOException e) {
		System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
