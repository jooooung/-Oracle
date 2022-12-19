package com.lec.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListMain {
	private static String customer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Customer> customer = new ArrayList<>();
		while (true) {
			System.out.println("ȸ�������� �����Ͻðڽ��ϱ�? (Y/N)");
			String newCus = sc.next();
			if (newCus.equalsIgnoreCase("N")) {
				if (customer.size() == 0) {
					System.out.println("ȸ���� �����ϴ�");
				} else {
					for (Customer cus : customer) {
						System.out.println(cus);
					}
				}
				break;
			} else if (newCus.equalsIgnoreCase("Y")) {
				System.out.println("�̸��� �Է����ּ��� ");
				String name = sc.next();
				System.out.println("��ȭ��ȣ�� �Է����ּ���");
				String tel = sc.next().trim();
				System.out.println("�ּҸ� �Է��� �ּ���(������)");
				sc.nextLine();
				String address = sc.nextLine().trim();
				customer.add(new Customer(name, tel, address));
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�");
			} else {
				System.out.println("�߸� �Է��߽��ϴ�");
			}
		}
	}
}
