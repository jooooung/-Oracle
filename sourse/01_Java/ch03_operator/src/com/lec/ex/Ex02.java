package com.lec.ex;
//���������� : ++(1����), --(1����)
public class Ex02 {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1;  //n1�� 1 �����ϰ� n2�� �Ҵ�
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		n2 = n1++;      //n1���� n2�� �Ҵ��� �� 1����
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		n2 = --n1;
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		n2 = n1--;
		System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
		
		boolean result = !(n1!=n2);  //��������(�ݴ븦 �ǹ�)  �׳� result�� ���� ���� -> boolean �߰�
		System.out.println("!(n1!=n2!)��"+ result);   
	}
}

//n1 = 11, n2 = 11
//n1 = 12, n2 = 11
//n1 = 11, n2 = 11
//n1 = 10, n2 = 11
//!(n1!=n2)��false   -> �� !(n1!=n2) �״�� �̷��� ������?
