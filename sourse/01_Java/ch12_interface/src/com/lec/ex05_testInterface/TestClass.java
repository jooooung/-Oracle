//i1, i2, i3, m1(), m2(), m3()       ��������Ʈ �߱⿡ �߻��� �ƴ� �Ϲ� �޼ҵ�
package com.lec.ex05_testInterface;

public class TestClass implements I3 {

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("��� i1 = " + i1);
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("��� i2 = " + i2);
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		System.out.println("��� i3 = " + i3);
	}
}
