package com.lec.ex3_set;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import com.lec.ex1_list.Friend;

public class Ex03_IteratorEx {
	public static void main(String[] args) {
		// 1. list �迭
		ArrayList<String> list = new ArrayList<>();
		list.add("SAMPLE1");
		list.add("SAMPLE2");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "\t");
		}
		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		System.out.println();
		for (String temp : list) {
			System.out.print(temp + "\t");
		}
		System.out.println("\n = = = 2. Map �迭 = = =");
		HashMap<String, Friend> map = new HashMap<>();
		map.put("ȫ�浿", new Friend("ȫ�浿", "010-9999-9999"));
		map.put("��浿", new Friend("��浿", "010-4444-5555", new Date(new GregorianCalendar(95, 0, 1).getTimeInMillis())));
		map.put("�̱浿", new Friend("�̱浿", "010-7777-6666"));
		Iterator<String> iterator2 = map.keySet().iterator();    //map�� key���� ���ؼ� get
		while(iterator2.hasNext()) {
			String key = iterator2.next();
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("\n = = = 3. Set �迭 = = =");
		HashSet<Friend> set = new HashSet<>();
		set.add(new Friend("ȫ�浿", "010-9999-9999"));
		set.add(new Friend("��浿", "010-4444-5555"));
		set.add(new Friend("�̱浿", "010-7777-6666"));
		Iterator<Friend> iterator3 = set.iterator();
		while(iterator3.hasNext()) {
			System.out.println(iterator3.next());   // set�� add�� ������� ��� x  �Ȱ��� �����͸� �־ add ���� 
		}
	}
}
