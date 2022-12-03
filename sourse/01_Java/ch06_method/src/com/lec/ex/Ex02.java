package com.lec.ex;
//1~10���� ������ ��, ����� ¦������ Ȧ������ ���
public class Ex02 {
	private static int sum(int from, int to) {
		int sum = 0; //������ ����
		for(int i=from ; i<=to ; i++) {
			sum+=i;
		}
		return sum;
	}
	private static String evenOdd(int total) {
		String result = total%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�";
		return result;
	}
	public static void main(String[] args) {
		int total = sum(1, 10);
		System.out.println("1~10���� ������ ����" + total);
		System.out.println(evenOdd(total));
		//-----------------------------------------------------
		total = sum(10, 100);
		System.out.println("10~100���� ������ ����" + total);
		System.out.println(evenOdd(total));
	}
}

/*
4-private static int sum(int from, int to) : private(�� ���� �������� �� �� �ִ�) 
 											 sum�� ���� (from, to �Ű����� ����)

9-return sum;  :  sum �� ȣ���� ������ ����� ��  

11-private static String evenOdd(int total) : evenOdd ������ String���� ���

*/