package strategy1_step3;

public class StandardRobot extends Robot {
	@Override
	public void actionFly() {
		System.out.println("�� �� �����ϴ�");
	}
	@Override
	public void actionMissile() {
		System.out.println("�̻����� �� �� �ֽ��ϴ�");
	}
	@Override
	public void actionKnife() {
		System.out.println("����� �ֽ��ϴ�");
	}
}
