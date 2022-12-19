package com.lec.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class HashMapTestMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Customer> hashmap = new HashMap<>();
		while (true) {
			System.out.println("ȸ�������� �����Ͻðڽ��ϱ�? (Y/N)");
			String newCus = sc.next();
			if (newCus.equalsIgnoreCase("N")) {
				if (hashmap.size() == 0) {
					System.out.println("ȸ���� �����ϴ�");
				} else {
					Iterator<String> iterator = hashmap.keySet().iterator();
					while (iterator.hasNext()) {
						String key = iterator.next();
						System.out.println(hashmap.get(key));
					}
				}
				break;
			} else if (newCus.equalsIgnoreCase("Y")) {
				Customer newCustomer = new Customer();
				System.out.println("�̸��� �Է����ּ��� ");
				String name = sc.next();
				System.out.println("��ȭ��ȣ�� �Է����ּ���");
				String tel = sc.next().trim();
				System.out.println("�ּҸ� �Է��� �ּ���(������)");
				sc.nextLine();
				String address = sc.nextLine().trim();
				hashmap.put(tel, new Customer(name, tel, address));
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�");
			} else {
				System.out.println("�߸� �Է��߽��ϴ�");
			}
		}
	}
}
