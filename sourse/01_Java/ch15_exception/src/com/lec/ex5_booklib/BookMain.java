package com.lec.ex5_booklib;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookMain {
	public static void main(String[] args) {
		Book[] books = { new Book("890��-01-11", "java", "ȫ�浿"), new Book("890��-01-12", "oracle", "���浿"),
						 new Book("890��-02-01", "mysql", "���浿"), new Book("890��-01-01", "jdbc", "���̵�"),
						 new Book("890��-01-01", "html", "�̿���") };
//		books[1].checkOut("kim");
//		books[1].setCheckOutDate(new Date(
//				new GregorianCalendar(2022, 10, 30).getTimeInMillis())); //������ �����Ͽ� ��ü�� �޾ƺ���
//		System.out.println(books[1]);
//		try {
//			books[1].checkIn();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}//try
		Scanner scanner = new Scanner(System.in);
		String fn; // ��ɹ�ȣ (1:����/2:�ݳ�/3:ålist/0:����)
		int idx; // �����ϰų� �ݳ� �� ��ȸ�� å�� index
		String bTitle, borrower; // ����ڿ��� ���� å �̸�, ������

		do {
			System.out.print("1:����/ 2:�ݳ�/ 3:ålist/ 0:����");
			fn = scanner.next();
			switch (fn) {
			case "1": // ���� : 1.å�̸��Է� 2.å��ȸ 3.å����Ȯ�� 4.�������Է� 5.����޼ҵ� ȣ��
				// 1.å�̸��Է�
				System.out.print("�����ϰ��� �ϴ� å �̸���?");
				scanner.nextLine();
				bTitle = scanner.nextLine().trim(); 
				// 2.å��ȸ
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				} // for
					// idx��° å���� ����
				if (idx == books.length) {
					System.out.println("���� �������� ���� �����Դϴ�");
				} else { // books[idx] ������ ����
					// 3.å����Ȯ��
					if (books[idx].getState() == Book.STATE_BOOROWED) {
						System.out.println("���� ���� ���� �����Դϴ�");
					} else {
						// 4.�������Է�
						System.out.println("�������� ?");
						borrower = scanner.next();
						// 6.����޼ҵ� ȣ��
						books[idx].checkOut(borrower);
					} // if ����Ȯ��
				} // if ������ȸ
				break;
			case "2": // �ݳ� : 1.å�̸��Է� 2.å��ȸ 3.�ݳ��޼ҵ� ȣ��
				System.out.print("�ݳ��ϰ��� �ϴ� å �̸���?");
				bTitle = scanner.next(); // white-space �ձ����� ��Ʈ���� ����
				// 2.å��ȸ
				for (idx = 0; idx < books.length; idx++) {
					if (bTitle.equals(books[idx].getBookTitle())) {
						break;
					}
				}
				if (idx == books.length) {
					System.out.println("�ش� ������ �� �������� å�� �ƴմϴ�");
				} else {
					// 3.�ݳ� �޼ҵ� ȣ��
					try {
						books[idx].checkIn();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case "3": // ålist ���
				for (Book book : books) {
					System.out.println(book);
				}
			}// switch
		} while (!fn.equalsIgnoreCase("0"));
		System.out.println("����");
	}
}
