// class �տ� final�� ��⿡ Rabbit ��� ����
// speed, running(), stop(final)
package com.lec.ex10_final;

public final class Rabbit extends Animal {
	@Override
	public void running() {
	speed += 30;
	System.out.println("�䳢�� ���� ���� �پ��. ���� �ӵ� : " + speed);
	}
}