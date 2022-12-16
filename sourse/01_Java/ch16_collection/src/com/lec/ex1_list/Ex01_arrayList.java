package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_arrayList { // arrayList ũ�Ⱑ ���������� �ʴ�  add�� ��ŭ �þ
	public static void main(String[] args) {
		String[] array = new String[3];
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		for (String arr : array) {
			System.out.println(arr);
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + "�� �ε��� ��" + array[i]);
		}
		System.out.println("---------ArrayList-----------");
		ArrayList<String> arrayList = new ArrayList<String>(); // String ArrayList
		System.out.println("���� arrayList�������" + arrayList.size());
		arrayList.add("str0"); // 0�� �ε���
		arrayList.add("str1"); // 1�� �ε���
		arrayList.add("str2"); // 2�� �ε���
		arrayList.add(1, "11111");   //1�� �ε����� 11111�� �־��   1�� -> 2��, 2��-> 3������ �и���
		System.out.println("���� arrayList�������" + arrayList.size());
		System.out.println(arrayList);
		arrayList.set(1, "----");     //1�� �ε��� �� ����
		arrayList.add("str4");
		for(String temp : arrayList) {
			System.out.print(temp + "\t");
		}
		System.out.println();
		for(int i=0 ; i<arrayList.size() ; i++) {
			System.out.println(i + "��° �ε��� �� : " + arrayList.get(i));
		}
		arrayList.remove(1); //1�� �ε��� ����     �� �ε����� �մ������
		arrayList.remove(arrayList.size()-1); //�� ������ �ε��� �� ����
		System.out.println("remove�� " + arrayList);
		arrayList.clear();  // arrayList�� ��� ������ ����
		System.out.println(arrayList.isEmpty() ? "arrayList ����� 0" : "arrayList ����� 0�� �ƴϴ�");
		arrayList = null;      //arrayList ��ü�� ����
		System.out.println(arrayList);
	}
}
