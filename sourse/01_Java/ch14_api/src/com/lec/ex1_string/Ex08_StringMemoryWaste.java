package com.lec.ex1_string;

public class Ex08_StringMemoryWaste {
	public static void main(String[] args) {
		String str = "Hello, Java";
		// str�� �ּ� ��� (x) -> �ؽ��ڵ�� ��ü
		System.out.println("str�� �ؽ��ڵ� : " + str.hashCode());
		str = "Hello";
		System.out.println("str ���� ��  �ؽ��ڵ� : " + str.hashCode());
	}
}
