package com.lec.ex;
//���������  + - * / %(������������)
public class Ex01 {
	public static void main(String[] args) {
		int n1=99, n2=10;
		int result; double resultDouble;
		result = n1 + n2;
		System.out.printf("%d %c %d = %d\n'", n1, '+', n2, result);
		result = n1 / n2;
		System.out.printf("%d %c %d = %d\n'", n1, '/', n2, result);  //�� ���ϱ�
		result = n1 % n2;
		System.out.printf("%d %c %d = %d\n'", n1, '%', n2, result);  //������ ���ϱ�
		//������ �������� �뵵 : ¦ȣ�� �Ǻ�, ��� �Ǻ�...
		if (n1%2 == 0) {
			System.out.println("n1�� ¦��");
		}else {
			System.out.println("n1�� Ȧ��");           //n1%2 == 0  n1%����   ���ڿ� 3�� ���� 3�ǹ��
		}
	}
}
