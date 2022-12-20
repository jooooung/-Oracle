package com.lec.ex4_BufferedReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Reader reader = null;	
		BufferedReader br = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�о�� ���ϸ� : ");
		String filename = scanner.next();
		File file = new File("txtFile/" + filename);  // ���ϸ� 
		try {
			if(file.exists()) {  //���� ���� ����
				reader = new FileReader("txtFile/" + filename);  //1. ��Ʈ������
				br = new BufferedReader(reader);  //������Ʈ���� �⺻��Ʈ���� ���ؼ� ���(PrintWriter�� ����)
				while(true) {
					String linedata = br.readLine();  //2. ���پ� �б�
					if(linedata == null) break;
					System.out.println(linedata);
				}	
			} else {
				System.out.println("�Է��Ͻ� ������ �������� �ʽ��ϴ�");
			}
			System.out.println("���� �Է� ��");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		scanner.close();
	}
}
