package com.lec.ex06_toy;

public class AirPlaneToy implements IMissile, ILight {
	public AirPlaneToy() {
		System.out.println("������Դϴ�");
		canLight();
		canMissile();
	}
	@Override
	public void canLight() {
		// TODO Auto-generated method stub
		System.out.println("�Һ��ݻ� �� �� �ֽ��ϴ�");
	}

	@Override
	public void canMissile() {
		// TODO Auto-generated method stub
		System.out.println("�̻��� �� �� �ֽ��ϴ�");
	}
}
