//<����.�ֹι�ȣ�� �Է¹޾� �������� �������� ��� ����> �ֹι�ȣ�� ��920225-2012121���������� �Է¹޴´�.
package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05_juminNoQuiz {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ֹι�ȣ(6�ڸ�-7�ڸ�) : ");
		String juminNo = scanner.next();
		int genderInt = Integer.parseInt(juminNo.substring(7,8));
		if (genderInt == 1 || genderInt == 3) {
			System.out.println("�����Դϴ�");
		} else if (genderInt == 2 || genderInt == 4) {
			System.out.println("�����Դϴ�");
		} else {
			System.out.println("��ȿ���� ���� �ֹι�ȣ�Դϴ�");
		}
	}
}
