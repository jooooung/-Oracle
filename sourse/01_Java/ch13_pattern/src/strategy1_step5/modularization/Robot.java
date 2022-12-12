package strategy1_step5.modularization;

import strategy1_step4.interfaces.FlyImpl;
import strategy1_step4.interfaces.KnifeImpl;
import strategy1_step4.interfaces.MissileImpl;

public class Robot {
	private FlyImpl fly;
	private MissileImpl missile;
	private KnifeImpl knife;

	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�");
	}

	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�");
	}

	public void shape() {
		String className = getClass().getName(); // Ŭ���� �̸�
		int idx = className.lastIndexOf("."); // idx �� Ŭ���� �̸��� .�̴�
		String name = className.substring(idx + 1); // name �� Ŭ���� �̸��� . +1 �����̴�
		System.out.println(name + "�� ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�");
	}

	public void actionFly() {
		fly.fly();
	}

	public void actionMissile() {
		missile.missile();
	}

	public void actionKnife() {
		knife.knife();
	}

	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}
}
