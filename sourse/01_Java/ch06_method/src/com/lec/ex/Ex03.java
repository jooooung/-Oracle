package com.lec.ex;

import com.lec.method.Arithmetic;
//Arithmetic �� ����ϱ� ���� import
public class Ex03 {
	public static void main(String[] args) {
		System.out.println("-9�� ���밪 : " + Arithmetic.abs(-9));
		//default���������ڴ� ���� ��Ű���� ��� ����
		Arithmetic Ar = new Arithmetic();
		int tot = Ar.sum(10);
		System.out.println("����" + tot);
		System.out.println(Ar.evenOdd(tot));
		tot = Ar.sum(10, 100);
		System.out.println("����" + tot);
		System.out.println(Ar.evenOdd(tot));
	}
}
