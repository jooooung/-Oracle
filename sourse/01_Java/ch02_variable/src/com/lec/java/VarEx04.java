package com.lec.java;

public class VarEx04 {
	public static void main(String[] args) {
		// ���� ������ ��ġ ���� x, ���� ������ ���� ��õ
		char c = '��';  //2byte
		int i = 20;   //4byte
		long l = 2200000000L; //L�� ū �� �ν�  //8byte
		System.out.println("l = "+l);
		
		boolean b = true;  //1byte    //���̽㿡�� True, �ڹٿ��� true(t�� ��ҹ��� ����)
		System.out.println("b ="+b);
		
		float f = 3.14159265359F;  //�Ҽ��������� float�̶� �ν����ֱ�  //4byte
		double d = 3.14159265359;  //8byte
		System.out.println("f="+f);
		System.out.println("d="+d);
		if(f == d) {
			System.out.println("f�� d���� ����");
		}else {
			System.out.println("f�� d���� �ٸ���");
		}
		
		f = 10.1F;
		d = 10.1;
		System.out.println("f="+f);
		System.out.println("d="+d);
		if(f == d) {
			System.out.println("f�� d���� ����");
		}else {
			System.out.println("f�� d���� �ٸ���");     
			//���� ���̱⿡�� 10.1�� ������ �����δ� �ٸ�, ���� �ٸ��ٶ�� ��µ�
		}
		// ����(4byte)�� �Ǽ�(8byte)�� ������ ��� : i+d(8byte)
		System.out.println("i + d =" +(i+d) );
		// ����(4byte)�� ����(4byte)�� ������ ��� : 4byte
		System.out.println("i / 7 =" +(i/7) );      //�ڹٿ����� ������ �� �� ���
	}
}
