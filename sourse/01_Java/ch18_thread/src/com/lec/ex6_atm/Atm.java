package com.lec.ex6_atm;

public class Atm {
	private int balance;

	public Atm(int balance) {
		this.balance = balance;
	}
	
	public synchronized void deposit(int amount, String who) {
		System.out.println(who + "�� �Ա� ����");
		balance += amount;
		System.out.println(who + "��" + amount + "�� �Ա��Ͽ� �ܾ� : " + balance);
		System.out.println(who + "�� �Ա� ��");
	}
	
	public synchronized void withdraw(int amount, String who) {
		System.out.println(who + "�� ��� ����");
		balance -= amount;
		System.out.println(who + "��" + amount + "�� ����Ͽ� �ܾ� : " + balance);
		System.out.println(who + "�� ��� ��");
	}
	
	public int getBalance() {
		return balance;
	}
}
