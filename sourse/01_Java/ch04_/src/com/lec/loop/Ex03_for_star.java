package com.lec.loop;
//�ܼ�â�� ������ ���� ��µǵ��� for���� �̿��Ͽ� �����Ͽ� ����
//*
//**
//***
//****
//*****
public class Ex03_for_star {
	public static void main(String[] args) {
		for(int i=1 ; i<=5 ; i++) {
			for(int j=1 ; j<=i; j++) {
				System.out.print('*');
			}//for-j
				System.out.println();   //���ุ �ϴ� ����
		}//for-i
	}//main
}//class