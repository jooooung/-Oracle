// Book book = new Book("890-01-11", "java", "ȫ�浿");
package com.lec.ex08_booklib;

public class Book implements ILendable {
	private String bookNo; // å��ȣ
	private String bookTitle; // å�̸�
	private String writer; // ����
	private String borrower; // ������
	private String checkOutDate; // ������
	private byte state; // ���� ���� : ������(1), ���Ⱑ��(0)

	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state == STATE_BOOROWED) { // �������̸� �޼��� �Ѹ��� ��
			System.out.println(bookTitle + "�� �������Դϴ�");
			return; // void �̱⿡ return �ڿ� �� �Է� �Ұ�
		}
		// state�� 0(STATE_NORMAL)�̶� ���� ����
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BOOROWED; // ������ ���·� ��ȯ
		System.out.println(bookTitle + "������ ���� ó�� �Ǿ����ϴ�");
		System.out.println("������ : " + borrower + "\t������ : " + checkOutDate);
	}

	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(bookTitle + "������ �ݳ��Ϸ�� å�Դϴ�. Ȯ���ϼ���");
			return;
		}
		// state�� ������(1)�̶� �ݳ� ó��
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "������ �ݳ� �Ϸ�Ǿ����ϴ�");
	}

	@Override
	public void printState() {
//		if (state == STATE_NORMAL) {
//			System.out.println(bookNo + "\t" + bookTitle + "\t" + "(" + writer + "��)-���Ⱑ��");
//		} else if (state == STATE_BOOROWED) {
//			System.out.println(bookNo + "\t" + bookTitle + "\t" + "(" + writer + "��)-���� ��");
//		}
		String msg = bookNo + "\t" + bookTitle + "\t" + "(" + writer + "��)-";
		msg += state == STATE_NORMAL ? "���Ⱑ��" : "���� ��";
		System.out.println(msg);
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public byte getState() {
		return state;
	}
}
