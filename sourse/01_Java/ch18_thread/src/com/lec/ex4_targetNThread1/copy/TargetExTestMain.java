package com.lec.ex4_targetNThread1.copy;
// target ��ü�� N��, ������� 1�� = 
public class TargetExTestMain {
	public static void main(String[] args) {
		Runnable targetA = new TargetEx(); //run()�Լ��� A�� num ����, A�� �ƴϸ� num-0
		Runnable targetB = new TargetEx();
		Thread threadA = new Thread(targetA, "A");
		Thread threadB = new Thread(targetB, "B");
		threadA.start();
		threadB.start();
		System.out.println("���� �Լ� ��");
	}
}
