package com.lec.ex06_toy;

public class MazingerToy implements IMoveArmLeg, IMissile {
	public MazingerToy() {
		System.out.println("��¡���Դϴ�");
		canMoveArmLeg();
		canMissile();
	}
	@Override
	public void canMissile() {
		// TODO Auto-generated method stub
		System.out.println("�̻����� �� �� �ֽ��ϴ�");
	}

	@Override
	public void canMoveArmLeg() {
		// TODO Auto-generated method stub
		System.out.println("�ȴٸ��� ������ �� �ֽ��ϴ�");
	}
}
