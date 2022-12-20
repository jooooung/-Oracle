// �Ӽ�, ������, �޼ҵ�, getter&setter(�ܺο��� �������� ������ ���x)
// Square s = new square();  s��� ���ο� square ����, s��side�� 0���� �ʱ�ȭ
// Square s1 = new square(10);  // s��side�� 10���� �ʱ�ȭ�ϸ鼭 ��ü ����
package com.lec.ex1_square;

public class Square {
	private int side; // side ��� ���μ��� ���� ����

	public Square() { // �Ű� ���� ���� Square �Լ� ����
		System.out.println("�Ű����� ���� ������ �Լ� ȣ��");
	} // ������ �Լ� : return type ���� Ŭ������� ���� �Լ�

	public Square(int side) { // �Ű������� �ִ� ������ �Լ� �뵵 : �������� �ʱ�ȭ
		this.side = side;
		System.out.println("�Ű����� �ִ� ������ �Լ� ȣ��");
	}

	public int area() { // ���̸� ���ϴ� area ����
		return side * side;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
	
}
