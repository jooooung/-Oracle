package com.lec.quiz;

import java.util.Scanner;

//����, ����, ���� ������ ����ڿ��� �Է¹޾�, 
//�� ������ ����ϰ� ����, ���(�Ҽ���2�ڸ�����) ����ϴ� ���α׷��� ���� �Ͻÿ�
public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int kor = sc.nextInt();
		System.out.print("���� : ");
		int eng = sc.nextInt();
		System.out.print("���� : ");
		int mat = sc.nextInt();
		
		int tot = kor + eng + mat;
		double avg = tot/3.;
		System.out.printf("���� = %d, ���� = %d, ���� = %d\n",kor, eng, mat);
		System.out.printf("���� = %d, ��� = %.2f\n", tot, avg);   
		//��� = %d.2f\n   ������ ǥ���ϴ� d�� �Է��Ͽ� ����
		sc.close();		
	}
}
