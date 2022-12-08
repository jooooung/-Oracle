//HighGradeCar low = new HighGradeCar("����", "�Ϲ�Ÿ�̾�", 2000, "�Ŀ��ڵ�")
//high.getSpec()
package com.lec.ex05_car;

public class HighGradeCar extends Car {
	private int tax;

	public HighGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		tax = 100000;
	}

	@Override
	public void getSpec() { // tax�� ������ Spec�� ���
		if (getDisplacement() > 1500) {
			tax += (getDisplacement() - 1500) * 600;
		}
		System.out.println("��  �� : " + getColor());
		System.out.println("Ÿ�̾� : " + getTire());
		System.out.println("��ⷮ : " + getDisplacement());
		System.out.println("��  �� : " + getHandle());
		System.out.println("��  �� : " + tax);
		System.out.println("=============================");
	}
}
