//LowGradeCar low = new LowGradeCar("����", "�Ϲ�Ÿ�̾�", 1000, "�Ŀ��ڵ�")
//low.getSpec()
package com.lec.ex05_car;

public class LowGradeCar extends Car {
	private int tax;

	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
		tax = 0;
	}

	@Override
	public void getSpec() { // tax�� ������ Spec�� ���
		if (getDisplacement() > 900) {
			tax += (getDisplacement() - 900) * 500;
		}
		System.out.println("��  �� : " + getColor());
		System.out.println("Ÿ�̾� : " + getTire());
		System.out.println("��ⷮ : " + getDisplacement());
		System.out.println("��  �� : " + getHandle());
		System.out.println("��  �� : " + tax);
		System.out.println("=============================");
	}
}
