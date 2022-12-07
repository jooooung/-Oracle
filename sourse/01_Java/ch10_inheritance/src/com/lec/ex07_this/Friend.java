//this.~ : �� ��ü�� ~
//this() : �� Ŭ������ ������ �Լ�
package com.lec.ex07_this;

public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("�Ű����� ���� ������");
	}
	public Friend(String name) {
		this(); // == Friend()
		this.name = name;
		System.out.println("�Ű����� 1���� ������");
	}
	public Friend(String name, String tel) {
		this(name); // = Friend(name)
		this.tel = tel;
		System.out.println("�Ű����� 2���� ������");
	}
	public String infoString() {
		return name + " : " + tel;
	}
}
