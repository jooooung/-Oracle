package com.lec.ex;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car(); // Car�� �̿��Ͽ� myPorsche �����
		myPorsche.setColor("����");
		System.out.println(myPorsche.getColor() + "�� ���� ��ⷮ : " + myPorsche.getCc());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		Car urPorsche = new Car(); // Car�� �̿��Ͽ� urPorsche �����
		urPorsche.setColor("��ȸ");
		urPorsche.drive();
		System.out.println("�� �� �ӵ� : " + myPorsche.getSpeed());
	}
}
