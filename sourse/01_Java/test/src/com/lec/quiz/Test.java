package com.lec.quiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Friend> friends = new ArrayList<>();
		friends.add(new Friend("ȫ�浿", "010-9999-1234", "����� ��걸",
					new Date(new GregorianCalendar(0, 04, 22).getTimeInMillis())));
		friends.add(new Friend("�ű浿", "010-9999-9999", "����� ������",
					new Date(new GregorianCalendar(0, 03, 05).getTimeInMillis())));

		while (true) {
			boolean searchOk = false;
			System.out.print("�˻��� �ּ� �� ���� 2�ڸ�(��, ���Ḧ ���Ͻø� x�� �Է��Ͻÿ�) : ");
			String searchAdd = scanner.next();
			if (searchAdd.equalsIgnoreCase("x"))
				break;
			for (Friend friend : friends) {
				String address = friend.getAddress();
				String frontAddress = address.substring(0, 2);
				if (searchAdd.equals(frontAddress)) {
					System.out.println(friend);
					searchOk = true;
				}
			}
			if (!searchOk) {
				System.out.println("�ش� ������ ģ���� �����ϴ�\n");
			}
		}
	}
}