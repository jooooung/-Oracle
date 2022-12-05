/*name, age, gender�� �����ͷ� ����, 
������ ������ ����ϴ� print() �޼Ҵ��� ���� PersonInfo Ŭ������ �����ϰ� main�Լ��� �̿��Ͽ� test �����Ͻÿ�(
print() �޼ҵ� ���� ��� : �̸�=ȫ�浿, ����=20, ����=m, main �޼ҵ� �ȿ��� PersonInfo�� ��ü �ν��Ͻ��� �迭�� ������ ���ϴ�)
*/
//new PersonInfo(name, age, gender)
package com.lec.ex5_personinfo;

public class PersonInfo {
	private String name;
	private int age;
	private char gender;

	public PersonInfo() {
	}

	public PersonInfo(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public void print() {
		System.out.println("�̸� : " + name); 
		System.out.println("���� : " + age); 
		System.out.println("���� : " + (gender=='m'? "����" : (gender=='f' ? "����" : "��"))); 
	}

	public String infoString() {
		// String result = "�̸� : " + name + "\n���� : " + age + "\n���� : " + gender;
		String result = "�̸� : " + name;
		result += "\n���� : " + age;
		result += "\n���� : " + (gender == 'm' ? "����" : (gender == 'f' ? "����" : "��"));
		return result;
	}
}
