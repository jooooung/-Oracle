// speed, running(), stop(final) final �̱⿡ ��� �Ұ� 
package com.lec.ex10_final;

public class Dog extends Animal {
	@Override
	public void running() {
		speed += 10;
		System.out.println("�������� �ٸ鼭 ������ �����. ���� �ӵ� : " + speed);
	}
}