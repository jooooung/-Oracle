//name, tel, infoString
package com.lec.ex09_customer;

public class Staff extends Person {
	private String hiredate; // �Ի��� ("2000-12-12")
	private String deparment; // �μ�
	// Staff s = new Staff("ȫ���", "010-8888-8888", "2022-12-01", "�����")

	public Staff(String name, String tel, String hiredate, String deparment) {
		super(name, tel);
		this.hiredate = hiredate;
		this.deparment = deparment;
	}
	@Override
	public String infoString() {
		return super.infoString() + "   [�μ�]" + deparment + "   [�Ի���]" + hiredate;
	}
}
