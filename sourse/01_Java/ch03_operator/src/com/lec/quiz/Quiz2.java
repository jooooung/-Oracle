package com.lec.quiz;

import java.util.Scanner;

// �Է��� ���� ¦������ Ȧ������ ���
public class Quiz2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : ");
		int num = sc.nextInt();
		String result = (num %2 ==0) ? "¦���Դϴ�":"Ȧ���Դϴ�";
		System.out.printf("�Է��� (%d)�� %s\n", num, result);
		sc.close();
	}   
	
}
