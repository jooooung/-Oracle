//myPorsche, urPorsche ����� ����, ��ȸ�� color ���� 
//myPorsche cc���� �� "myPorsche color ���� ��ⷮ : cc" ����ϱ�
//myPorsche drive, park, race ����ϱ�
package com.lec.ex;

public class CarMain {
	public static void main(String[] args) {
		Car myPorsche = new Car(); // Car�� �̿��Ͽ� myPorsche �����
		myPorsche.setColor("����");
		myPorsche.setCc(2000);
		System.out.println(myPorsche.getColor() + "�� ���� ��ⷮ : " + myPorsche.getCc());  //setColor�� getColor�� �ҷ�����, setCc �� getCc�� ��������
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		Car urPorsche = new Car(); // Car�� �̿��Ͽ� urPorsche �����
		urPorsche.setColor("��ȸ");
		urPorsche.drive();
		System.out.println("�� �� �ӵ� : " + myPorsche.getSpeed()); // ������ �ӵ��� race�� 120�̾��� ������ getSpeed = 120
	}
}

//myPorsche �� urPorsche�� drive �ӵ��� �ٸ� �� drive�� �ƴ� �ٸ� ������ ����� ����ؾ� �ϳ�?