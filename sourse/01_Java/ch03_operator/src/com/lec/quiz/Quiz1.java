package com.lec.quiz;

import java.util.Scanner;

//3�� ��� ���� �Ǵ��ϱ� : ����ڷκ��� ���ڸ� �Է� �ް�, �Է� ���� ���ڰ� 3�� ������� �ľ�
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		String result = (num %3 ==0) ? "3�� ����̴�":"3�� ����� �ƴϴ�";
		System.out.printf("�Է��Ͻ� (%d)�� %s\n", num, result);
		sc.close();  
		
	}
}

