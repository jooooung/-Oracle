//�ſ�ī��
package com.lec.ex12_account;

public class CreditLineAccount extends CheckingAccount {
	private long creditLine;

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, long creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, long creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}
	@Override
	public void pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) { // �ùٸ� ī�� ��ȣ �Է�
			if(creditLine >= amount) { // �ܾ� o ���Ұ���
//				balance = balance - amount; balance�� private �̱⿡ setter getter �̿�
				creditLine -= amount; // �ܾ��� amount ��ŭ ����
				System.out.printf("%s�� %d�� �����Ͽ� �ѵ� %d��\n", getOwnerName(), amount, creditLine);
			}else { // �ܾ� ����  ���ҺҰ�
				System.out.printf("%s�� �ѵ� ����, ���� �Ұ��մϴ�\n", getOwnerName()	);
				
			}
		}else { // Ʋ�� ī�� ��ȣ �Է�
			System.out.println("��ȿ�� ī�� ��ȣ�� �ƴմϴ�");
		}
	}	
}
