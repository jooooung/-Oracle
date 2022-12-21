package com.lec.ex1_runnable;

public class Ex02_TargetExTestMain {
	public static void main(String[] args) {
		Runnable target01 = new TargetEx01();
		Runnable target02 = new TargetEx02();
		//A��� �̸��� ������ ���� - �ȳ��ϼ��� 10�� ������ ������
		Thread threadA = new Thread(target01);
		threadA.setName("A");
		//�̸� �ڵ����� ������ ����
		Thread threadB = new Thread(target02);
		threadA.start();
		threadB.start();
		for (int i = 0; i < 10 ; i++) {
			System.out.println("����" + Thread.currentThread().getName() + "�� i = " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
		}
	}
}
