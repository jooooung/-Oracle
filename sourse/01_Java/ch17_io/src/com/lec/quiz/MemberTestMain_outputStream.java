package com.lec.quiz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberTestMain_outputStream {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Member> member = new ArrayList<>();
		Writer writer = null;
		try {
			writer = new FileWriter("com\\lec\\quiz\\MemberTestMain_outputStream.txt", true);
			do {
				System.out.print("ȸ�������� �Ͻðڽ��ϱ�? (y/n)");
				if (scanner.next().trim().equals("x"))
					break;
				System.out.print("�̸�");
				name = scanner.next();
				System.out.print("��ȭ��ȣ(010-0000-0000)");
				String tel = scanner.next();
				System.out.print("���� (yyyy-MM-dd)");
				String birthday = scanner.next();
				System.out.print("�ּ� (������)");
				String address = scanner.next();
			} while();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
/*
ArrayList : ȸ�� 
Date : ���� ������ ȸ���� �ִ��� Ȯ��
today : ���� ����

*/