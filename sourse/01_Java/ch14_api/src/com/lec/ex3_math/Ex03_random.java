//1 <= (int)(Math.random()*45)+1 < 46
package com.lec.ex3_math;

import java.util.Random;

// 0 <= Math.random() < 1 1�� double ����
// Random random = new Random()
public class Ex03_random {
	public static void main(String[] args) {
		System.out.println("1~45���� ���� ���� : " + (int)(Math.random()*45+1));
		Random random = new Random();
		System.out.println("int ���� : " + random.nextInt());  //���� ����
		System.out.println("Double ���� : " + random.nextDouble());  //�Ǽ� ����
		System.out.println("true/false �� ���� : " + random.nextBoolean());
		System.out.println("0~100������ ���� ���� : " + random.nextInt(101));   // 0~100������ ���� ����
		System.out.println("1~45������ ���� ���� : " + (random.nextInt(45)+1));   // 0~100������ ���� ����
		System.out.println("����(0), ����(1), ���ڱ�(2) �� �ϳ� : " + random.nextInt(3));
	}
}
