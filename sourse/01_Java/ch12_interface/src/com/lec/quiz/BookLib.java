package com.lec.quiz;

public class BookLib extends BookInfo implements ILendable {
	private String borrower; // ������
	private String checkOutDate; // ������
	private byte state; // ���� ���� : ������(1), ���Ⱑ��(0)

	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state == STATE_BOOROWED) { // �������̸� �޼��� �Ѹ��� ��
			System.out.println(getBookTitle() + "�� �������Դϴ�");
			return; // void �̱⿡ return �ڿ� �� �Է� �Ұ�
		}
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BOOROWED; // ������ ���·� ��ȯ
		System.out.println(getBookTitle() + "������ ���� ó�� �Ǿ����ϴ�");
		System.out.println("������ : " + borrower + "\t������ : " + checkOutDate);
	}

	@Override
	public void checkIn() {
		if (state == STATE_NORMAL) {
			System.out.println(getBookTitle() + "������ �ݳ��Ϸ�� å�Դϴ�. Ȯ���ϼ���");
			return;
		}
		// state�� ������(1)�̶� �ݳ� ó��
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(getBookTitle() + "������ �ݳ� �Ϸ�Ǿ����ϴ�");

	}

	@Override
	public void printState() {
		String msg = getBookNo() + "\t" + getBookTitle() + "\t" + "(" + getWriter() + "��)-";
		msg += state == STATE_NORMAL ? "���Ⱑ��" : "���� ��";
		System.out.println(msg);
	}

	public byte getState() {
		return state;
	}
}
