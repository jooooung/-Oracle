package com.lec.ConditionQuiz;
//��ǻ�Ϳ� ���������� ������ �ϴ� ���α׷��� �����Ͻÿ�. 
//����(0) ����(1) ��(2)
import java.util.Scanner;

public class Quiz4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int u, com;
		com = (int) (Math.random() * 3);
		System.out.print("����(0), ����(1), ��(2) �� �ϳ��� ������");
		u = sc.nextInt();
		if (u == 0) {
			System.out.println("������ �½��ϴ�");
		} else if (u == 1) {
			System.out.println("������ �½��ϴ�");
		} else if (u == 2) {
			System.out.println("���� �½��ϴ�");
		} else {
			System.out.println("�߸� �½��ϴ�");
			u = 3;
		}
		if (u != 3) {
			if (com == 0) {
				System.out.println("��ǻ�ʹ� ����");
			}
		} else if (com == 1) {
			System.out.println("��ǻ�ʹ� ����");
		} else if (com == 0) {
			System.out.println("��ǻ�ʹ� ��");
		}
		if(u == 0) {
			if(com == 0) {
				System.out.println("�����ϴ�");
			}else if(com == 1) {
				System.out.println("��ǻ�Ͱ� �̰���ϴ�");
			}else {
				System.out.println("�̰���ϴ�");
			}
		}
		if(u == 1) {
			if(com == 0) {
				System.out.println("�̰���ϴ�");
			}else if(com == 1) {
				System.out.println("�����ϴ�");
			}else {
				System.out.println("��ǻ�Ͱ� �̰���ϴ�");
			}
		}
		if(u == 2) {
			if(com == 0) {
				System.out.println("��ǻ�Ͱ� �̰���ϴ�");
			}else if(com == 1) {
				System.out.println("�̰���ϴ�");
			}else {
				System.out.println("�����ϴ�");
			}
		}
		sc.close();
	}//main
}//clase
