//����ڷκ��� ���ϴ� �ܼ�(2~9) �������� ����ϴ� ���α׷��� �����Ͻÿ�.
//(��, �ܼ��� �Ű������� �޾� �ش� �ܼ��� �������� ����ϴ� �κ��� method�� ó���Ѵ�. 
//����ڰ� 2~9 ������ ���� �ƴ� ���� �Է��� �� 2~9������ ���� �Է��� ������ ��� �Է� �޴´�.)
package com.lec.ex;

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.print("���ϴ� �� ���� �Է��ϼ��� : ");
			num = sc.nextInt();
		} while (num < 2 || num > 9);
		num2(num);
	}
	private static void num2(int a) {
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", a, i, a * i);
		}
	}
}
