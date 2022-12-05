package com.lec.ex2_human;
//Man kim = new Man();		�Ű����� ����
//Man kim = new Man("ȫ�浿");		�̸��� �ִ� �Ű�����
//Man kim = new Man("ȫ�浿", 22, 170, 65);		�̸�, ����, Ű, ������ ���ִ� �Ű�����
public class Man {
	private String name;
	private int age;
	private int height;
	private double weight;
	// �����ڰ� ������ �Լ��� ����� �����Ϸ��� ����Ʈ ������ �Լ��� ������ �ʴ´�
	// ���� ������ �Լ��� ����� ����Ʈ ������ �Լ��� �ʿ��ϸ� ������ �Ѵ�
	public Man() {
		System.out.println("�Ű����� ���� ������ �Լ�");
	}
	public Man(String name, int age, int height, double weight) {
		this.setName(name);
		this.setAge(age);
		this.height = height;
		this.weight = weight;
		System.out.println("������ 4�� �ʱ�ȭ�ϴ� ������ �Լ�");
	}
	public Man(String name) {
		System.out.println("�̸� �ʱ�ȭ�ϴ� ������ �Լ�");
	}
	public Man(int height) {
		this.height = height;
	}
	public Man(double weight) {
		this.weight = weight;
	}
	public double calculateBMI() {//��ü�ȿ� height�� weight�� BMI ���� return
		double result = weight / ( (height*0.01) * (weight*0.01) );
		return result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
