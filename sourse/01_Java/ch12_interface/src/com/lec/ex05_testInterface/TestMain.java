package com.lec.ex05_testInterface;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestChildClass obj = new TestChildClass();
		System.out.println(obj.i1);	// static ������ class �̸����� ���� ��õ
		System.out.println(TestChildClass.i1);
		obj.m1();
		obj.m2();
		obj.m3();
		obj.m11();
		TestClass obj1 = obj;
//		obj1.m11(); �ȵ�
	}
}
