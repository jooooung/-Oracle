package com.lec.quiz;

import java.util.Scanner;

//���̸� �Է¹޾� �Է¹��� ���̰� 65�� �̻��� ��, ����ο�롱 ���, �ƴϸ� ���Ϲݡ����
public class Quiz4 {
	public static void main(String[] args) {
	Scanner cs = new Scanner(System.in);
	System.out.print("���̸� �Է��� �ּ��� : ");
	int age = cs.nextInt();
	System.out.println((age>=65) ?"��ο��":"�Ϲ�");
	cs.close();
	}	
}
