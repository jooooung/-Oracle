// Book book = new Book("890-01-11", "java", "ȫ�浿");
package com.lec.ex5_booklib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Book implements ILendable {
	private String bookNo; // å��ȣ
	private String bookTitle; // å�̸�
	private String writer; // ����
	private String borrower; // ������
	private Date checkOutDate;  
	private byte state; // ���� ���� : ������(1), ���Ⱑ��(0)

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E) HH�� mm��");
		if (state == STATE_BOOROWED) { // �������̸� �޼��� �Ѹ��� ��
			System.out.println(bookTitle + "�� �������Դϴ�");
			return; // void �̱⿡ return �ڿ� �� �Է� �Ұ�
		}
		// state�� 0(STATE_NORMAL)�̶� ���� ����
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BOOROWED; // ������ ���·� ��ȯ
		System.out.println(bookTitle + "������ ���� ó�� �Ǿ����ϴ�");
		System.out.println("������ : " + borrower + "\t������ : " + sdf.format(checkOutDate));
	}

	@Override
	public void checkIn() throws Exception {
		if (state == STATE_NORMAL) {
			throw new Exception("�ݳ� �Ϸ�� å�Դϴ�");
		}
		Date now = new Date();
		// checkOutDate�� ����������� ��¥ ���
		long chk = now.getTime() - checkOutDate.getTime();
		long day = chk/(1000*60*60*24); // ������
		// ��ü�� �ΰ� -> ��ü�� �޾Ҵ��� ���ο� ���� �ݳ� ó�� ����
		if (day > 14) {
			long i = (day) * 100; //��ü�� 
			System.out.printf("%d�� ��ü�Ǿ� ��ü���� %d���Դϴ�. ��ü�Ḧ �����̽��ϱ�(Y/N)? ", day, i);
			Scanner scanner = new Scanner(System.in);
			if(!scanner.next().trim().toUpperCase().equalsIgnoreCase("Y")) {
				System.out.println(bookTitle + "��ü�Ḧ ���� �ݳ� ó���� �˴ϴ�");
				return;
			}
		}
		// state�� ������(1)�̶� �ݳ� ó��
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "������ �ݳ� �Ϸ�Ǿ����ϴ�");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E) HH�� mm��");
		String msg = bookNo + "\t" + bookTitle + "\t" + "(" + writer + "��)-";
		msg += state == STATE_NORMAL ? "���Ⱑ�� " : "���� �� "+ sdf.format(checkOutDate);
		return msg;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public byte getState() {
		return state;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
}
