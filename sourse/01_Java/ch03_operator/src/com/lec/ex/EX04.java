package com.lec.ex;
// �������� : &&(AND), ||(or), !
public class EX04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		System.out.println("&& : (i<j) && (++j>h) ��" + ((i<j) && (++j>h)));
		System.out.println("j = "+j); //j=11
		
		System.out.println("&& : (i>j) && (++j>h) ��" + ((i>j) && (++j>h)));
		System.out.println("j = "+j);  //&&������ ��� ���װ��� false�� ��� ������ �������� �ʾ� �״�� 11
		
		System.out.println("|| : (i<j) || (++j>h) ��" + ((i<j) || (++j>h)));
		System.out.println("j = "+j); // ||�� ���װ��� true�� ��� ���� ���� x
		
		System.out.println("|| : (i>j) || (++j>h) ��" + ((i>j) || (++j>h)));
		System.out.println("j = "+j);
	}

}
