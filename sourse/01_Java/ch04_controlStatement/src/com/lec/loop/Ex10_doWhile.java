package com.lec.loop;

import java.util.Scanner;

// ¦���� �Է¹޾� ���
public class Ex10_doWhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		do {
			System.out.print("¦���� �Է��ϼ��� : ");
			num = sc.nextInt();
		}while(num%2 != 0);       //Ȧ���� �Է� �� �ٽ� �ݺ��ϵ���
		System.out.println("�Է��� ¦���� " + num);
		sc.close();
	}
}
