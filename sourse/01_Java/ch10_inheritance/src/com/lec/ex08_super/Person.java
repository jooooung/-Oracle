//super.~ : �θ� Ŭ������ ~
//super() : �θ� Ŭ������ ������ �Լ�
package com.lec.ex08_super;

public class Person {
	private String name;
	private String character;
	public Person() {
		System.out.println("�Ű����� ���� Person ������");
	}
	public Person(String name, String character) {
		this.name = name;
		this.character = character;
		System.out.println("�Ű����� 2��¥�� Person ������");
	}
	public void intro() {   //return ���� method ����
		System.out.println("��" + name + "��" + character );
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
}
