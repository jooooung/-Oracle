package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ex04_FriendArrayList {
	public static void main(String[] args) {
		ArrayList<Friend> friends = new ArrayList<Friend>();
		friends.add(new Friend("ȫ�浿", "010-9999-9999"));
		friends.add(new Friend("�̱浿", "010-1111-9999", new Date(new GregorianCalendar(1998, 0, 1).getTimeInMillis()))); //1998
		friends.add(new Friend("���浿", "02-222-9999"));
		System.out.println("��ȭ��ȣ�� ���");
		for(Friend friend : friends) {
			System.out.println(friend.getTel());
		}
	}
}
