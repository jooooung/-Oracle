package com.lec.condition;

import java.util.Scanner;

//�Է¹��� ���� Ȧ������ ¦������ ���
public class Ex06_odd_even_number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���");
		int num = sc.nextInt();
		switch (num%2) {                //num �� 2�� ������ case 0 (0�̸� ¦��) default (0�� �ƴ϶�� Ȧ��)
		case 0:
			System.out.println("¦���Դϴ�");
			break;
		default:
			System.out.println("Ȧ���Դϴ�");
			break;
		}
		sc.close();
	}
}
