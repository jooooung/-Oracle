//������ : accountNo(String), ownerName(String), balance(long)
//���(�޼ҵ�) : deposit(����), withdraw(����), infoPrint(�������)
package com.lec.ex12_account;

public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;
	public Account() {}
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.println(ownerName + "�� ���� ���� �����մϴ�. �ܾ� : "+ balance);
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.println(ownerName+"�� ���� ���� �����մϴ�. �ܾ� : "+balance);
	}
	public void deposite(long money) {//�����ϱ�
		balance += money;
		System.out.println(money+"�� �����Ͽ� �ܾ� : "+balance);
	}
	public void withdraw(long money) {//�ܾ��� ���� ��쿡�� ����ǰ� �ϱ�
		if(balance>=money) {
			balance -= money;
			System.out.println(money+"�� �����Ͽ� �ܾ� :" + balance);
		}else {
			System.out.println("�ܾ��� �����Ͽ� ���� �Ұ��մϴ�");
		}
	}
	public void infoPrint() {
		// "110-333-5555" ȫ�浿�� �ܾ� : 10�� ���
//		System.out.println("\""+accountNo+"\" "+ ownerName +"�� �ܾ� :" + balance + "��" );
		System.out.printf("\" %s \"%s�� �ܾ� : %d��\n", accountNo, ownerName, balance);
	}
	//setter : name      ���¹�ȣ, �ܾ��� ������ �� ����  �̸��� ���� �����ϰ�
	//getter 
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String infoString() {
		//return "\""+accountNo+"\" "+ ownerName +"�� �ܾ� :" + balance + "��";
		return String.format("\" %s \"%s�� �ܾ� : %d��\n", accountNo, ownerName, balance);
	}
}
