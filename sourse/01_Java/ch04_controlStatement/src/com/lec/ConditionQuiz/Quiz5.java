package com.lec.ConditionQuiz;
//���� ��������� Ű����κ��� �Է¹޾� ������ ����ϴ� ���α׷��� �����ϼ���
import java.util.Scanner;

public class Quiz5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� �Է��ϼ��� : ");
		int month = sc.nextInt();
		switch(month){
		case 12: case 1: case 2:
			System.out.println(month + "���� �ܿ��̳׿�");break;
		case 3: case 4: case 5:
			System.out.println(month + "���� ���̳׿�");break;
		case 6: case 7: case 8:
			System.out.println(month + "���� �����̳׿�");break;
		case 9: case 10: case 11:
			System.out.println(month + "���� �����̳׿�");break;
		default:
			System.out.println("��ȿ�� ���� ���� �ƴմϴ�");
		}
		/*
		if(month==12 || month==1 || month==2) {
			System.out.println("�Է��Ͻ� ������ �ܿ��̳׿�");
		}else if(month==3 || month==4 || month==5) {
			System.out.println("�Է��Ͻ� ������ ���̳׿�");
		}else if(month==6 || month==7 || month==8) {
			System.out.println("�Է��Ͻ� ������ �����̳׿�");
		}else if(month==9 || month==10 || month==11) {
			System.out.println("�Է��Ͻ� ������ �����̳׿�");
		}else {
			System.out.println("��ȿ�� ���� ���� �ƴմϴ�.");
		}
		*/
		sc.close();
	}
}
