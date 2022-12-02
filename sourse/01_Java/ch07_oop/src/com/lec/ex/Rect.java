package com.lec.ex;
// Ŭ���� : �Ӽ�, (������) �޼ҵ�, setter&getter
public class Rect {
	private int width;
	private int height;
	//�����ڰ� ���� ��� JVM�� �ڵ� ����
	public Rect() {}  //����Ʈ ������
	public Rect(int side) { //�Ű����� 1��¥�� ������ �Լ�
		width = side;
		height = side;
	}
	public Rect(int width, int height) { //�Ű����� 2��¥�� ������ �Լ�
		this.width = width;
		this.height = height;
	}
	public int area() {
		return width*height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
