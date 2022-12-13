package com.lec.ex1_string;

public class Ex09_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		StringBuffer strbuffer = new StringBuffer("abc");
		System.out.println("strBuffer�� �ؽ��ڵ� : " + strbuffer.hashCode());
		strbuffer.append("def");   //�ڿ� def �߰�
		System.out.println("append �� : " + strbuffer);
		System.out.println("strBuffer�� �ؽ��ڵ� : " + strbuffer.hashCode());
		strbuffer.insert(3, "aaa");   //3��°�� aaa �߰�
		System.out.println("insert �� : " + strbuffer);
		System.out.println("strBuffer�� �ؽ��ڵ� : " + strbuffer.hashCode());
		strbuffer.delete(3, 6);
		System.out.println("delete �� : " + strbuffer);
		System.out.println("strBuffer�� �ؽ��ڵ� : " + strbuffer.hashCode());
		int capacitySize = strbuffer.capacity();
		System.out.println("������ ����ũ�� :" + capacitySize);
		strbuffer.append("abcefjhksjdhfhfhfhffhfhfhhfh");
		System.out.println("append �� : "+strbuffer);
		System.out.println("�ؽ��ڵ� : " + strbuffer.hashCode());
		System.out.println("���� ���ڸ� �߰��� �� ����ũ�� : " + strbuffer.capacity());
	}
}

//append(String str) : ���ڿ� str �߰�
//insert(int index, String str) : Ư�� index�� ���ڿ� str �߰�
//delete(int start, int end) : index��ġ start���� end�� ���� ����
//deleteCharAt(int index) : index��ġ�� Ư�� ���� �ϳ� ����
//int capacity() : ���ڿ� ũ�� ��ȯ
//ensureCapacity(int size) : ������ ũ�⸦ size��ŭ �ø��� �޼ҵ�
//trimToSize() : ������ ���� ũ�⸦ �����ϰ� ���̴� �޼ҵ�
