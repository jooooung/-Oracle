package com.lec.ex;
//1~10���� ������ ��, ����� ¦������ Ȧ������ ���
public class Ex01 {
	public static void main(String[] args) {
		int total = 0;
		for(int i=0 ; i<=10 ; i++) {
			total += i;
		}
		System.out.println("1~10���� ������ ����" + total);
		System.out.println(total%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�");
		//-----------------------------------------------------
		total = 0;
		for(int i=10 ; i<=100 ; i++) {
			total += i;
		}
		System.out.println("10~100���� ������ ����" + total);
		System.out.println(total%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�");
	}
}
