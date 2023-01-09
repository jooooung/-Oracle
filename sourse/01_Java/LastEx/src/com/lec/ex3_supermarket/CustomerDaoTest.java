package com.lec.ex3_supermarket;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = CustomerDao.getInstance();
		int result;
		ArrayList<CustomerDto> Customers;
		System.out.println("----------1. ȸ������ --------");
		String ctel = "010-1111-1111", cname="�̼���";
		result = dao.insertCustomer(ctel, cname);
		System.out.println(result==CustomerDao.SUCCESS? cname+"�� ȸ������ �Ϸ�. ����Ʈ 1000��":"cname�� ȸ������ ����");
		System.out.println("----------2. ��ȭ��ȣ �˻� ----------");
		ctel = "3333";
		Customers = dao.ctelGetCustomers(ctel);
		if(Customers.isEmpty()) {
			System.out.println("��ȭ��ȣ�� �����ϴ�");
		} else {
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������ʿ�ݾ�");
			for (CustomerDto customer : Customers) {
				System.out.println(customer);
			}
		}
		System.out.println("--------3. ���Ǳ���-----------");
		result = dao.buy(1, 200000);
		if(result==CustomerDao.SUCCESS) {	// ���� ���� �� �����޼����� �� ���� ���
			CustomerDto customer = dao.getCustomer(1);
			System.out.println("�������ּż� �����մϴ�");
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������ʿ�ݾ�");
			System.out.println(customer);
		} else {
			System.out.println("id�� �߸� �Է��Ͽ����ϴ�");
		}
		System.out.println("-----------4. ��޺� ��----------------");
		System.out.println("��� : " + dao.getLevelNames());
		Customers = dao.levelNameGetCustomers("VVIP");
		if(Customers.size()==0) {
			System.out.println("�� ����� ���� �����ϴ�");
		} else {
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������ʿ�ݾ�");
			for (CustomerDto customer : Customers) {
				System.out.println(customer);
			}
		} 
		System.out.println("--------- 5. ��ü���---------");
		Customers = dao.getCustomers();
		if(Customers.size()==0) {
			System.out.println("�� ����� ���� �����ϴ�");
		} else {
			System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������ʿ�ݾ�");
			for (CustomerDto customer : Customers) {
				System.out.println(customer);
			}
		}
		System.out.println("---------- 6. ȸ��Ż��----------");
		result = dao.deleteCustomer("010-1234-1234");
		System.out.println(result==CustomerDao.SUCCESS? "��������":"��ȿ�� ��ȭ��ȣ�� �ƴմϴ�");
		
		System.out.println("���̵�\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������ʿ�ݾ�");
		for (CustomerDto customer : Customers) {
		System.out.println(customer);
		}
	}
}

