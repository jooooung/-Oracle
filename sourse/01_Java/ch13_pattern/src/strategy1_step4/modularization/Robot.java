package strategy1_step4.modularization;

public abstract class Robot {
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�");
	}
	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�");
	}
	public void shape() {
		String className = getClass().getName();   //Ŭ���� �̸�
		int idx = className.lastIndexOf(".");     //idx �� Ŭ���� �̸��� .�̴�
		String name = className.substring(idx+1);  // name �� Ŭ���� �̸��� . +1 �����̴�
		System.out.println(name + "�� ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�");
	}
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
}
