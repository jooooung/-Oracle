//�Է��� ���� ���丮��� ����ϱ�
// s! = s * (s-1) * (s-2) ... * 2 * 1 
// 1! = 1 (factorial ����� ����� �Է��ϴ� ������ �Ѵ�)
package com.lec.ex;

import java.util.Scanner;

public class Ex05_factorial {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("��!�� ����ұ��? ");
		int num = scanner.nextInt();
		long result = factorial(num);				//������� ũ�⶧���� int�� �ƴ� long ���
		System.out.println(num + "! =" + result);
	}
	private static long factorial(int s) {
		long result = 1; // ���� ���̱� ������ 1
		for(int i=s ; i>=1 ; i--) {
			result *= i; 
		}
		return result;
	}
}

// ����� �ƴ� ���� �Է��ϸ� ����