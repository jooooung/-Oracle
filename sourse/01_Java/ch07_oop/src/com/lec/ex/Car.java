package com.lec.ex;
// Ŭ���� : �Ӽ�(������)�� �޼�Ʈ
// Car mycar = new Car();   mycar��� ��ü�� ����
// mycar.park()      mycar
public class Car {
	private String color;  
	private int    cc;
	private int    speed;
	public void park() {          // void�� ������ �� �� �� ���
		speed = 0;
		System.out.println(color + "�� �� �����Ѵ�. ���� �ӵ� : " + speed);
	}
	public void drive() {
		speed = 60;
		System.out.println(color + "�� �� �����Ѵ�. ���� �ӵ� : " + speed);
	}
	public void race() {
		speed = 120;
		System.out.println(color + "�� �� ���̽��Ѵ�. ���� �ӵ� : " + speed);
	}
	//getter & setter (color, cc, speed)
	//Car car = new Car(); car,getColor()
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;		//this.color : �� ��ü ���� color		
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}