package com.lec.quiz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MemberTestMain_outputStream {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Date today = new Date();
		ArrayList<Member> member = new ArrayList<>();
		OutputStream os = null;
		do {
			System.out.print("ȸ�������� �Ͻðڽ��ϱ�? (y/n)");
			String newMember = scanner.next().trim();
			if (newMember.equalsIgnoreCase("x"))
				break;
			System.out.print("�̸�");
			String name = scanner.next();
			System.out.print("��ȭ��ȣ(010-0000-0000)");
			String tel = scanner.next();
			System.out.print("���� (yyyy-MM-dd)");
			String birthday = scanner.next();
			System.out.print("�ּ� (������)");
			String address = scanner.next();
			member.add(new Member(name, tel, birthday, address));
		} while();
		
	}
}
/*
 * ArrayList : ȸ�� Date : ���� ������ ȸ���� �ִ��� Ȯ�� today : ���� ����
 * 
 */