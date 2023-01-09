package com.lec.ex3_supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperMng {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		Scanner sc = new Scanner(System.in);
		String fn;
		ArrayList<CustomerDto> customers;
		do {
			System.out.print("1:ȸ������  2:��ȣ���ڸ�(Full)�˻�  3:��ǰ����  4:��޺����  5:��ü���  6:Ż��   �� ��:����  ->");
			fn = sc.next();
			switch (fn) {
			case "1":
				System.out.println("��ȭ��ȣ : ");
				String ctel = sc.next();
				System.out.println("�̸� : ");
				String cname = sc.next();
				int result = dao.insertCustomer(ctel, cname);
				System.out.println(result == CustomerDao.SUCCESS ? cname + "�� ȸ������ �Ϸ�. ����Ʈ 1000" : "ȸ������ ����");
				break;
			case "2":
				System.out.println("�˻��� ��ȭ��ȣ�� ���ڸ���? ");
				String searchTel = sc.next();
				customers = dao.ctelGetCustomers(searchTel);
				if (customers.isEmpty()) {
					System.out.println("�ش� ��ȣ�� ���� �����ϴ�");
				} else {
					System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������ʿ�ݾ�");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "3":
				System.out.println("�����̵� : ");
				int cid = sc.nextInt();
				System.out.println("���Ű��� : ");
				int price = sc.nextInt();
				result = dao.buy(cid, price);
				if (result == CustomerDao.SUCCESS) {
					System.out.println("���� �����մϴ�");
					CustomerDto customer = dao.getCustomer(cid);
					System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������ʿ�ݾ�");
					System.out.println(customer);
				} else {
					System.out.println(cid + "�� ��ȿ�� �� ���̵� �ƴմϴ�");
				}
				break;
			case "4":
				System.out.println("�˻��� ��� : " + dao.getLevelNames());
				String levelName = sc.next();
				customers = dao.levelNameGetCustomers(levelName);
				if (customers.isEmpty()) {
					System.out.println("�˻��� ���� �����ϴ�");
				} else {
					System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������ʿ�ݾ�");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "5":
				customers = dao.getCustomers();
				if (customers.isEmpty()) {
					System.out.println("�˻��� ���� �����ϴ�");
				} else {
					System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������ʿ�ݾ�");
					for (CustomerDto customer : customers) {
						System.out.println(customer);
					}
				}
				break;
			case "6":
				System.out.print("Ż���� �� ��ȭ��ȣ : ");
				ctel = sc.next();
				result = dao.deleteCustomer(ctel);
				System.out.println(result == CustomerDao.SUCCESS ? "Ż�� �Ϸ�" : "��ȿ�� ��ȭ��ȣ�� �ƴմϹ�");
				break;
			}

		} while (fn.equals("1") || fn.equals("2") || fn.equals("3") || fn.equals("4") || fn.equals("5")
				|| fn.equals("6"));
		System.out.println("BYE");
	}
}
