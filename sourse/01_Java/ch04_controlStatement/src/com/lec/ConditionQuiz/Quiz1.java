package com.lec.ConditionQuiz;
//���� �Է¹޾� ���밪�� ����ϴ� ���α׷�
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : ");		
		int num = sc.nextInt();
		if(0>num) {
			System.out.println("�Է��� ���� ���밪�� = " + -num);
		}else {
			System.out.println("�Է��� ���� ���밪�� = " + num);
		}
		sc.close();
	}
}

//��� �Է½� �״�� ���, ���� �Է½� num �� - �� �߰��� �ٿ� ���밪�� �ǵ��� �������.  
//�Ǽ� �Է½� �������� ������ ���� -> ???
