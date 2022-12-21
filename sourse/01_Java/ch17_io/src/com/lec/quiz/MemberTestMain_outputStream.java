package com.lec.quiz;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_outputStream {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Date today = new Date(new GregorianCalendar().getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		OutputStream fos = null;
		
		try {
			fos = new FileOutputStream("src/com/lec/quiz/member.txt", true);
			while (true) {
				System.out.print("ȸ�������� �Ͻðڽ��ϱ�? (y/n)");
				if (scanner.next().trim().equals("n"))
					break;
				System.out.print("�̸�");
				String name = scanner.next();
				System.out.print("��ȭ��ȣ(010-0000-0000)");
				String tel = scanner.next();
				System.out.print("���� (yyyy-MM-dd)");
				String birthday = scanner.next();
				System.out.print("�ּ� (������)");
				String address = scanner.next();
				System.out.println("ȸ������ �Ϸ�");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		ArrayList<Member> member = new ArrayList<>();
		InputStream fis = null;
		try {
			fis = new FileInputStream("src/com/lec/quiz/member.txt");
			while (true) {
				String name =  ((DataInputStream) fis).readUTF();
				String tel = ((DataInputStream) fis).readUTF();
				String birthStr = ((DataInputStream) fis).readUTF(); // "1998-12-12"
				Date birthday = null;
				StringTokenizer token = new StringTokenizer(birthStr, "-");
				if (token.countTokens() == 3) {
					int year = Integer.parseInt(token.nextToken());
					int month = Integer.parseInt(token.nextToken());
					int day = Integer.parseInt(token.nextToken());
					birthday = new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis());
				} else {
					System.out.println("���� ������ �ٸ��ϴ�");
				}
				String address = fis.read();
				member.add(new Member(name, tel, birthday, address));
				for (Member members : member) {
					System.out.println(members.toString());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
