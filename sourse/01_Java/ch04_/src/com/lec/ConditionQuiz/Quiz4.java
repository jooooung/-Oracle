package com.lec.ConditionQuiz;
//��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷��� �����Ͻÿ�. 
//��, ����ڴ� ������ ������ �� ���� 0�� �Է��ϰ� 
//������ �����ϰ��� �� ���� 1�� �Է��ϰ�,���� �����ϰ��� �� ���� 2�� �Է��Ͽ� ������ �����մϴ�

import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int u = sc.nextInt();
		System.out.print("����(0), ����(1), ��(2) �� �ϳ��� ������");
		switch(u*1){
		case 0:
			System.out.println("����� ����");break;
		case 1:
			System.out.println("����� ����");break;
		case 2:
			System.out.println("����� ��");break;
		default:
			System.out.println("��ȿ���� ���� �Է°��Դϴ�");
	}
	sc.close();
	}
}

