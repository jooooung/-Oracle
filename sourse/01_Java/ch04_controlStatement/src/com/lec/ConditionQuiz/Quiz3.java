package com.lec.ConditionQuiz;
//���������� �� �ϳ��� ���� �� ���� ����ϼ���(������� 0, ������� 1, ����� 2�� �Է�)
import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("����(0), ����(1), ��(2)�� �ϳ��� �����ϼ���");
		int you = sc.nextInt(); 
		if(you == 0) {
			System.out.println("����� ����");
		}else if(you == 1) {
			System.out.println("����� ����");
		}else if(you == 2) {
			System.out.println("����� ��");
		}else {
			System.out.println("��ȣ���� ���� ���Դϴ�");
		}
		sc.close();
	}
}
