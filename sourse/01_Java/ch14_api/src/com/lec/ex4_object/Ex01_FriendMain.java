package com.lec.ex4_object;

public class Ex01_FriendMain {
	public static void main(String[] args) {
		Friend[] friends = { new Friend("ȫ�浿", "010-9999-9999", "12-14", "���� ���빮"),
				new Friend("��浿", "010-9999-3333", "12-26", "���� ����"),
				new Friend("���ȯ", "010-9999-1111", "02-17", "���� ���"),
	 			new Friend("�ź���", "010-6666-6666", "03-03", "��õ �۵�") };
		for(Friend friend : friends) {
			System.out.println(friend.toString());   //friend class
			
		}
	}
}
