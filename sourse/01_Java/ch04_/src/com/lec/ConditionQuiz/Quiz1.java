package com.lec.ConditionQuiz;

import java.util.Scanner;

//���� �Է¹޾� ���밪�� ����ϴ� ���α׷�
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��ϼ���");
		int num = sc.nextInt();
		if(0>num) {
			System.out.println(-num);
		}
		sc.close();
	}
}
