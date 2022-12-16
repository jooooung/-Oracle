package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1; // ����ڿ��� �Է¹��� ���� ������ ����
		System.out.print("ù��° ������? ");
		do {
			try {
				i = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("���ڸ� �Է��߽��ϴ�. ���ڸ� �Է����ּ���");
				scanner.nextLine(); // ���� ����� �뵵
			}
		} while (true); // ���ڸ� �Է��ϸ� �߻��ϴ� ���� ó��, ���ڸ� �Է��� �� ���� �Է� �ޱ�
		System.out.print("�ι�° ������? ");
		try {
			j = scanner.nextInt();
			System.out.println("i / j = " + (i / j));
		} catch (InputMismatchException e) {
			System.out.println("�ι�° ������ �߸� �Է��ϼż� 1�� ó���մϴ�");
		} catch (Exception e) { // catch �� ��������� Exception�� �������� ���(���� Ŭ������ �ؿ�)
			System.out.println(e.getMessage()); // ��κ� �ٸ޼��� ���� ���
//			e.printStackTrace(); // ���° �ٿ��� � ���ܰ� ��Ÿ������ �˷���
		}
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i * j));
		System.out.println("i + j = " + (i + j));
		System.out.println("i - j = " + (i - j));
		System.out.println("DONE");
		scanner.close();
	}
}
