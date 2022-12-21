package com.lec.quiz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MemberTestMain_printWriter {
	public static void main(String[] args) {
		ArrayList<Member> members = new ArrayList<>();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		Scanner scanner = new Scanner(System.in);
		String today = sdf.format(now);
		String name, tel, birthStr, address;
		int year, month, day;
		Date birthday = null;

		do {
			System.out.print("ȸ�������� �Ͻðڽ��ϱ�? (y/n)");
			if (scanner.next().equalsIgnoreCase("n"))
				break;
			System.out.print("�̸�");
			name = scanner.next();
			System.out.print("��ȭ��ȣ(010-0000-0000)");
			tel = scanner.next();
			System.out.print("���� (yyyy-MM-dd)");
			birthStr = scanner.next();
			StringTokenizer token = new StringTokenizer(birthStr, "-");
			if (token.countTokens() == 3) {
				year = Integer.parseInt(token.nextToken());
				month = Integer.parseInt(token.nextToken());
				day = Integer.parseInt(token.nextToken());
				birthday = new Date(new GregorianCalendar(year, month - 1, day).getTimeInMillis());
				birthStr = birthStr.substring(birthStr.indexOf("-") + 1);
				if (birthStr.equals(today)) {
					System.out.println(name + "�� ���� ���ϵ帳�ϴ�");
				}
			} else {
				System.out.println("���� ������ �ٸ��ϴ�");
			}
			System.out.print("�ּ� (������)");
			scanner.nextLine();
			address = scanner.nextLine();
			members.add(new Member(name, tel, birthday, address));
			System.out.println("ȸ������ �Ϸ�");
		} while (true);
		scanner.close();

		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter("src/com/lec/quiz/member.txt");
			for (Member member : members) {
				System.out.print(member);
				printWriter.write(member.toString());
			}
			String msg = String.format("\t\t\t... ���� %d�� ����\n", members.size());
			System.out.println(msg);
			printWriter.write(msg);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (printWriter != null)
					printWriter.close();
			} catch (Exception ignore) {
				System.out.println(ignore.getMessage());
			}
		}
	}
}
