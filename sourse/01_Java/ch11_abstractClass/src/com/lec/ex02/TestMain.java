package com.lec.ex02;

public class TestMain {

	public static void main(String[] args) {
		SuperClass obj = new ChildClass(); // SuperClass�� Ÿ�����θ� ����, ��ü������ �Ұ���
		obj.method1();
		obj.method2();
		obj.method3();
		SuperClass sObj = new SuperClass() {

			@Override
			public void method1() {
				System.out.println("�͸�Ŭ������method1");
			}
		}; // �̸����� Ŭ���� ����(�ַ� �ȵ���̵忡�� ���)
		sObj.method1();
		sObj.method2();
		sObj.method3();
	}// main
}// class
