package com.lec.ex1_tryCatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j; // ����ڿ��� �Է¹��� ���� ������ ����
		System.out.print("ù��° ������? ");
		i = scanner.nextInt();
		System.out.print("�ι�° ������? ");
		j = scanner.nextInt();
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i * j));
		try {
			System.out.println("i / j = " + (i / j)); // ���ܰ� �߻��� ���� �ִ� �κ�
		} catch (ArithmeticException e) { // ���� �߻� �� ���� �κ�, () �ȿ� ���� ��ü ���� �ֱ� 
			                              //(Exception���� �Է� ����(��� ���ܴ� Exception�ȿ� �ֱ� ������))
			System.out.println(e.getMessage());      // ���ܸ޼��� ��� (������ ���� �Ѹ���)
		}
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		scanner.close();
	}
}
// ���� ó��  ������ �ƴ� 0���� �����⸦�ϸ� ���ܰ�ü �߻�
//try catch�� �̿��Ͽ� ���� ó���ϱ�
