//private(name, character) public(intro())
package com.lec.ex08_super;

public class Baby extends Person{
	public Baby() {
		super();
		System.out.println("�Ű����� ���� ������");
	}
	public Baby(String name, String character) {
		super(name, character); // ==Person(name, character)
		System.out.println("�Ű����� �ִ� Baby ������");
	}
	@Override
	public void intro() {
		System.out.print("���̻� �Ʊ�");
		super.intro(); // �θ�Ŭ������ intro()
	}
}
