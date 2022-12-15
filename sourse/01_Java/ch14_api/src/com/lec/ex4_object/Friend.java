package com.lec.ex4_object;

public class Friend {
	private String name;
	private String tel;
	private String birth; // �⵵ ���� �� �� �� ����
	private String address;

	public Friend() {}
	public Friend(String name, String tel, String birth, String address) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
    @Override
    public String toString() {
    	return "[�̸�]"+name + "[��ȭ��ȣ]"+tel +"[����]"+birth + "[�ּ�]"+address;
    }
    
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getAddress() {
		return address;
	}
	public String getBirth() {
		return birth;
	}
}
