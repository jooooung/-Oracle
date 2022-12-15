/*
���� �޼ҵ� (Clone)  
��� ����  Implemetns Cloneable ���ְ� 
���� �޼ҵ� clone�� �������̵�������Ѵ�
new Rectangle(10, 5, "����")   new(10, 5)  new Rectangle()  new Rectangle("���") �簢�� �����
*/
package com.lec.ex4_object;

public class Rectangle implements Cloneable {
	private int width;
	private int height;
	private String color;

	public Rectangle() {
		color = "����";
	}

	public Rectangle(String color) {
		this.color = color;
	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		color = "����";
	}

	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}

	@Override
	public String toString() { // ��ü�� ������ ��Ʈ������ return
//		return "����" + width + "cm" + "����" + height + "cm��" + color + "�� �簢��";
		return String.format("���� %dcm ����%dcm�� %s�� �簢��", width, height, color);
	}

	@Override
	public boolean equals(Object obj) { // r1.equals(r2) => r1�� this, r2�� obj
		if (obj != null && getClass() == obj.getClass()) {
			Rectangle other = (Rectangle) obj; // Rectangle�� ����ȯ�� obj�� other
			boolean widthChk = width == other.width;
			boolean heightChk = height == other.height;
			boolean colorChk = color.equals(other.color);
			return widthChk && heightChk && colorChk;
//			return width==other.width && height==other.height && color.equals(other.color);
		}
		return false;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}