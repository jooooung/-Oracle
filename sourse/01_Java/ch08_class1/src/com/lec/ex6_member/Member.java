/*�޼ҵ� : �����̵� = aaa
                 �̸� = ȫ�浿
                 �̸��� = hong@company.com
                 �ּ� = ���� ������
                 ���� = 2000-01-01
                 ���� = �� ��
*/
package com.lec.ex6_member;

public class Member {
	private String id;
	private String password;
	private String name;
	private String email;
	private String add;
	private String birth;
	private char gender;
	
	public Member() {}

	public Member(String id, String password, String name, String email, String add, String birth, char gender) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.add = add;
		this.birth = birth;
		this.gender = gender;
	}
	public void print() {
		System.out.println("id : " + id);
		System.out.println("�̸� : " + name);
		System.out.println("�̸��� : " + email);
		System.out.println("�ּ� : " + add);
		System.out.println("���� : " + birth);
		System.out.println("���� : " + gender);
	}
	public String infoString() {
		String result = "id : " + id;
		result += "\n�̸� : " + name;
		result += "\n�̸��� : " + email;
		result += "\n�ּ� : " + add;		
		result += "\n���� : " + birth;		
		result += "\n���� : " + (gender == '��' ? "����" : (gender == '��' ? "����" : "��"));
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
