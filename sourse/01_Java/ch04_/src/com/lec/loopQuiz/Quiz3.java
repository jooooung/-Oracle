package com.lec.loopQuiz;

import java.util.Scanner;

//����ڷκ��� ���ϴ� �����ܼ��� �Է¹޾� �ش� �������� ����� ���� (���� �ð����� 5������)
public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� �����ܼ��� �Է��� �ּ��� : ");
		int su = sc.nextInt(); 
		for(int i=1 ; i<=9 ; i++) {
			System.out.println(su+"*"+i+"="+(su*i));
		}
		sc.close();
	}
}
