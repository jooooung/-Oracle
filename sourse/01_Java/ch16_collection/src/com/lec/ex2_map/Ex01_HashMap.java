package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();   //ArrayList
		list.add("aaa");
		System.out.println(list.get(0));   //�ε����� key
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();  // key �� = Integer
		hashMap.put(11, "str11");   //key(11)�� ������ ��
		hashMap.put(12, "str11");
		hashMap.put(20, "str20");
		hashMap.put(33, "str33");
		System.out.println(11+ "key���� �����ʹ� " + hashMap.get(11));
		System.out.println(hashMap);
		hashMap.remove(12);   //remove ���ÿ��� key �����θ� �̿�
		System.out.println("remove �� : " + hashMap);
		hashMap.clear();
		System.out.println(hashMap.isEmpty() ? "������ ��� ����" : "������ ����");
		// ���
		hashMap.put(0, "hong gilldong");
		hashMap.put(10, "kim dongil");
		hashMap.put(22, "Lee sonnsin");
		hashMap.put(40, "yu ain");
		Iterator<Integer> iterater = hashMap.keySet().iterator();    //�ݺ���
		while(iterater.hasNext()) {
			Integer key = iterater.next();
			System.out.println(key + "�� �����ʹ�" + hashMap.get(key));
		}
	}
}